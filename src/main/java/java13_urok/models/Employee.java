package java13_urok.models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private int jobId; //(reference)

    public Employee(String firstName, String lastName, int age, String email, int jobId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.jobId = jobId;
    }
}
