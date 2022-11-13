package com.example.demo.controller;

import com.example.demo.dto.ConfigDto;
import com.example.demo.dto.CreateConfigRequestDto;
import com.example.demo.dto.UpdateConfigRequestDto;
import com.example.demo.entity.ConfigEntity;
import com.example.demo.entity.ConfigId;
import com.example.demo.mapping.ConfigMapper;
import com.example.demo.repository.ConfigRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ConfigController {

    private final ConfigMapper configMapper;
    private final ConfigRepository configRepository;

    @PostMapping("/config")
    public ResponseEntity createConfig(@RequestBody CreateConfigRequestDto createConfigRequestDto){
        configRepository.save(configMapper.mapDtoToEntity(createConfigRequestDto));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/config")
    public ResponseEntity<ConfigDto> createConfig(@RequestParam(name = "service") String service){
        Optional<ConfigEntity> configEntity = configRepository.findConfigEntityByService(service);
        return configEntity.map(entity -> ResponseEntity.ok().body(configMapper.mapEntityToDto(entity))).orElseGet(()
                -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/config")
    public ResponseEntity<ConfigDto> updateConfig(@RequestParam(name = "service") String service,
                                                  @RequestBody UpdateConfigRequestDto requestDto){
        Optional<ConfigEntity> configEntity = configRepository.findConfigEntityByService(service);
        if (configEntity.isPresent()){
            ConfigEntity configEntity1 = new ConfigEntity();
            configEntity1.data = requestDto.data;
            configEntity1.version = configEntity.get().version +1;
            configEntity1.service = service;
            return ResponseEntity.ok().body(configMapper.mapEntityToDto(configRepository.save(configEntity1)));
        } else {
            throw new RuntimeException("Entity not found");
        }

    }

    @DeleteMapping("/config")
    @Transactional
    public ResponseEntity deleteConfig(@RequestParam(name = "service") String service,
                                       @RequestParam(name = "version") Long version){
        configRepository.deleteByVersionAndService(version,service);
        return ResponseEntity.ok().build();
    }
}
