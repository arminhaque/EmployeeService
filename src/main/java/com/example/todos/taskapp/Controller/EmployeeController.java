package com.example.todos.taskapp.Controller;

import com.example.todos.taskapp.Model.Dto.EmployeeDto;
import com.example.todos.taskapp.Model.Dto.TaskDto;
import com.example.todos.taskapp.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class EmployeeController {
    @Autowired
  private EmployeeService employeeService;
    @PostMapping("/addEmployee")
    public ResponseEntity<?>addEmployee(@RequestBody EmployeeDto employeeDto)
    {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createTask(employeeDto));
        }
        catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }

    @GetMapping(path = "/getEmployee")
    public ResponseEntity<List<EmployeeDto>> getEmployee (){
        return  ResponseEntity.ok().body(employeeService.getAllEmployee());
    }
    @GetMapping(path = "/getEmployeeById/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
    }
    @PutMapping(path = "/updateEmployee/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long taskId, @RequestBody EmployeeDto employeeDto){
        employeeDto.setId(taskId);
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.createTask(employeeDto));
    }
    @DeleteMapping(path = "/deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
//        Todo: Update status
        employeeDto.setDeleted(true);
        return ResponseEntity.ok(employeeService.deleteEmployee(employeeDto));
    }
}
