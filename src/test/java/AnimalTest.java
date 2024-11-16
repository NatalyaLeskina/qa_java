import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {

    private String family = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    private String exceptionText = "Неизвестный вид животного, используйте значение Травоядное или Хищник";

    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        Assert.assertEquals(family, animal.getFamily());
    }

    @Test
    public void getFoodThrowExceptionTest() {
        try {
            Animal animal = new Animal();
            animal.getFood("Тест");
        } catch (Exception e) {
            Assert.assertEquals(
                    exceptionText,
                    e.getMessage()
            );
        }
    }
}
