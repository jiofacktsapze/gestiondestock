package com.jiofack.gestiondestock.services;

import com.jiofack.gestiondestock.dto.EntrepriseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto dto, MultipartFile photoFile);

    EntrepriseDto findById(Integer id);

    List<EntrepriseDto> findAll();

    void delete(Integer id);
}
