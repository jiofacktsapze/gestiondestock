package com.jiofack.gestiondestock.services;

import com.jiofack.gestiondestock.dto.FournisseurDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FournisseurService {

    FournisseurDto save(FournisseurDto dto, MultipartFile photoFile);

    FournisseurDto findById(Integer id);

    List<FournisseurDto> findAll();

    void delete(Integer id);
}
