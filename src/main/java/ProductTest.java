

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product;
    @BeforeEach
    void setUp(){
        product= new Product("0031","Bean Juice","Bean Bean's Bean Juice",100.0);
    }
    @org.junit.jupiter.api.Test
    void setCost() {
        product.setCost(1000.0);
        System.out.println(product.getCost());
    }

    @Test
    void setName(){
        product.setName("Yummy Bean Juice");
        System.out.println(product.getName());
    }
    @org.junit.jupiter.api.Test
    void setDescription() {
        product.setDescription("Thenie's Bean Juice");
        System.out.println(product.getDescription());
    }

    @org.junit.jupiter.api.Test
    void toCSVDataRecord() {

        System.out.println(product.toCSVDataRecord());
    }
}