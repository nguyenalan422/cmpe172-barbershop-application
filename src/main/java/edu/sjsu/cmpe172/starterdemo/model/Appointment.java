package edu.sjsu.cmpe172.starterdemo.model;

public class Appointment
{
    private int appointmentId;
    private int clientId;
    private int barberId;
    private int serviceId;
    private int slotId;
    private String status;
    private String timeBooked;

//    public Appointment()
//    {
//
//    }

    public Appointment(int appointmentId, int clientId, int barberId, int serviceId, int slotId, String status, String timeBooked)
    {
        this.appointmentId = appointmentId;
        this.clientId = clientId;
        this.barberId = barberId;
        this.serviceId = serviceId;
        this.slotId = slotId;
        this.status = status;
        this.timeBooked = timeBooked;
    }

    public int getAppointmentId()
    {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId)
    {
        this.appointmentId = appointmentId;
    }

    public int getClientId()
    {
        return clientId;
    }

    public void setClientId(int clientId)
    {
        this.clientId = clientId;
    }

    public int getBarberId()
    {
        return barberId;
    }

    public void setBarberId(int barberId)
    {
        this.barberId = barberId;
    }

    public int getServiceId()
    {
        return serviceId;
    }

    public void setServiceId(int serviceId)
    {
        this.serviceId = serviceId;
    }

    public int getSlotId()
    {
        return slotId;
    }

    public void setSlotId(int slotId)
    {
        this.slotId = slotId;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getTimeBooked()
    {
        return timeBooked;
    }

    public void setTimeBooked(String timeBooked)
    {
        this.timeBooked = timeBooked;
    }
}
