package edu.sjsu.cmpe172.starterdemo.service;

import edu.sjsu.cmpe172.starterdemo.model.Appointment;
import edu.sjsu.cmpe172.starterdemo.repository.AppointmentRepository;
import edu.sjsu.cmpe172.starterdemo.repository.AvailabilitySlotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppointmentService
{
    private final AppointmentRepository appointmentRepository;
    private final AvailabilitySlotRepository availabilitySlotRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              AvailabilitySlotRepository availabilitySlotRepository)
    {
        this.appointmentRepository = appointmentRepository;
        this.availabilitySlotRepository = availabilitySlotRepository;
    }

    public List<Appointment> getAllAppointments()
    {
        return appointmentRepository.findAll();
    }

    @Transactional
    public String bookAppointment(int clientId, int barberId, int serviceId, int slotId)
    {
        int updatedRows = availabilitySlotRepository.bookSlot(slotId);

        if (updatedRows == 0)
        {
            recordFailedBooking();
            return "Slot is already booked or unavailable";
        }

        appointmentRepository.createAppointment(clientId, barberId, serviceId, slotId);

        System.out.println("INFO: Appointment booked successfully for slot " + slotId);

        sendConfirmation(clientId);

        return "Appointment booked successfully";
    }

    @Transactional
    public String cancelAppointment(int appointmentId, int slotId)
    {
        int updatedRows = appointmentRepository.cancelAppointment(appointmentId);

        if (updatedRows == 0)
        {
            return "Appointment is already cancelled or does not exist";
        }

        availabilitySlotRepository.reopenSlot(slotId);

        System.out.println("INFO: Appointment " + appointmentId + " cancelled");
        System.out.println("INFO: Slot " + slotId + " reopened");

        return "Appointment cancelled successfully";
    }

    public void logExamples()
    {
        System.out.println("INFO: Appointment booked successfully");
        System.out.println("WARN: User attempted to book an unavailable slot");
        System.out.println("ERROR: Notification service unavailable");
    }

    int failedBookings = 0;

    public void recordFailedBooking()
    {
        failedBookings++;
        System.out.println("Failed bookings: " + failedBookings);
    }

    // notification service
    public void sendConfirmation(int clientId)
    {
        System.out.println("Notification sent to client " + clientId);
    }

    public Appointment getAppointmentById(int appointmentId)
    {
        return appointmentRepository.findById(appointmentId);
    }
}