package com.example.scheduled_task.controller;

import com.example.scheduled_task.component.UserScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users/scheduler")
public class SchedulerController {

    @Autowired
    private UserScheduler userScheduler;

    @PostMapping("/start")
    public String start(){
        userScheduler.setEnabled(true);
        return "Scheduler started.";
    }

    @PostMapping("/stop")
    public String stop(){
        userScheduler.setEnabled(false);
        return "Scheduler stopped.";
    }

    @PostMapping("/run-once")
    public String runOnce(){
        userScheduler.runOnce();
        return "Scheduler executed manually.";
    }
}
