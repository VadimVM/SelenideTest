import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.vadym.page.GoogleAction;
import com.vadym.page.GooglePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class SearchTest {
    private GoogleAction googleAction;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        googleAction = new GoogleAction();
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
    public void searchShouldHaveText() {
        googleAction.searchText("gradle");
        new GooglePage().getResSearch().shouldHave(Condition.text("Gradle Build"));
    }

    @Test
    public void firstLinkShouldHaveText() {
        googleAction.searchText("gradle");
        new GooglePage().getResSearchByCSS(0).shouldHave(Condition.text("Gradle Build"));
    }

    @Test
    public void countLinksByxPaTh() {
        googleAction.searchText("gradle");
        new GooglePage().getRes().shouldHave(CollectionCondition.size(14));
    }
}
