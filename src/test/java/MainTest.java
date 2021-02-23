import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {
    private static final PrintStream standOut = System.out;
    private static final ByteArrayOutputStream catcher = new ByteArrayOutputStream();

    @BeforeTest
    public static void catchOut() {
        System.setOut(new PrintStream(catcher));
    }

    @Test
    public void printHello() {
        Main m = new Main();
        m.main(new String[]{});
        String testString = String.valueOf(catcher);
        String hello = "Hello Global!";
        Assert.assertEquals(hello, testString);

    }

    @AfterTest
    public static void backOut() {
        System.setOut(standOut);
    }
}
