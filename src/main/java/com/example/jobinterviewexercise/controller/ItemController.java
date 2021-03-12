package com.example.jobinterviewexercise.controller;

import com.example.jobinterviewexercise.models.Item;
import com.example.jobinterviewexercise.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class ItemController
{
    @Autowired
    ItemsService itemsService;


    @RequestMapping(value = "/find/last/{lastName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<Item> findByLastName(@PathVariable("lastName") String lastName,
                                     @RequestParam(name = "page", defaultValue = "0") int page,
                                     @RequestParam(name = "size", defaultValue = "20") int size) {

        page = (page<0)? 0: page;
        size = (size<1)? 20: size;

        return itemsService.findByLastName(lastName, PageRequest.of(page,size));
    }

}
