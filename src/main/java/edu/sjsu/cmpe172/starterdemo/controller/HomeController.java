package edu.sjsu.cmpe172.starterdemo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the Barbershop Appointment Scheduling System! Try /appointments or /slots";
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "Appointment Scheduler Service is live and running";
    }


}