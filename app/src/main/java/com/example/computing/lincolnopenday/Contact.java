package com.example.computing.lincolnopenday;

// Database to Hold Information
public class Contact {
    String pname ,pemail,puname ,ppass,pcolour;

    // Gets Users Name
    public void setName(String name)
    {
        this.pname = name;
    }
    public String getName()
    {
        return this.pname;
    }

    //Gets Users Email
    public void setEmail(String email)
    {
        this.pemail = email;
    }
    public String getEmail()
    {
        return this.pemail;
    }

    //Gets Username
    public void setUname(String uname)
    {
        this.puname = uname;
    }
    public String getUname()
    {
        return this.puname;
    }

    //Sets Password
    public void setPass(String pass)
    {
        this.ppass = pass;
    }
    public String getPass()
    {
        return this.ppass;
    }

    //Sets Colour
    public void setColour(String bcolour)
    {
        this.pcolour = bcolour;
    }
    public String getColour()
    {
        return this.pcolour;
    }}
