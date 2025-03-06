package com.jobportal.job_portal_app.dao;

import com.jobportal.job_portal_app.bean.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface JobSeekerProfileRepository extends JpaRepository<JobSeekerProfile, Integer> {
}
