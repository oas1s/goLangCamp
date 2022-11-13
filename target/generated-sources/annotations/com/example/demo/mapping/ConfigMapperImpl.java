package com.example.demo.mapping;

import com.example.demo.dto.ConfigDto;
import com.example.demo.dto.ConfigDto.ConfigDtoBuilder;
import com.example.demo.dto.CreateConfigRequestDto;
import com.example.demo.entity.ConfigEntity;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-13T17:20:10+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
*/
@Component
public class ConfigMapperImpl implements ConfigMapper {

    @Override
    public ConfigEntity mapDtoToEntity(CreateConfigRequestDto createConfigRequestDto) {
        if ( createConfigRequestDto == null ) {
            return null;
        }

        ConfigEntity configEntity = new ConfigEntity();

        configEntity.service = createConfigRequestDto.getService();
        Map<String, String> map = createConfigRequestDto.getData();
        if ( map != null ) {
            configEntity.data = new HashMap<String, String>( map );
        }

        return configEntity;
    }

    @Override
    public ConfigDto mapEntityToDto(ConfigEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ConfigDtoBuilder configDto = ConfigDto.builder();

        configDto.service( entity.service );
        Map<String, String> map = entity.data;
        if ( map != null ) {
            configDto.data( new HashMap<String, String>( map ) );
        }
        configDto.version( entity.version );

        return configDto.build();
    }
}
