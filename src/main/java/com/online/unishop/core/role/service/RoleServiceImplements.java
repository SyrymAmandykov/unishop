package com.online.unishop.core.role.service;

import com.online.unishop.core.role.dto.RoleDto;
import com.online.unishop.core.role.model.RoleModel;
import com.online.unishop.core.role.model.RoleModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImplements implements RoleService{

    private final RoleModelRepository roleModelRepository;

    @Override
    public void addRole(String name){
        roleModelRepository.save(
                new RoleModel(
                        null,
                        name
                )
        );
    }

    @Override
    public List<RoleDto> getAllRoles(){
        return roleModelRepository
                .findAll()
                .stream()
                .map(RoleModel::toDto)
                .collect(Collectors.toList());
    }
}
