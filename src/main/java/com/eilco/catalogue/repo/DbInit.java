package com.eilco.catalogue.repo;

import com.eilco.catalogue.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {


private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private ItemRepository itemRepository;
    private ShoppingCartRepository shoppingCartRepository;
    private CartItemRepository cartItemRepository;

    public DbInit(UserRepository userRepository, ItemRepository itemRepository, ShoppingCartRepository shoppingCartRepository,
                  PasswordEncoder passwordEncoder, CartItemRepository cartItemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.shoppingCartRepository = shoppingCartRepository;
        this.passwordEncoder = passwordEncoder;
        this.cartItemRepository = cartItemRepository;
    }


    @Override
    public void run(String... args)   {
        User usher2 = new User("admin", passwordEncoder.encode("admin"), "ADMIN,USER", "admin@b.admincom");

        if(userRepository.findByUsername("admin") == null)
        userRepository.save(usher2);

    }
}
