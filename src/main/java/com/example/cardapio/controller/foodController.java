package com.example.cardapio.controller;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("food")
public class foodController {
    @Autowired
    private FoodRepository Repository;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        Repository.save(foodData);
        return;
    }
    @GetMapping
    public List<FoodResponseDTO> getAll() {

        List<FoodResponseDTO> foodList = Repository.findAll().stream().map(FoodResponseDTO:: new).toList();

        return foodList;
    }
}
