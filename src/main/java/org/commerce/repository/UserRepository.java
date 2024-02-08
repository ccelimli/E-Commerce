package org.commerce.repository;

import org.commerce.model.User;
import org.commerce.model.dto.Response.GetUserByIdResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
