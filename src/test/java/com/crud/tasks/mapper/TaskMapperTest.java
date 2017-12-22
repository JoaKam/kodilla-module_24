package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TaskMapperTest {

    @Test
    public void taskMapperTest(){
        //Given
        TaskMapper taskMapper = new TaskMapper();
        TaskDto taskDto = new TaskDto((long) 1, "task Dto", "test task");
        Task task = new Task((long) 1, "task", "test task");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        //When
        Task mappedTask = taskMapper.mapToTask(taskDto);
        TaskDto mappedTaskDto = taskMapper.mapToTaskDto(task);
        List<TaskDto> mappedTaskList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        Assert.assertEquals(mappedTask.getTitle(), "task Dto");
        Assert.assertEquals(mappedTaskDto.getTitle(), "task");
        Assert.assertEquals(mappedTaskList.size(), 1);
    }

}