package edu.sjsu.cmpe172.starterdemo.model;

public class Barber
{
    private int barberId;
    private String name;
    private String email;
    private String phone;

//    public Barber()
//    {
//
//    }

    public Barber(int barberId, String name, String email, String phone)
    {
        this.barberId = barberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getBarberId()
    {
        return barberId;
    }

    public void setBarberId(int barberId)
    {
        this.barberId = barberId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }
}