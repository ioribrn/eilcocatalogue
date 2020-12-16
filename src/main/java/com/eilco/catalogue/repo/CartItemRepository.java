package com.eilco.catalogue.repo;

import com.eilco.catalogue.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

CartItem getById(Long id);

}
