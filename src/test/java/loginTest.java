import org.testng.annotations.Test;

public class loginTest extends BaseTest{

    @Test
    public void validTest(){
        System.out.println("Valid test.");
    }

    @Test
    public void invalidTest(){
        System.out.println("Invalid test.");
    }
}
