package java13_urok.services.serviceImpl;

import java13_urok.config.DataBaseConfig;
import java13_urok.dao.JobDao;
import java13_urok.dao.daoImpl.JobDaoImpl;
import java13_urok.models.Job;
import java13_urok.services.JobService;

import java.sql.Connection;
import java.util.List;

public class JobServiceImpl implements JobService {

    JobDao jobDao = new JobDaoImpl();

    @Override
    public void createJobTable() {
        jobDao.createJobTable();
    }

    @Override
    public void addJob(Job job) {
        jobDao.addJob(job);

    }

    @Override
    public Job getJobById(Long jobId) {
        return jobDao.getJobById(jobId);
    }

    @Override
    public List<Job> sortByExperience(String ascOrDesc) {
        return jobDao.sortByExperience(ascOrDesc);
    }

    @Override
    public Job getJobByEmployeeId(Long employeeId) {
        return jobDao.getJobByEmployeeId(employeeId);
    }

    @Override
    public void deleteDescriptionColumn() {
        jobDao.deleteDescriptionColumn();
    }
}
