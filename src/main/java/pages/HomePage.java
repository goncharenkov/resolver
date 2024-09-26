package pages;

import java.io.File;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final String filePath = "src/main/resources/QE-index.html";
    private File file = new File(filePath);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage() {
        driver.get("file:///" + file.getAbsolutePath());
    }

}