package edu.sjsu.cmpe172.starterdemo.model;

public class ServiceType
{
    private int serviceId;
    private String serviceName;
    private int duration;
    private double price;

//    public ServiceType()
//    {
//
//    }

    public ServiceType(int serviceId, String serviceName, int duration, double price)
    {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.duration = duration;
        this.price = price;
    }

    public int getServiceId()
    {
        return serviceId;
    }

    public void setServiceId(int serviceId)
    {
        this.serviceId = serviceId;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
