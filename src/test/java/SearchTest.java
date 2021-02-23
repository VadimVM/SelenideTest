import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class SearchTest {
    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void openGoogle() {
        open("http://google.com");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void searchWordFromGoogle() {
        $(By.name("q")).setValue("gradle").pressEnter();
        $x("//div[@id='search']").shouldHave(Condition.text("Gradle Build"));
    }
    @Test
    public void countLinksByCSS() {
        $(By.name("q")).setValue("gradle").pressEnter();
        $$("#rso .g").shouldHave(CollectionCondition.size(15));
    }
    @Test
    public void countLinksByxPaTh() {
        $(By.name("q")).setValue("gradle").pressEnter();
        $$x("//div[@class='g']").shouldHave(CollectionCondition.size(14));
    }
}
