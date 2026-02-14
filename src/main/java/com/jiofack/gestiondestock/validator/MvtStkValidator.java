package com.jiofack.gestiondestock.validator;

import com.jiofack.gestiondestock.dto.LigneVenteDto;
import com.jiofack.gestiondestock.dto.MvtStkDto;

import java.util.ArrayList;
import java.util.List;

public class MvtStkValidator {
    public static List<String> validate(MvtStkDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner l'article du mouvement de stock.");
            errors.add("Veuillez renseigner la quantité du mouvement de stock.");
            errors.add("Veuillez renseigner la date du mouvement de stock.");
            return errors;
        }

        if (dto.getArticle() == null) {
            errors.add("Veuillez renseigner l'article du mouvement de stock.");
        }
        if (dto.getQuantite() == null) {
            errors.add("Veuillez renseigner la quantité du mouvement de stock.");
        }
        if (dto.getDateMvt() == null) {
            errors.add("Veuillez renseigner la date du mouvement de stock.");
        }

        return errors;
    }
}
