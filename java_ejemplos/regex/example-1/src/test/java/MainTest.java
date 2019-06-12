import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MainTest {

    Main main = new Main();
    String[] args = new String[0];

    @Test
    public void mainTest() {

        String[] results = main.prepareResults();

        Assert.assertTrue(Main.results.length == results.length);

        main.main(args);
    }
}
