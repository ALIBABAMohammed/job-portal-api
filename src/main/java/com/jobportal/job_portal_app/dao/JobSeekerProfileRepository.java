package com.jobportal.job_portal_app.dao;

import com.jobportal.job_portal_app.bean.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerProfileRepository extends JpaRepository<JobSeekerProfile, Integer> {
}
