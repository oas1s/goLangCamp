package com.example.demo.mapping;

import com.example.demo.dto.ConfigDto;
import com.example.demo.dto.CreateConfigRequestDto;
import com.example.demo.entity.ConfigEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConfigMapper {
    @Mapping(source = "service", target = "service")
    @Mapping(source = "data", target = "data")
    ConfigEntity mapDtoToEntity(CreateConfigRequestDto createConfigRequestDto);

    @Mapping(source = "service", target = "service")
    @Mapping(source = "data", target = "data")
    @Mapping(source = "version", target = "version")
    ConfigDto mapEntityToDto(ConfigEntity entity);

}
