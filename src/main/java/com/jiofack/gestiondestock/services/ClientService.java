package com.jiofack.gestiondestock.services;

import com.jiofack.gestiondestock.dto.ClientDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ClientService {

    ClientDto save(ClientDto dto, MultipartFile photoFile);

    ClientDto findById(Integer id);

    List<ClientDto> findAll();

    void delete(Integer id);
}
