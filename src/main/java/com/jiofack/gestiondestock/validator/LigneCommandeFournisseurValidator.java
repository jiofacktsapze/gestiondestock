package com.jiofack.gestiondestock.validator;

import com.jiofack.gestiondestock.dto.LigneCommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {
    public static List<String> validate(LigneCommandeFournisseurDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner l'article de la commande fournisseur.");
            errors.add("Veuillez renseigner la quantite de la commande fournisseur.");
            errors.add("Veuillez renseigner le prix unitaire de la commande fournisseur.");
            return errors;
        }

        if (dto.getArticle() == null) {
            errors.add("Veuillez renseigner l'article de la commande fournisseur.");
        }
        if (dto.getQuantite() == null) {
            errors.add("Veuillez renseigner la quantite de la commande fournisseur.");
        }
        if (dto.getPrixUnitaire() == null) {
            errors.add("Veuillez renseigner le prix unitaire de la commande fournisseur.");
        }

        return errors;
    }
}
