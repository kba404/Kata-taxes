import com.kba.model.Invoice;
import com.kba.model.Product;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        System.out.println("Calcul de taxes ... \n");
        // Input 1
        System.out.println("#### Output 1");
        Invoice invoice1 = new Invoice();
        invoice1.addProduct(new Product("1 livre", new BigDecimal("12.49"), false, true));
        invoice1.addProduct(new Product("1 CD musical", new BigDecimal("14.99"), false, false));
        invoice1.addProduct(new Product("1 barre de chocolat", new BigDecimal("0.85"), false, true));
        invoice1.printReceipt();

        System.out.println("\n#### Output 2");
        // Input 2
        Invoice invoice2 = new Invoice();
        invoice2.addProduct(new Product("1 boîte de chocolats importée", new BigDecimal("10.00"), true, true));
        invoice2.addProduct(new Product("1 flacon de parfum importé", new BigDecimal("47.50"), true, false));
        invoice2.printReceipt();

        System.out.println("\n#### Output 3");
        // Input 3
        Invoice invoice3 = new Invoice();
        invoice3.addProduct(new Product("1 flacon de parfum importé", new BigDecimal("27.99"), true, false));
        invoice3.addProduct(new Product("1 flacon de parfum", new BigDecimal("18.99"), false, false));
        invoice3.addProduct(new Product("1 boîte de pilules contre la migraine", new BigDecimal("9.75"), false, true));
        invoice3.addProduct(new Product("1 boîte de chocolats importés", new BigDecimal("11.25"), true, true));
        invoice3.printReceipt();
    }

}