package com.jiofack.gestiondestock.services.impl;

import com.jiofack.gestiondestock.dto.EntrepriseDto;
import com.jiofack.gestiondestock.exception.EntityNotFoundException;
import com.jiofack.gestiondestock.exception.ErrorCodes;
import com.jiofack.gestiondestock.exception.InvalidEntityException;
import com.jiofack.gestiondestock.model.Entreprise;
import com.jiofack.gestiondestock.repository.EntrepriseRepository;
import com.jiofack.gestiondestock.services.EntrepriseService;
import com.jiofack.gestiondestock.services.ImageStorageService;
import com.jiofack.gestiondestock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;

    private ImageStorageService imageStorageService;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto dto, MultipartFile photoFile) {

        if (photoFile != null && !photoFile.isEmpty()) {
            dto.setPhoto(imageStorageService.uploadImage(photoFile));
        }

        List<String> errors = EntrepriseValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Entreprise is not valid {}", dto);
            throw new InvalidEntityException("L'entreprise' n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
        }

        return EntrepriseDto.fromEntity(
                entrepriseRepository.save(
                        EntrepriseDto.toEntity(dto)
                )
        );
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if (id == null) {
            log.error("Entreprise ID is null");
            return null;
        }

        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);

        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune entreprise avec l'ID = " + id + " n'a été trouvé dans la BDD",
                        ErrorCodes.ENTREPRISE_NOT_FOUND));
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Entreprise ID is null");
            return;
        }
        entrepriseRepository.deleteById(id);
    }
}
