package com.example.jobinterviewexercise.service;

import com.example.jobinterviewexercise.common.DepositDetails;
import com.example.jobinterviewexercise.common.ItemServiceRead;
import com.example.jobinterviewexercise.common.ItemServiceWrite;
import com.example.jobinterviewexercise.common.WithdrawalDetails;
import com.example.jobinterviewexercise.models.Item;
import com.example.jobinterviewexercise.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImplementation implements ItemServiceRead, ItemServiceWrite
{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Optional<Item> findItemByItemNo(Long itemNo)
    {
        return itemRepository.findById(itemNo);
    }

    @Override
    public List<Item> getAllItems()
    {
        return itemRepository.findAll();
    }

    @Override
    public WithdrawalDetails withdrawalItem(Long itemNo, int quantity)
    {
        WithdrawalDetails details = new WithdrawalDetails();
        Optional<Item> foundItemOptional = itemRepository.findById(itemNo);
        if (!foundItemOptional.isPresent()) {
            details.setSucceeded(false);
            details.setMessage(String.format("An item with item no. %d was not found", itemNo));
        }
        else
        {
            Item foundItem = foundItemOptional.get();
            int existingAmount = foundItem.getAmount();
            if (existingAmount < quantity)
            {
                String foundItemName = foundItem.getName();
                details.setSucceeded(false);
                details.setMessage(String.format("You can not withdraw %s items of %s while there is only %s", quantity, foundItemName, existingAmount));
            }
            else
            {
                int newAmount = existingAmount - quantity;
                foundItem.setAmount(newAmount);
                itemRepository.save(foundItem);
                details.setSucceeded(true);
                String foundItemName = foundItem.getName();
                details.setMessage(String.format("Your Withdrawal succeeded, the new quantity of %s : %d", foundItemName, newAmount));
            }
        }
        return details;
    }

    @Override
    public DepositDetails depositItem(Long itemNo, int quantity)
    {
        DepositDetails details = new DepositDetails();
        Optional<Item> foundItemOptional = itemRepository.findById(itemNo);
        if (!foundItemOptional.isPresent()) {
            details.setSucceeded(false);
            details.setMessage(String.format("An item with item no. %d was not found", itemNo));
        }
        else
        {
            Item foundItem = foundItemOptional.get();
            int existingAmount = foundItem.getAmount();
            int newAmount = existingAmount + quantity;
            foundItem.setAmount(newAmount);
            itemRepository.save(foundItem);
            details.setSucceeded(true);
            String foundItemName = foundItem.getName();
            details.setMessage(String.format("Your Withdrawal succeeded, the new quantity of %s : %d", foundItemName, newAmount));
        }
        return details;
    }
}


