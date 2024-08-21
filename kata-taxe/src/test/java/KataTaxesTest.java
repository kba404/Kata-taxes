import com.kba.model.Invoice;
import com.kba.model.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;


public class KataTaxesTest {
    @Test
    public void testInput1() {
        // Création du reçu pour l'input 1
        Invoice invoice1 = new Invoice();
        invoice1.addProduct(new Product("1 livre", new BigDecimal("12.49"), false, true));
        invoice1.addProduct(new Product("1 CD musical", new BigDecimal("14.99"), false, false));
        invoice1.addProduct(new Product("1 barre de chocolat", new BigDecimal("0.85"), false, true));

        // Vérifications des montants calculés
        assertEquals(new BigDecimal("1.50"), invoice1.getTotalTaxes().setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(new BigDecimal("29.83"), invoice1.getTotalAmount().setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void testInput2() {
        // Création du reçu pour l'input 2
        Invoice invoice2 = new Invoice();
        invoice2.addProduct(new Product("1 boîte de chocolats importée", new BigDecimal("10.00"), true, true));
        invoice2.addProduct(new Product("1 flacon de parfum importé", new BigDecimal("47.50"), true, false));

        // Vérifications des montants calculés
        assertEquals(new BigDecimal("7.65"), invoice2.getTotalTaxes().setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(new BigDecimal("65.15"), invoice2.getTotalAmount().setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void testInput3() {
        // Création du reçu pour l'input 3
        Invoice invoice3 = new Invoice();
        invoice3.addProduct(new Product("1 flacon de parfum importé", new BigDecimal("27.99"), true, false));
        invoice3.addProduct(new Product("1 flacon de parfum", new BigDecimal("18.99"), false, false));
        invoice3.addProduct(new Product("1 boîte de pilules contre la migraine", new BigDecimal("9.75"), false, true));
        invoice3.addProduct(new Product("1 boîte de chocolats importés", new BigDecimal("11.25"), true, true));

        // Vérifications des montants calculés
        assertEquals(new BigDecimal("6.70"), invoice3.getTotalTaxes().setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(new BigDecimal("74.68"), invoice3.getTotalAmount().setScale(2, BigDecimal.ROUND_HALF_UP));
    }
}
