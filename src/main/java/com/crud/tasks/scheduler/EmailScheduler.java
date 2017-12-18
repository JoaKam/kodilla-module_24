package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    private static final String SUBJECT = "Task: once a day email";

    @Scheduled(fixedDelay = 1000)
    public void sendInfoEmail() {
        long size = taskRepository.count();
        String taskWord;

        if (size == 1) {
            taskWord = " task";
        } else {
            taskWord = " tasks";
        }

        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                "",
                SUBJECT,
                "Currently you have: " + size + taskWord
        ));
    }
}
