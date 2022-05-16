package com.example.todos.taskapp.Service;

import com.example.todos.taskapp.Model.Dto.EmployeeDto;

import java.util.List;
import java.util.Map;

public  interface EmployeeService
{
    EmployeeDto createTask(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto getEmployeeById (long id);
    EmployeeDto deleteEmployee(EmployeeDto employeeDto);
    boolean updateEmployee(Long id, Map<String, Object> update);
}