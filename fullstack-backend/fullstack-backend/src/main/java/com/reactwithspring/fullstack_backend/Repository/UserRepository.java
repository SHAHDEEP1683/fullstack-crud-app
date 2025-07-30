package com.reactwithspring.fullstack_backend.Repository;

import com.reactwithspring.fullstack_backend.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
