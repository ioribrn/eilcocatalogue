package com.eilco.catalogue.repo;


import com.eilco.catalogue.model.ItemImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemImageRepository extends JpaRepository<ItemImage, Long> {

    void deleteAllById(Long id);

}
