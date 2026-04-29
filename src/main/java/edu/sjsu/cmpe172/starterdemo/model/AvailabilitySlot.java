package edu.sjsu.cmpe172.starterdemo.model;

public class AvailabilitySlot
{
    private int slotId;
    private int barberId;
    private String startTime;
    private String endTime;
    private String status;

//    public AvailabilitySlot()
//    {
//
//    }

    public AvailabilitySlot(int slotId, int barberId, String startTime, String endTime, String status)
    {
        this.slotId = slotId;
        this.barberId = barberId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public int getSlotId()
    {
        return slotId;
    }

    public void setSlotId(int slotId)
    {
        this.slotId = slotId;
    }

    public int getBarberId()
    {
        return barberId;
    }

    public void setBarberId(int barberId)
    {
        this.barberId = barberId;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}