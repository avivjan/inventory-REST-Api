package com.example.jobinterviewexercise.common;

public interface ItemServiceWrite
{
    WithdrawalDetails withdrawalItem(Long itemNo, int quantity);

    DepositDetails depositItem(Long itemNo, int quantity);
}
