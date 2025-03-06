package com.jobportal.job_portal_app.dao;

import com.jobportal.job_portal_app.bean.JobPostActivity;
import com.jobportal.job_portal_app.bean.JobSeekerApply;
import com.jobportal.job_portal_app.bean.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component

@Repository
public interface JobSeekerApplyRepository extends JpaRepository<JobSeekerApply, Integer> {

    List<JobSeekerApply> findByUserId(JobSeekerProfile userId);

    List<JobSeekerApply> findByJob(JobPostActivity job);
}
