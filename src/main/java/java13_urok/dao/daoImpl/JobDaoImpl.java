package java13_urok.dao.daoImpl;

import java13_urok.config.DataBaseConfig;
import java13_urok.dao.JobDao;
import java13_urok.models.Employee;
import java13_urok.models.Job;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDaoImpl implements JobDao {
    private final Connection connection = DataBaseConfig.getConnection();
    @Override
    public void createJobTable() {
        String sql = """
                create table if not exists jobs(
                id serial primary key,
                position varchar,
                profession varchar,
                description varchar,
                experience varchar);
                """;
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Success");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void addJob(Job job) {
        String sql = """
                 insert into jobs (position, profession, description, experience)
                 values (? ,? , ? , ?)""";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1, job.getPosition());
                preparedStatement.setString(2, job.getProfession());
                preparedStatement.setString(3, job.getDescription());
                preparedStatement.setInt(4, job.getExperience());
               preparedStatement.executeUpdate();


                System.out.println("Job added successfully!");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Job getJobById(Long jobId) {
        Job job = new Job();
        String sql = """
                  select * from jobs where id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,jobId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                job.setId(resultSet.getLong("Id"));
                job.setPosition(resultSet.getString("position"));
                job.setProfession(resultSet.getString("profession"));
                job.setDescription(resultSet.getString("description"));
                job.setExperience(resultSet.getInt("experience"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return job;
    }

    @Override
    public List<Job> sortByExperience(String ascOrDesc) {
        List<Job> jobs = new ArrayList<>();
        String sql = "select * from jobs order by experience ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,ascOrDesc);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Job job = new Job();
                job.setId(resultSet.getLong("Id"));
                job.setPosition(resultSet.getString("position"));
                job.setProfession(resultSet.getString("profession"));
                job.setDescription(resultSet.getString("description"));
                job.setExperience(resultSet.getInt("experience"));
                jobs.add(job);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return jobs;
    }

    @Override
    public Job getJobByEmployeeId(Long employeeId) {
        Job job = new Job();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from jobs j inner join employees e  on e.job_id = ?")) {
            preparedStatement.setLong(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                job.setId(resultSet.getLong("id"));
                job.setPosition(resultSet.getString("position"));
                job.setProfession(resultSet.getString("profession"));
                job.setDescription(resultSet.getString("description"));
                job.setExperience(resultSet.getInt("experience"));}
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return job;
    }

    @Override
    public void deleteDescriptionColumn() {
        String sql = "alter table jobs drop column description";
        try (Connection connection = DriverManager.getConnection(sql)){
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
            System.out.println("Description column deleted successfully.");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}



