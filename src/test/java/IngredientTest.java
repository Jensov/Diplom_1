import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    private final String name = "Майонез";
    private final float price = 100f;
    Ingredient ingredient = new Ingredient(SAUCE, name, price);
    public final static Double DELTA = 0.00001;

    @Test
    public void callGetNameIngredientTest() {
        String expected = name;
        String actual = ingredient.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void callGetPriceIngredientTest() {
        float expected = price;
        float actual = ingredient.getPrice();
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void callGetTypeIngredientTest() {
        IngredientType expected = SAUCE;
        IngredientType actual = ingredient.getType();
        assertEquals(expected, actual);
    }
}