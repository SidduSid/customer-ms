package com.maveric.bankapp.repository;

import com.maveric.bankapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
    User findByFirstName(String name);
}
