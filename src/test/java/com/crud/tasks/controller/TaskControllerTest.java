package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.Assert.*;

public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TaskController taskController;

    @Test
    public void getTasksTest() throws Exception {
        //Given
        List<TaskDto> tasksDtoLists = new ArrayList<>();
        tasksDtoLists.add(new TaskDto((long) 1, "task title", "content"));

        when(taskController.getTasks()).thenReturn(tasksDtoLists);

        //When & then
        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is("task title")))
                .andExpect(jsonPath("$[0].content", is("content")));
    }

}