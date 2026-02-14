package com.jiofack.gestiondestock.validator;

import com.jiofack.gestiondestock.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {
    public static List<String> validate(CommandeClientDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null || !StringUtils.hasLength(dto.getCode())) {
            errors.add("Veuillez renseigner le code de la commande client.");
        }

        return errors;
    }
}
