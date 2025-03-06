package com.jobportal.job_portal_app.dao;

import com.jobportal.job_portal_app.bean.RecruiterProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component

@Repository
public interface RecruiterProfileRepository extends JpaRepository<RecruiterProfile, Integer> {

}
