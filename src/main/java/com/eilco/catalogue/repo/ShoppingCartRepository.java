package com.eilco.catalogue.repo;

import com.eilco.catalogue.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

  List<ShoppingCart> findAllByUserUsername(String Username);

  List<ShoppingCart> findAllByUserUsernameAndCompleted(String username, Boolean isCompleted);

  List<ShoppingCart> findAllByUserUsernameAndCompletedOrderByDateDesc(String username, Boolean isCompleted);

  List<ShoppingCart> findAll();

  ShoppingCart findShoppingCartById(Long id);

  void deleteAllById(Long id);

}
