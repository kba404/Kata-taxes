package com.kba.model;

import com.kba.service.TaxCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
        private List<Product> products;
        private BigDecimal totalTaxes;
        private BigDecimal totalAmount;

        public Invoice() {
            this.products = new ArrayList<>();
            this.totalTaxes = BigDecimal.ZERO;
            this.totalAmount = BigDecimal.ZERO;
        }

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getTotalTaxes() {
        return totalTaxes;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void addProduct(Product product) {
            BigDecimal taxes = TaxCalculator.calculateTaxes(product);
            BigDecimal priceWithTaxes = product.getPrice().add(taxes);
            /* J'utilise le toString pour afficher les informations du produit avant et aprés la taxe
            * j'aurais pu faire:
            * products.add(new Product(product.getName(), priceWithTaxes, false, false));
            *
            */
            products.add(new Product(product.toString(), priceWithTaxes, false, false));
            totalTaxes = totalTaxes.add(taxes);
            totalAmount = totalAmount.add(priceWithTaxes);
        }

        public void printReceipt() {
            products.forEach(System.out::println);
            System.out.println("Montant des taxes : " + totalTaxes.setScale(2, RoundingMode.HALF_UP));
            System.out.println("Total : " + totalAmount.setScale(2, RoundingMode.HALF_UP));
        }
}
