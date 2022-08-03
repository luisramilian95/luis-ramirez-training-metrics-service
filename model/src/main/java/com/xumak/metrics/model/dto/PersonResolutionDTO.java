package com.xumak.metrics.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PersonResolutionDTO {
    private Long id;
    private Date timestamp;
    private Integer individualMatches;
    private Integer householdMatches;
    private Integer nonMatches;
    private Integer errors;
    private String endpoint;
}
