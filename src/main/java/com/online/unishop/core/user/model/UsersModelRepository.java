package com.online.unishop.core.user.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersModelRepository extends JpaRepository<UsersModel, Long> {
    UsersModel findFirstByLoginAndPassword(String login, String password);
}
