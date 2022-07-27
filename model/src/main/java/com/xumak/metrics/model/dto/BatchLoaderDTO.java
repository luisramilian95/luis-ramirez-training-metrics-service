package com.xumak.metrics.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"timestamp", "fileName", "created", "pickedUp", "processed", "records"})
public class BatchLoaderDTO {

    private Long id;
    private Date timestamp;
    private String fileName;
    private Date created;
    private Date pickedUp;
    private Date processed;
    private Integer records;

}
