package com.eilco.catalogue.service;

import com.eilco.catalogue.model.CartItem;
import com.eilco.catalogue.model.Item;
import com.eilco.catalogue.repo.CartItemRepository;
import com.eilco.catalogue.repo.ItemImageRepository;
import com.eilco.catalogue.repo.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;
    private CartItemRepository cartItemRepository;
    private ItemImageRepository imageRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository){ this.itemRepository = itemRepository;}

    @Autowired
    public void setCartItemRepository(CartItemRepository cartItemRepository){ this.cartItemRepository=cartItemRepository;}

    @Autowired
    public void setItemImageService(ItemImageRepository imageRepository) { this.imageRepository = imageRepository; }


    public List<Item> getAllItems(){ return itemRepository.findAll(); }

    public List<Item> getAllActiveItems(){ return itemRepository.findAllByActiveTrue(); }

    public List<Item> getAllItemsByCategory(String category, Long itemId){
        List<Item> allByCat = itemRepository.findAllByActiveTrueAndCategory(category);
        Item toRemove = itemRepository.findItemById(itemId);
        allByCat.remove(toRemove);

        return allByCat;
    }

    public void saveItem(Item item){ this.itemRepository.save(item);}

    public Item getItemById(Long id){ return itemRepository.findById(id).get(); }

    public void saveCartItem(CartItem cartItem){ cartItemRepository.save(cartItem); }

    public CartItem getCartItem(Long id){ return cartItemRepository.getById(id); }




    }


