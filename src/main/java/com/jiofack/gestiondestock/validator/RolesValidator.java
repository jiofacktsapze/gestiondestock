package com.jiofack.gestiondestock.validator;

import com.jiofack.gestiondestock.dto.CategoryDto;
import com.jiofack.gestiondestock.dto.RolesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RolesValidator {
    public static List<String> validate(RolesDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le nom du role.");
            errors.add("Veuillez renseigner l'utilisateur du role.");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getRoleName())) {
            errors.add("Veuillez renseigner le nom du role.");
        }
        if (dto.getUtilisateur() == null) {
            errors.add("Veuillez renseigner l'utilisateur du role.");
        }
        return errors;
    }
}
