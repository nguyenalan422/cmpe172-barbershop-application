package edu.sjsu.cmpe172.starterdemo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mock-notifications")
public class NotificationController
{

    @PostMapping("/send")
    public String sendNotification()
    {
        return "Notification sent successfully!";
    }
}