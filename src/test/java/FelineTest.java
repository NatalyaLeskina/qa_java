import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void getFamilyTest() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithParamTest() {
        int param = 3;
        Assert.assertEquals(param, feline.getKittens(param));
    }

    @Test
    public void getKittensNoParamTest() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void eatMeatTest() {
        try {
            feline.eatMeat();
            Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
