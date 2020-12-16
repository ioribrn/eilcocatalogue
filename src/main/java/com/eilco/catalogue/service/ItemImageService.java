package com.eilco.catalogue.service;

import com.eilco.catalogue.model.ItemImage;
import com.eilco.catalogue.repo.ItemImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemImageService {

    private ItemImageRepository itemImageRepository;

    @Autowired
    public void setImageRepository(ItemImageRepository itemImageRepository) { this.itemImageRepository = itemImageRepository; }

    public void saveItemImage(ItemImage itemImage){itemImageRepository.save(itemImage);}

    public  void deleteItemImage(Long id){ itemImageRepository.deleteAllById(id);}
}
