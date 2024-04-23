package java13_urok.services.serviceImpl;

import java13_urok.config.DataBaseConfig;
import java13_urok.dao.EmployeeDao;
import java13_urok.dao.daoImpl.EmployeeDaoImpl;
import java13_urok.models.Employee;
import java13_urok.models.Job;
import java13_urok.services.EmployeeService;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDao employeeDao = new EmployeeDaoImpl();
    @Override
    public void createEmployee() {
    employeeDao.createEmployee();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);

    }

    @Override
    public void dropTable() {
    employeeDao.dropTable();
    }

    @Override
    public void cleanTable() {
employeeDao.dropTable();
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
employeeDao.updateEmployee(id,employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeDao.findByEmail(email);
    }

    @Override
    public Map<Employee, Job> getEmployeeById(Long employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }

    @Override
    public List<Employee> getEmployeeByPosition(String position) {
        return employeeDao.getEmployeeByPosition(position);
    }
}
