package com.example.canals.service;

import com.example.canals.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;

}
