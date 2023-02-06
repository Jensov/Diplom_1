import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTests {

    private final String name = "БигМак булка";
    private final float price = 300;
    Bun bun = new Bun(name, price);

    public final static Double DELTA = 0.00001;

    @Test
    public void setBunName() { // ТЕСТ ИМЕНИ БУЛКИ
        String expected = name;
        String actual = bun.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void setBunPrice() { // ТЕСТ ЦЕНЫ БУЛКИ
        float expected = price;
        float actual = bun.getPrice();
        assertEquals(expected, actual, DELTA);
    }
}
