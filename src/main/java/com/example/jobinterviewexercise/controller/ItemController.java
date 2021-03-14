package com.example.jobinterviewexercise.controller;

import com.example.jobinterviewexercise.common.DepositDetails;
import com.example.jobinterviewexercise.common.WithdrawalDetails;
import com.example.jobinterviewexercise.models.Item;
import com.example.jobinterviewexercise.common.ItemServiceRead;
import com.example.jobinterviewexercise.common.ItemServiceWrite;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItemController
{
    @Autowired
    ItemServiceRead itemServiceRead;
    @Autowired
    ItemServiceWrite itemServiceWrite;


    @RequestMapping(value = "/item/{itemNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(
            value = "This method gets the item by item no.",
            notes = "Provide an item no. to look up for item, returns null if does not exist",
            response = Item.class)
    public ResponseEntity<Optional<Item>> findByItemNo(@PathVariable("itemNo") Long itemNo)
    {
        Optional<Item> foundItem = itemServiceRead.findItemByItemNo(itemNo);
        if (foundItem.isPresent())
        {
            return new ResponseEntity<Optional<Item>>(foundItem, HttpStatus.OK);
        }
        return new ResponseEntity<Optional<Item>>(foundItem, HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/item/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(
            value = "This method gets all the items in the inventory.",
            notes = "returns a list of all the items",
            response = Item.class)
    public List<Item> getAllItems()
    {
        return itemServiceRead.getAllItems();
    }

    @RequestMapping(value = "/item/withdraw/{itemNo}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(
            value = "This method withdraws a specific quantity of item from inventory.",
            notes = "Provide an item no. via url and quantity as request param to withdraw",
            response = String.class)
    public ResponseEntity withdrawalItem(@PathVariable("itemNo") Long itemNo, @RequestParam int quantity)
    {
        WithdrawalDetails details =  itemServiceWrite.withdrawalItem(itemNo, quantity);
        if (details.isSucceeded())
        {
            return new ResponseEntity(details.getMessage(),HttpStatus.OK);
        }
        return new ResponseEntity(details.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/item/deposit/{itemNo}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(
            value = "This method deposits a specific quantity of item from inventory.",
            notes = "Provide an item no. via url and quantity as request param to deposit",
            response = String.class)
    public ResponseEntity depositItem(@PathVariable("itemNo") Long itemNo, @RequestParam int quantity)
    {
        DepositDetails details = itemServiceWrite.depositItem(itemNo, quantity);
        if (details.isSucceeded())
        {
            return new ResponseEntity(details.getMessage(),HttpStatus.OK);
        }
        return new ResponseEntity(details.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/item/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(
            value = "This method adds an item to the inventory.",
            notes = "Provide an item object properties that you want to add, returns the inventory list",
            response = Item.class)
    public List<Item> addItem(@RequestBody Item item)
    {
        itemServiceWrite.addItem(item);
        return itemServiceRead.getAllItems();
    }

    @RequestMapping(value = "/item/delete/{itemNo}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(
            value = "This method deletes an item from the inventory.",
            notes = "Provide the item no. that you want to delete, returns the inventory list",
            response = Item.class)
    public ResponseEntity<List<Item>> deleteItem(@PathVariable("itemNo") Long itemNo)
    {
        if(itemServiceWrite.deleteItem(itemNo))
        {
            return new ResponseEntity<List<Item>>(itemServiceRead.getAllItems(), HttpStatus.OK);
        }
        return new ResponseEntity<List<Item>>(itemServiceRead.getAllItems(), HttpStatus.BAD_REQUEST);
    }
}