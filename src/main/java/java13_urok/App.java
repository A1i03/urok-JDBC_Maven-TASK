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
                                employeeService.addEmployee(new Employee("Kaldarbekov", "Sultanali", 21,"ali@gmail.com", 2));
                                employeeService.addEmployee(new Employee("Tinatin", "Tinatin", 20,"iam_tina@gmail.com", 1));
                                employeeService.addEmployee(new Employee("Islam", "Kalyiuulu", 18,"isa@gmail.com", 3));
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
                               // employeeService.updateEmployee();
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
                                System.out.println(employeeService.getEmployeeByPosition(new Scanner(System.in).nextLine()));
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
                                jobService.addJob(new Job("Mentor", "Java" ,  "Backend developer", 3));
                                jobService.addJob(new Job("Management", "JavaScript" ,  "Fronted developer", 1));
                                jobService.addJob(new Job("Instructor", "Java" ,  "Backend developer", 2));
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
