package com.online.unishop.core.role.service;

import com.online.unishop.core.role.dto.RoleDto;
import com.online.unishop.core.role.model.RoleModel;

import java.util.List;

public interface RoleService {

    void addRole(String name);
    List<RoleDto> getAllRoles();
}
