package com.mak.redis;

import com.mak.redis.entity.Product;
import com.mak.redis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class SpingDataRedisApplication {
    @Autowired
    private ProductRepository repository;


    @PostMapping
    public Product save(@RequestBody Product product){
        return repository.save(product);
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return repository.findAll();

    }
    @GetMapping("/{id}")
    public Product findProduct(@PathVariable int id){
        return repository.findProductById(id);
    }
    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id){
        return repository.deleteProduct(id);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpingDataRedisApplication.class, args);
    }

}

