package java13_urok.dao.daoImpl;

import java13_urok.config.DataBaseConfig;
import java13_urok.dao.EmployeeDao;
import java13_urok.models.Employee;
import java13_urok.models.Job;

import java.sql.*;
import java.util.*;

public class EmployeeDaoImpl implements EmployeeDao {
    private final Connection connection = DataBaseConfig.getConnection();
    @Override
    public void createEmployee() {
        String sql = """
                create table if not exists employees(
                id serial primary key,
                first_name varchar,
                last_name varchar,
                age int,
                email varchar,
                job_Id int references jobs(id));
                """;
            try (Statement statement = connection.createStatement()){
                statement.executeUpdate(sql);
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }

    }

    @Override
    public void addEmployee(Employee employee) {
    String sql = """
            insert into employees (first_name,last_name,age,email,job_Id )
            values (?, ?, ?, ?, ?)
            """;
            try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                preparedStatement.setString(1,employee.getFirstName());
                preparedStatement.setString(2,employee.getLastName());
                preparedStatement.setInt(3,employee.getAge());
                preparedStatement.setString(4,employee.getEmail());
                preparedStatement.setLong(5,employee.getJobId());
                preparedStatement.executeUpdate();
                System.out.println("Job added successfully!");
                }catch (SQLException e){
                System.out.println(e.getMessage());
            }
    }

    @Override
    public void dropTable() {
    String sql = "drop table if not exists employees";
    try (Statement statement = connection.createStatement()){
        statement.executeUpdate(sql);
        System.out.println("Table successfully deleted!");

    }catch (SQLException e){
        System.out.println(e.getMessage());
         }
    }


    @Override
    public void cleanTable() {
        String sql = "truncate table employees";
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Table successfully cleaned!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        String sql = """
                update employees set
                first_name = ?,
                full_name = ?,
                age = ?,
                email = ?,
                job_Id =?
                """;
        try {
            PreparedStatement preparedStatement  = connection.prepareStatement(sql);
            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2,employee.getLastName());
            preparedStatement.setInt(3,employee.getAge());
            preparedStatement.setString(4,employee.getEmail());
            preparedStatement.setInt(5,employee.getJobId());

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "select * from employees";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setAge(resultSet.getInt("age"));
                employee.setEmail(resultSet.getString("email"));
                employee.setJobId(resultSet.getInt("job_Id"));
                employees.add(employee);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return employees;
    }

    @Override
    public Employee findByEmail(String email) {

        Employee employee1 = null;

        String sql = "select * from employees where email = ? ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,email);
            ResultSet resultSet =  preparedStatement.executeQuery();
            if(resultSet.next()){
                employee1 = new Employee();
                employee1.setId(resultSet.getLong("id"));
                employee1.setFirstName(resultSet.getString("first_name"));
                employee1.setLastName(resultSet.getString("last_name"));
                employee1.setAge(resultSet.getInt("age"));
                employee1.setEmail(resultSet.getString("email"));
                employee1.setJobId(resultSet.getInt("job_Id"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return employee1;
        }

    @Override
    public Map<Employee, Job> getEmployeeById(Long employeeId) {
        Map<Employee, Job> employeeJobMap = new HashMap<>();
        String sql = "select e.*, j.* from employees e inner join jobs j on e.job_id = j.id where e.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setAge(resultSet.getInt("age"));
                employee.setEmail(resultSet.getString("email"));
                employee.setJobId(resultSet.getInt("job_id"));

                Job job = new Job();
                job.setId(resultSet.getLong("job_id"));
                employeeJobMap.put(employee, job);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return employeeJobMap;
    }

    @Override
    public List<Employee> getEmployeeByPosition(String position) {

        List<Employee > employees = new ArrayList<>();
        String sql="select * from employees e inner join jobs j on j.id=e.job_id where j.position=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,position);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setFirstName(resultSet.getString("last_name"));
                employee.setAge(resultSet.getInt("age"));
                employee.setFirstName(resultSet.getString("email"));
                employee.setJobId(resultSet.getInt("job_id"));
                employees.add(employee);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return employees;
    }

}
