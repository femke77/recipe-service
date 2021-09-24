package com.example.recipe.controller;

import com.example.recipe.model.Recipe;
import com.example.recipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    RecipeRepository recipeRepo;

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes(){
        return recipeRepo.findAll();
    }

    @GetMapping("/recipes/category/{category}")
    public List<Recipe> getAllRecipesByCategory(@PathVariable String category){
        return recipeRepo.findAllRecipesByCategory(category);
    }

    @GetMapping("/recipes/{id}")
    public Recipe getRecipe(@PathVariable Integer id){
        return recipeRepo.getOne(id);
    }


    @PostMapping("/recipes")
    public Recipe addRecipe(@RequestBody Recipe recipe){
        return recipeRepo.save(recipe);
    }

    @PutMapping("/recipes")
    public void updateRecipe(@RequestBody Recipe recipe){
         recipeRepo.save(recipe);
    }

    @DeleteMapping("/recipes")
    public void deleteRecipe(@PathVariable Integer id) {
        recipeRepo.deleteById(id);
    }




}
