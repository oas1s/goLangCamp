package com.example.demo.repository;

import com.example.demo.entity.ConfigEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfigRepository extends CrudRepository<ConfigEntity,String> {
    @Query(value = "SELECT * FROM config c WHERE c.service = ?1  AND c.version = (SELECT MAX(version) FROM config)",nativeQuery = true)
    Optional<ConfigEntity> findConfigEntityByService(String service);
    void deleteByVersionAndService(Long version, String service);
}
