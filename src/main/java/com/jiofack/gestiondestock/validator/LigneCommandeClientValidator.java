package com.jiofack.gestiondestock.validator;

import com.jiofack.gestiondestock.dto.EntrepriseDto;
import com.jiofack.gestiondestock.dto.LigneCommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {
    public static List<String> validate(LigneCommandeClientDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner l'article de la commande client.");
            errors.add("Veuillez renseigner la quantite de la commande client.");
            errors.add("Veuillez renseigner le prix unitaire de la commande client.");
            return errors;
        }

        if (dto.getArticle() == null) {
            errors.add("Veuillez renseigner l'article de la commande client.");
        }
        if (dto.getQuantite() == null) {
            errors.add("Veuillez renseigner la quantite de la commande client.");
        }
        if (dto.getPrixUnitaire() == null) {
            errors.add("Veuillez renseigner le prix unitaire de la commande client.");
        }

        return errors;
    }
}
