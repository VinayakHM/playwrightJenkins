import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest extends Base {

    @BeforeTest
    public void initializeSuite() {
        init();
    }

    @AfterTest
    public void endSuite() {
        teardown();
    }
}
