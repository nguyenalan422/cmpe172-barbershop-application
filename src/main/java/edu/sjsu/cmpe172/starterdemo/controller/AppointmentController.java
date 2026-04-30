package edu.sjsu.cmpe172.starterdemo.controller;

import edu.sjsu.cmpe172.starterdemo.model.Appointment;
import edu.sjsu.cmpe172.starterdemo.service.AppointmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppointmentController
{
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService)
    {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/appointments")
    public List<Appointment> getAppointments()
    {
        return appointmentService.getAllAppointments();
    }

    @PostMapping("/appointments/book")
    public String bookAppointment(@RequestParam int clientId,
                                  @RequestParam int barberId,
                                  @RequestParam int serviceId,
                                  @RequestParam int slotId)
    {
        return appointmentService.bookAppointment(clientId, barberId, serviceId, slotId);
    }

    @PostMapping("/appointments/cancel")
    public String cancelAppointment(@RequestParam int appointmentId,
                                    @RequestParam int slotId)
    {
        return appointmentService.cancelAppointment(appointmentId, slotId);
    }

    @PostMapping("/appointments/sendConfirmation")
    public String sendConfirmation()
    {
        return "Calling Notification Service...";
    }
}