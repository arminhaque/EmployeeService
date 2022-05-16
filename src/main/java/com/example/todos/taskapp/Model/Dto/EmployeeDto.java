package com.example.todos.taskapp.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto extends CommonDto{
    String employeeName;
    String employeeEmail;
}
