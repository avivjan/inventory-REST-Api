package com.example.jobinterviewexercise.service;

import com.example.jobinterviewexercise.models.Item;
import com.example.jobinterviewexercise.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsRepository itemsRepository;

    @Override
    public Page<Item> findByLastName(String lastName, PageRequest pageRequest) {
        return itemsRepository.findByLastName(lastName, pageRequest);
    }
}

