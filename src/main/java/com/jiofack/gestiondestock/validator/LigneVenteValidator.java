package com.jiofack.gestiondestock.validator;

import com.jiofack.gestiondestock.dto.CategoryDto;
import com.jiofack.gestiondestock.dto.LigneVenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneVenteValidator {
    public static List<String> validate(LigneVenteDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner la vente de la ligne vente.");
            errors.add("Veuillez renseigner la quantité de la ligne vente.");
            errors.add("Veuillez renseigner le prix unitaire de la ligne vente.");
            return errors;
        }

        if (dto.getVente() == null) {
            errors.add("Veuillez renseigner la vente de la ligne vente.");
        }
        if (dto.getQuantite() == null) {
            errors.add("Veuillez renseigner la quantité de la ligne vente.");
        }
        if (dto.getPrixUnitaire() == null) {
            errors.add("Veuillez renseigner le prix unitaire de la ligne vente.");
        }

        return errors;
    }
}
