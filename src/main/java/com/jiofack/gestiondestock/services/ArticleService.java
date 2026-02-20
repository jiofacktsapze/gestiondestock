package com.jiofack.gestiondestock.services;

import com.jiofack.gestiondestock.dto.ArticleDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto dto, MultipartFile photoFile);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String codeArticle);

    List<ArticleDto> findAll();

    void delete(Integer id);
}
