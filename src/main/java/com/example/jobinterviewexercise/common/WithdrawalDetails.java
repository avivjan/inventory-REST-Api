package com.example.jobinterviewexercise.common;

import com.example.jobinterviewexercise.models.Item;

public class WithdrawalDetails
{
    private String message;
    private boolean Succeeded;

    public boolean isSucceeded() {
        return Succeeded;
    }

    public void setSucceeded(boolean succeeded)
    {
        this.Succeeded = succeeded;
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
