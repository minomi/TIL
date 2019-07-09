package me.minho.jpastudy.service;

import lombok.AllArgsConstructor;
import me.minho.jpastudy.domain.Item;
import me.minho.jpastudy.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-07-09.
 */

@Service
@Transactional
@AllArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Item findItem(Long id) {
        return itemRepository.findOne(id);
    }

}
