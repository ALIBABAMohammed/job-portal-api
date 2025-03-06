package com.jobportal.job_portal_app.dao;

import com.jobportal.job_portal_app.bean.Users;
import com.jobportal.job_portal_app.bean.UsersType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersTypeRepository extends JpaRepository<UsersType, Long> {

}
