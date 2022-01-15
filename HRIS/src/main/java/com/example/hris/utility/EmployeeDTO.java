package com.example.hris.utility;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EmployeeDTO {
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String email;

    public EmployeeDTO(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public EmployeeDTO(){

    }
}
