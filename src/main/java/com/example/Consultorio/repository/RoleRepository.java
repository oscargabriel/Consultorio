package com.example.Consultorio.repository;

import com.example.Consultorio.entities.Roles;
import jakarta.annotation.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends CrudRepository<Roles,Long> {
    Roles findRoleByNombre(String name);
}
