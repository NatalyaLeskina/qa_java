import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private String exceptionText = "Используйте допустимые значения пола животного - самец или самка";

    @Mock
    Feline feline;

    @Test
    public void hasManeThrowExceptionTest() {
        try {
            Lion lion = new Lion("Тест", feline);
        } catch (Exception e) {
            Assert.assertEquals(
                    exceptionText,
                    e.getMessage()
            );
        }
    }

    @Test
    public void getFoodTest() {
        try {
            Lion lion = new Lion("Самец", feline);
            lion.getFood();
            Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getKittensTest() {
        try {
            Lion lion = new Lion("Самец", feline);
            lion.getKittens();
            Mockito.verify(feline, Mockito.times(1)).getKittens();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
