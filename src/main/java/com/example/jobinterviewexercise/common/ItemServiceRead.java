package com.example.jobinterviewexercise.common;

import com.example.jobinterviewexercise.models.Item;

import java.util.List;
import java.util.Optional;

public interface ItemServiceRead
{
    Optional<Item> findItemByItemNo(Long itemNo);

    List<Item> getAllItems();


}