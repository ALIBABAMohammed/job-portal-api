package com.jobportal.job_portal_app.dao;

import com.jobportal.job_portal_app.bean.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByEmail(String email);
}
