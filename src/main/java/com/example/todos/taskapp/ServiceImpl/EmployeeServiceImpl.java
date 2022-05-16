package com.example.todos.taskapp.ServiceImpl;


import com.example.todos.taskapp.Model.Dto.EmployeeDto;
import com.example.todos.taskapp.Model.EmployeeModel;
import com.example.todos.taskapp.Model.TaskModel;
import com.example.todos.taskapp.Repository.EmployeeRepository;
import com.example.todos.taskapp.Service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl( EmployeeRepository employeeRepository, ModelMapper modelMapper ) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDto createTask(EmployeeDto employeeDto) {
        System.out.println("employeeDto ="+ employeeDto);
        return this.mapToDto(employeeRepository.save(this.mapToModel(employeeDto)));
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        return employeeRepository.findAll().stream().map(this::mapToDto)
                .collect(Collectors.toList());

    }

    @Override
    public EmployeeDto getEmployeeById(long id) {
        return this.mapToDto(employeeRepository.findById(id).get());
    }

    @Override
    public EmployeeDto deleteEmployee(EmployeeDto employeeDto) {
        return this.mapToDto(employeeRepository.save(this.mapToModel(employeeDto)));
    }

    @Override
    @Transactional
    public boolean updateEmployee(Long id, Map<String, Object> update) {
        boolean result = false;
        try{
            System.out.println("id = " + id);
            System.out.println("update = " +update.get("employeeName").toString());
            EmployeeModel employee = employeeRepository.findById(id).get();
            employee.setEmployeeName(update.get("employeeName").toString());
            employeeRepository.save(employee);
            result = true;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return  result;
    }



    public EmployeeModel mapToModel(EmployeeDto dto){
        EmployeeModel model = new EmployeeModel();
        modelMapper.map(dto, model);
        return model;
    }
    public EmployeeDto mapToDto(EmployeeModel model){
        EmployeeDto dto = modelMapper.map(model, EmployeeDto.class);
        return dto;
    }
}
