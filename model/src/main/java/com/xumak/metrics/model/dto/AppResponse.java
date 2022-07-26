package com.xumak.metrics.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AppResponse {

    @JsonProperty("status")
    private boolean status;



}
