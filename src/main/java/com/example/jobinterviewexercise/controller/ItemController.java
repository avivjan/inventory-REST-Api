package com.example.jobinterviewexercise.controller;

import com.example.jobinterviewexercise.common.DepositDetails;
import com.example.jobinterviewexercise.common.WithdrawalDetails;
import com.example.jobinterviewexercise.models.Item;
import com.example.jobinterviewexercise.common.ItemServiceRead;
import com.example.jobinterviewexercise.common.ItemServiceWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController
{
    @Autowired
    ItemServiceRead itemServiceRead;
    @Autowired
    ItemServiceWrite itemServiceWrite;

    @RequestMapping(value = "/{itemNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Optional<Item> findByItemNo(@PathVariable("itemNo") Long itemNo)
    {
        return itemServiceRead.findItemByItemNo(itemNo);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Item> getAllItems()
    {
        return itemServiceRead.getAllItems();
    }

    @RequestMapping(value = "/{itemNo}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity withdrawalItem(@PathVariable("itemNo") Long itemNo, @RequestParam int quantity)
    {
        WithdrawalDetails details =  itemServiceWrite.withdrawalItem(itemNo, quantity);
        if (details.isSucceeded())
        {
            return new ResponseEntity(details.getMessage(),HttpStatus.OK);
        }
        return new ResponseEntity(details.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{itemNo}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity depositItem(@PathVariable("itemNo") Long itemNo, @RequestParam int quantity)
    {
        DepositDetails details = itemServiceWrite.depositItem(itemNo, quantity);
        if (details.isSucceeded())
        {
            return new ResponseEntity(details.getMessage(),HttpStatus.OK);
        }
        return new ResponseEntity(details.getMessage(),HttpStatus.BAD_REQUEST);
    }

}