import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {

    private final String animalKind;
    private final List<String> foodKind;

    public AnimalParameterizedTest(String animalKind, List<String> foodKind) {
        this.animalKind = animalKind;
        this.foodKind = foodKind;
    }

    @Parameterized.Parameters
    public static Object[][] getFood() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }

    @Test
    public void getFoodTest() {
        Animal animal = new Animal();
        try {
            Assert.assertEquals(foodKind, animal.getFood(animalKind));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
