package com.jiofack.gestiondestock.services.impl;

import com.jiofack.gestiondestock.dto.ArticleDto;
import com.jiofack.gestiondestock.exception.EntityNotFoundException;
import com.jiofack.gestiondestock.exception.ErrorCodes;
import com.jiofack.gestiondestock.exception.InvalidEntityException;
import com.jiofack.gestiondestock.model.Article;
import com.jiofack.gestiondestock.repository.ArticleRepository;
import com.jiofack.gestiondestock.services.ArticleService;
import com.jiofack.gestiondestock.services.ImageStorageService;
import com.jiofack.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    private ImageStorageService imageStorageService;


    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto, MultipartFile photoFile) {

        if (photoFile != null && !photoFile.isEmpty()) {
            String photoUrl = imageStorageService.uploadImage(photoFile);
            dto.setPhoto(photoUrl);
        }

        List<String> errors = ArticleValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }

         return ArticleDto.fromEntity(
                 articleRepository.save(
                         ArticleDto.toEntity(dto)
                 )
         );
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return null;
        }

        Optional<Article> article = articleRepository.findById(id);

        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() ->
            new EntityNotFoundException(
                "Aucun article avec l'ID = " + id + " n'a été trouvé dans la BDD",
                    ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)) {
            log.error("Article CODE is null");
            return  null;
        }

        Optional<Article> article = articleRepository.findArticleByCodeArticle(codeArticle);

        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun article avec le code = " + codeArticle + " n'a été trouvé dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Article ID is null");
            return;
        }
        articleRepository.deleteById(id);
    }
}
