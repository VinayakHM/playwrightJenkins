import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

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
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("screenshot.png")));
        System.out.println("Navigated to URL.");
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("screenshot.png"))
                .setFullPage(true));
    }

    public void teardown(){
        playwright.close();
        System.out.println("Closing the Playwright");
    }
}
