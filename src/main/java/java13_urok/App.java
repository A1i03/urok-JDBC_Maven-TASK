package java13_urok;

import java13_urok.models.Employee;
import java13_urok.models.Job;
import java13_urok.services.EmployeeService;
import java13_urok.services.JobService;
import java13_urok.services.serviceImpl.EmployeeServiceImpl;
import java13_urok.services.serviceImpl.JobServiceImpl;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeServiceImpl();
        JobService jobService = new JobServiceImpl();
        while (true) {
            System.out.println("Команданы танданыз!!!");
            System.out.println("""
                    1.Job
                    2.Employee
                    """);

            switch (new Scanner(System.in).nextInt()) {
                case 2 -> {
                    boolean exit = true;
                    while (exit) {
                        System.out.println("Команданы танданыз: ");
                        System.out.println("""
                                1.createEmployee
                                2.addEmployee
                                3.dropTable
                                4.cleanTable
                                5.updateEmployee
                                6.getAllEmployees
                                7.findByEmail
                                8.getEmployeeById
                                9.getEmployeeByPosition
                                10.exit
                                """);
                        switch (new Scanner(System.in).nextInt()) {
                            case 1 -> {
                                System.out.println("Create table :");
                                employeeService.createEmployee();
                            }
                            case 2 -> {

                                System.out.println("add Employee: ");

                                Employee employee = new Employee();
                                System.out.println("Write firstName: ");
                                employee.setFirstName(new Scanner(System.in).nextLine());
                                System.out.println("Write lastName:  ");
                                employee.setLastName(new Scanner(System.in).nextLine());
                                System.out.println("Write age: ");
                                employee.setAge(new Scanner(System.in).nextInt());
                                System.out.println("Write email: ");
                                employee.setEmail(new Scanner(System.in).nextLine());
                                System.out.println("Write jobId: ");
                                employee.setJobId(new Scanner(System.in).nextInt());
                                employeeService.addEmployee(employee);
                            }
                            case 3 -> {
                                System.out.println("drop Table: ");
                                employeeService.dropTable();
                            }
                            case 4 -> {
                                System.out.println("clean Table : ");
                                employeeService.cleanTable();
                            }
                            case 5 -> {
                                System.out.println("update Employee :");
                                System.out.println("Write Id: ");
                                Long num = new Scanner(System.in).nextLong();
                                Employee employee = new Employee();
                                System.out.println("Write firstName: ");
                                employee.setFirstName(new Scanner(System.in).nextLine());
                                System.out.println("Write lastName:  ");
                                employee.setLastName(new Scanner(System.in).nextLine());
                                System.out.println("Write age: ");
                                employee.setAge(new Scanner(System.in).nextInt());
                                System.out.println("Write email: ");
                                employee.setEmail(new Scanner(System.in).nextLine());
                                System.out.println("Write jobId: ");
                                employee.setJobId(new Scanner(System.in).nextInt());
                                employeeService.updateEmployee(num, employee);
                            }
                            case 6 -> {
                                System.out.println("get All Employees :");
                                System.out.println(employeeService.getAllEmployees());
                            }
                            case 7 -> {
                                System.out.println("find By Email :");
                                System.out.println(employeeService.findByEmail(new Scanner(System.in).nextLine()));
                            }
                            case 8 -> {
                                System.out.println("get Employee ById :");
                                System.out.println(employeeService.getEmployeeById(new Scanner(System.in).nextLong()));
                            }
                            case 9 -> {
                                System.out.println("get EmployeeBy Position :");
                                System.out.println(employeeService.getEmployeeByPosition("Management"));
                            }
                            case 10 -> exit = false;
                        }
                    }
                }
                case 1 -> {
                    boolean Exit = true;
                    while (Exit) {
                        System.out.println("Команданы танданыз!!!");
                        System.out.println("""
                                1.createJobTable
                                2.addJob
                                3.getJobById
                                4.sortByExperience
                                5.getJobByEmployeeId
                                6.deleteDescriptionColumn
                                7.Exit
                                """);
                        switch (new Scanner(System.in).nextInt()) {
                            case 1 -> {
                                System.out.println("Create table :");
                                jobService.createJobTable();
                            }
                            case 2 -> {
                                System.out.println("Add Job: ");
                                Job job = new Job();
                                System.out.println("Write position: ");
                                job.setPosition(new Scanner(System.in).nextLine());
                                System.out.println(" Write profession: ");
                                job.setProfession(new Scanner(System.in).nextLine());
                                System.out.println("Write description: ");
                                job.setDescription(new Scanner(System.in).nextLine());
                                System.out.println("Write experience: ");
                                job.setExperience(new Scanner(System.in).nextInt());
                                jobService.addJob(job);

                            }
                            case 3 -> {
                                System.out.println("getJobById : ");
                                System.out.println(jobService.getJobById(new Scanner(System.in).nextLong()));
                            }
                            case 4 -> {
                                System.out.println("sort By Experience: ");
                                System.out.println(jobService.sortByExperience(new Scanner(System.in).nextLine()));
                            }
                            case 5 -> {
                                System.out.println("getJobByEmployeeId: ");
                                System.out.println(jobService.getJobByEmployeeId(new Scanner(System.in).nextLong()));
                            }
                            case 6 -> {
                                System.out.println("Deleting Description Column:");
                                jobService.deleteDescriptionColumn();
                            }
                            case 7 -> Exit = false;
                        }
                    }
                }
            }
        }
    }
}
