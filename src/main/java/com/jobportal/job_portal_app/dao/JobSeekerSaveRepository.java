package com.jobportal.job_portal_app.dao;

import com.jobportal.job_portal_app.bean.JobPostActivity;
import com.jobportal.job_portal_app.bean.JobSeekerProfile;
import com.jobportal.job_portal_app.bean.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Integer> {

    public List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);

    List<JobSeekerSave> findByJob(JobPostActivity job);

}
