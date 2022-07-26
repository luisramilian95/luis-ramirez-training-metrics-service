package com.xumak.metrics.mapper;

import com.xumak.metrics.model.PersonResolution;
import com.xumak.metrics.model.dto.PersonResolutionDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PersonResolutionMapper.class})
public interface PersonResolutionMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "timestamp", source = "timestamp"),
            @Mapping(target = "individualMatches", source = "individualMatches"),
            @Mapping(target = "householdMatches", source = "householdMatches"),
            @Mapping(target = "nonMatches", source = "nonMatches"),
            @Mapping(target = "errors", source = "errors"),
            @Mapping(target = "endpoint", source = "endpoint")
    })
    PersonResolutionDTO toPersonResolutionDTO(PersonResolution personResolution);
    List<PersonResolutionDTO> toBatchLoaderDTOs(List<PersonResolution> personResolutions);


    @InheritInverseConfiguration
    PersonResolution toPersonResolution(PersonResolutionDTO personResolution);
    List<PersonResolution> toBatchLoaders(List<PersonResolutionDTO> personResolutions);

}
