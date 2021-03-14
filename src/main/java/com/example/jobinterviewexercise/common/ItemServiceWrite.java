package com.example.jobinterviewexercise.common;

import com.example.jobinterviewexercise.models.Item;

public interface ItemServiceWrite
{
    WithdrawalDetails withdrawalItem(Long itemNo, int quantity);

    DepositDetails depositItem(Long itemNo, int quantity);

    void addItem(Item item);

    boolean deleteItem(Long itemNo);
}
