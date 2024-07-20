import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Base {
    Playwright playwright;
    Page page;
    Browser browser;
    static final String brow;

    static {
        brow = System.getProperty("brow");
    }
    public void init(){
        System.out.println("Launching the Browser.");
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
        page = browser.newPage();
        page.navigate("https://flipkart.com");
        System.out.println("Navigated to URL.");
    }

    public void teardown(){
        playwright.close();
        System.out.println("Closing the Playwright");
    }
}
