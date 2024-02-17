package com.bilal.blog.services;

import com.bilal.blog.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    // create
    CategoryDto createCategory(CategoryDto categoryDto);

    // update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    //delete
    public void deleteCategory(Integer categoryId);

    //get
    CategoryDto getCategory(Integer categoryId);

    //get All
    List<CategoryDto> getCategories();

}
