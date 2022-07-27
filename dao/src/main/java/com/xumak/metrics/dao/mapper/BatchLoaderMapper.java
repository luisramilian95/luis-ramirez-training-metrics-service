package com.xumak.metrics.dao.mapper;

import com.xumak.metrics.model.BatchLoader;
import com.xumak.metrics.model.dto.BatchLoaderDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {BatchLoaderMapper.class})
public interface BatchLoaderMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "timestamp", source = "timestamp"),
            @Mapping(target = "created", source = "fileCreated"),
            @Mapping(target = "pickedUp", source = "filePickedUp"),
            @Mapping(target = "processed", source = "fileProcessed"),
            @Mapping(target = "records", source = "numberOfRecords")
    })
    BatchLoaderDTO toBatchLoaderDTO(BatchLoader batchLoader);
    List<BatchLoaderDTO> toBatchLoaderDTOs(List<BatchLoader> batchLoaders);

    @InheritInverseConfiguration
    BatchLoader toBatchLoader(BatchLoaderDTO batchLoader);
    List<BatchLoader> toBatchLoaders(List<BatchLoaderDTO> batchLoaders);
}
