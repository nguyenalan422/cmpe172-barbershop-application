package edu.sjsu.cmpe172.starterdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController
{
    @GetMapping("/health")
    public String healthCheck()
    {
        return "Application is running and database is connected";
    }
}