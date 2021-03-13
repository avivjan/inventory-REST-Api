package com.example.jobinterviewexercise.common;

public class DepositDetails
{
    private boolean Succeeded;
    private String message;


    public boolean isSucceeded()
    {
        return Succeeded;
    }

    public void setSucceeded(boolean succeeded)
    {
        Succeeded = succeeded;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
