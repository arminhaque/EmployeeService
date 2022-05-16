package com.example.todos.taskapp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel extends BaseModel{
    private static final Long serialVersionUID = 202129250796540515L;
    private String employeeName;
    private String employeeEmail;
}
