package com.jiofack.gestiondestock.services;

import com.jiofack.gestiondestock.dto.UtilisateurDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UtilisateurService {

    UtilisateurDto save(UtilisateurDto dto, MultipartFile photoFile);

    UtilisateurDto findById(Integer id);

    List<UtilisateurDto> findAll();

    void delete(Integer id);
}
