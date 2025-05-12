package com.example.scheduled_task.component;

import com.example.scheduled_task.entity.User;
import com.example.scheduled_task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserScheduler {

    @Autowired
    private UserRepository userRepository;

    private boolean enabled = true;

    @Scheduled(fixedRate = 10000)
    public void fetchUsersPeriodically(){
        if(enabled){
            System.out.println("Fetching users from MySQL...");
            List<User> users = userRepository.findAll();
            users.forEach(user -> System.out.println(user.getName() + " - " + user.getEmail()));
        }
    }

    @Scheduled(initialDelay = 5000, fixedRate = 10000)
    public void fetchUsersWithDelay(){
        if(enabled){
            System.out.println("Fetching users from MySQL...");
            List<User> users = userRepository.findAll();
            users.forEach(user -> System.out.println(user.getName() + " - " + user.getEmail()));
        }
    }

    @Scheduled(cron = "0 0 9 * * *")
    public void fetchUserWithCron(){
        if(enabled){
            System.out.println("Fetching users from MySQL...");
            List<User> users = userRepository.findAll();
            users.forEach(user -> System.out.println(user.getName() + " - " + user.getEmail()));
        }
    }

    public void runOnce(){
        List<User> users = userRepository.findAll();
        users.forEach(user -> System.out.println(user.getName() + " - " + user.getEmail()));
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
