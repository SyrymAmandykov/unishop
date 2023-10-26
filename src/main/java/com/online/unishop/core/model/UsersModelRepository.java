package com.online.unishop.core.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersModelRepository extends JpaRepository<UsersModel,Long> {
}