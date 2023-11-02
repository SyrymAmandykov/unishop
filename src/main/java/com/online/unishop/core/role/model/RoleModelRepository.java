package com.online.unishop.core.role.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleModelRepository extends JpaRepository<RoleModel,Long> {

    RoleModel findByName(String roleName);
}
