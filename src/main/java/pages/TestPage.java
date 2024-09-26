package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPage extends BasePage {

    private static final Long timeout = 15L;

    public TestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(css = "#test-2-div .list-group-item")
    public List<WebElement> listGroupItems;

    @FindBy(id = "dropdownMenuButton")
    private WebElement dropdownButton;

    @FindBy(css = "#test-3-div .dropdown-item")
    private List<WebElement> dropdownOptions;

    @FindBy(css = "#test-4-div .btn-primary")
    public WebElement firstButton;

    @FindBy(css = "#test-4-div .btn-secondary")
    public WebElement secondButton;

    @FindBy(id = "test5-button")
    public WebElement delayedButton;

    @FindBy(id = "test5-alert")
    public WebElement successMessage;

    @FindBy(css = "#test-6-div table tbody tr")
    public List<WebElement> gridRows;

    public String getListItemValue(int index) {
        return listGroupItems.get(index - 1).getText().replaceAll("\\s*\\d+$", "").trim();
    }

    public int getListItemBadgeValue(int index) {
        return Integer.parseInt(
            listGroupItems.get(index - 1).findElement(By.cssSelector(".badge")).getText());
    }

    public String getSelectedOption() {
        return dropdownButton.getText().trim();
    }

    public void selectDropdownOption(String option) {
        dropdownButton.click();
        for (WebElement opt : dropdownOptions) {
            if (opt.getText().equals(option)) {
                opt.click();
                break;
            }
        }
    }

    public void waitForButtonAndClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(delayedButton));
        delayedButton.click();
    }

    public String getGridCellValue(int row, int col) {
        WebElement cell = gridRows.get(row).findElements(By.tagName("td")).get(col);
        return cell.getText();
    }

    public void enterLoginDetails(String email, String password) {
        enterText(emailInput, email);
        enterText(passwordInput, password);
    }

    public void clickLogin() {
        clickElement(loginButton);
    }
}
