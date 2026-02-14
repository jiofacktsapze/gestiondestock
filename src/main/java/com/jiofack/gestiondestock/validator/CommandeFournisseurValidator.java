package com.jiofack.gestiondestock.validator;

import com.jiofack.gestiondestock.dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {
    public static List<String> validate(CommandeFournisseurDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null || !StringUtils.hasLength(dto.getCode())) {
            errors.add("Veuillez renseigner le code de la commande fournisseur.");
        }

        return errors;
    }
}
