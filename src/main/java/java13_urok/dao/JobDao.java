package java13_urok.dao;

import java13_urok.models.Job;

import java.util.List;

public interface JobDao {

    void createJobTable();
    void addJob(Job job);
    Job getJobById(Long jobId);
    List<Job> sortByExperience(String ascOrDesc);
    Job getJobByEmployeeId(Long employeeId);
    void deleteDescriptionColumn();
}
