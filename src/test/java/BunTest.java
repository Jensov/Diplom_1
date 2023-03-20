import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;

    public final static Double DELTA = 0.00001;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][]{
                {"Булочка с кунжутом", 300},
                {"", 0},
                {"Булочка с кунжутомБулочка с кунжутомБулочка с кунжутомБулочка с кунжутом", 0.0000001F},
                {"!#**&$!)*$_!($+!((!($&*!^$", -1},
                {null, 9999999999.99F}
        };
    }

    @Test
    public void setBunName() { // ТЕСТ ИМЕНИ БУЛКИ
        Bun bun = new Bun(name, price);
        String expected = name;
        String actual = bun.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void setBunPrice() { // ТЕСТ ЦЕНЫ БУЛКИ
        Bun bun = new Bun(name, price);
        float expected = price;
        float actual = bun.getPrice();
        assertEquals(expected, actual, DELTA);
    }
}
