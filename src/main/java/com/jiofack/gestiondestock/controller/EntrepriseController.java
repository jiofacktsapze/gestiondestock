package com.jiofack.gestiondestock.controller;

import com.jiofack.gestiondestock.controller.api.EntrepriseApi;
import com.jiofack.gestiondestock.dto.EntrepriseDto;
import com.jiofack.gestiondestock.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class EntrepriseController implements EntrepriseApi {

    private EntrepriseService entrepriseService;

    @Autowired
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }
    @Override
    public EntrepriseDto save(EntrepriseDto dto, MultipartFile photoFile) {
        return entrepriseService.save(dto, photoFile);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return entrepriseService.findById(id);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Integer id) {
        entrepriseService.delete(id);
    }
}
