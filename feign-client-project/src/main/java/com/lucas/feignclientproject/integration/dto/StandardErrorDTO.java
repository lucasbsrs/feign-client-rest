package com.lucas.feignclientproject.integration.dto;

import lombok.Data;

@Data
public class StandardErrorDTO {

    private Long timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
