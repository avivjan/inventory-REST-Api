package com.example.jobinterviewexercise.service;

import com.example.jobinterviewexercise.models.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ItemsService
{
    Page<Item> findByLastName(String lastName, PageRequest pageRequest);
}
