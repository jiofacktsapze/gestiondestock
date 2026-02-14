package com.jiofack.gestiondestock.services;

import com.jiofack.gestiondestock.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto dto);

    CategoryDto findById(Integer id);

    CategoryDto findCategoryByCode(String codeCategory);

    List<CategoryDto> findAll();

    void delete(Integer id);
}
