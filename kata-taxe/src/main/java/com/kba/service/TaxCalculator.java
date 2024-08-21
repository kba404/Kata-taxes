package com.kba.service;

import com.kba.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {
    private static final BigDecimal BASIC_TAX_RATE = new BigDecimal("0.10");
    private static final BigDecimal IMPORT_DUTY = new BigDecimal("0.05");

    public static BigDecimal calculateTaxes(Product product) {
        BigDecimal totalTax = BigDecimal.ZERO;

        // Taxe de base si le produit n'est pas exempté
        if (!product.isTaxExempt()) {
            totalTax = totalTax.add(product.getPrice().multiply(BASIC_TAX_RATE));
        }

        // Taxe d'importation si le produit est importé
        if (product.isImported()) {
            totalTax = totalTax.add(product.getPrice().multiply(IMPORT_DUTY));
        }

        // Arrondi au 0.05 supérieur
        return roundToNearestFiveCents(totalTax);
    }

    /*
    * Arrondir les taxes au 0.05 supérieur
     */
    private static BigDecimal roundToNearestFiveCents(BigDecimal amount) {
        return amount.multiply(new BigDecimal("20"))
                .setScale(0, RoundingMode.UP)
                .divide(new BigDecimal("20"), 2, RoundingMode.HALF_UP);
    }
}
