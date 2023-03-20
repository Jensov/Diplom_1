import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    Burger burger = new Burger();
    Ingredient ingredientFirst = new Ingredient(FILLING, "ДВЕ МЯСНЫХ КОТЛЕТЫ ГРИЛЬ", 300);
    Ingredient ingredientSecond = new Ingredient(SAUCE, "СПЕЦИАЛЬНЫЙ СОУС", 100);
    Ingredient ingredientThird = new Ingredient(FILLING, "СЫР", 200);
    Ingredient ingredientFourth = new Ingredient(FILLING, "ОГУРЦЫ, САЛАТ И ЛУК", 200);

    public final static Double DELTA = 0.00001;


    @Test
    public void setBunsTest() {
        burger.setBuns(new Bun("БУЛОЧКА С КУНЖУТОМ", 50));
        assertEquals("БУЛОЧКА С КУНЖУТОМ", burger.bun.getName());
        assertEquals(50, burger.bun.getPrice(), 0.0002);
    }

    @Test
    public void checkAddIngredientInIngredientList() {
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);
        burger.addIngredient(ingredientFourth);
        assertEquals(ingredientFirst, burger.ingredients.get(0));
        assertEquals(ingredientSecond, burger.ingredients.get(1));
        assertEquals(ingredientThird, burger.ingredients.get(2));
        assertEquals(ingredientFourth, burger.ingredients.get(3));
    }

    @Test
    public void removeIngredientInIngredientList() {
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);
        burger.addIngredient(ingredientFourth);
        burger.removeIngredient(0);
        assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void moveIngredientInIngredientList() {
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);
        burger.addIngredient(ingredientFourth);
        burger.moveIngredient(1, 2);
        assertEquals(ingredientThird, burger.ingredients.get(1));
        assertEquals(ingredientSecond, burger.ingredients.get(2));
    }

    @Test
    public void getSumPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(10f);
        Mockito.when(ingredient.getPrice()).thenReturn(10f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        float expected = 30f;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getReceipt() throws IOException {
        String reference = Files.readString(Paths.get("src/test/java/Receipt"));
        burger.addIngredient(ingredientFirst);
        burger.addIngredient(ingredientSecond);
        burger.addIngredient(ingredientThird);
        burger.addIngredient(ingredientFourth);
        burger.setBuns(new Bun("БУЛОЧКА С КУНЖУТОМ", 50));
        String actual = burger.getReceipt();
        assertEquals(reference, actual);
    }
}
