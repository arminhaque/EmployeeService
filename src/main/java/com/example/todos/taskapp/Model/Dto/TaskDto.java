package com.example.todos.taskapp.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto extends CommonDto{
    String taskName;
    String taskDescription;
}
