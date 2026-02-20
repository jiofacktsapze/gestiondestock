package com.jiofack.gestiondestock.controller;

import com.jiofack.gestiondestock.controller.api.ClientApi;
import com.jiofack.gestiondestock.dto.ClientDto;
import com.jiofack.gestiondestock.services.ClientService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ClientController implements ClientApi {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ClientDto save(ClientDto dto, MultipartFile photoFile) {
        return clientService.save(dto, photoFile);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        clientService.delete(id);
    }
}
