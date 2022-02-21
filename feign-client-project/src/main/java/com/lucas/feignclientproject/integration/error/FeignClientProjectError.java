package com.lucas.feignclientproject.integration.error;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucas.feignclientproject.errors.exceptions.ObjectNotFoundException;
import com.lucas.feignclientproject.integration.dto.StandardErrorDTO;
import com.sun.jdi.InternalException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class FeignClientProjectError implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        try {
            StandardErrorDTO exceptionMessage = getStandardErrorDTO(response);

            switch (response.status()) {
                case 400:
                    return new Exception("Bad Request Through Feign");
                case 401:
                    return new Exception("Unauthorized Request Through Feign");
                case 404:
                    return new ObjectNotFoundException(exceptionMessage.getMessage());
                case 500:
                    return new InternalException(exceptionMessage.getError());
                case 504:
                    return new Exception(exceptionMessage.getError());
                default:
                    return new Exception("Common Feign Exception");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private StandardErrorDTO getStandardErrorDTO(Response response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        InputStream responseBodyIs = response.body().asInputStream();

        StandardErrorDTO exceptionMessage = mapper.readValue(responseBodyIs, StandardErrorDTO.class);
        return exceptionMessage;
    }
}
