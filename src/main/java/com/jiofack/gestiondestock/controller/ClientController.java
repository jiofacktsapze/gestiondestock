package com.jiofack.gestiondestock.controller;

import com.jiofack.gestiondestock.controller.api.ClientApi;
import com.jiofack.gestiondestock.dto.ClientDto;
import com.jiofack.gestiondestock.services.ClientService;

import java.util.List;

public class ClientController implements ClientApi {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        return null;
    }

    @Override
    public ClientDto findById(Integer id) {
        return null;
    }

    @Override
    public List<ClientDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(Integer id) {

    }
}
