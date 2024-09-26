package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.TestPage;
import utils.WebDriverSetup;

public class StepDefinitions {

    WebDriver driver = WebDriverSetup.getDriver();
    HomePage homePage = new HomePage(driver);
    TestPage testDivPage = new TestPage(driver);

    @Given("I navigate to the home page")
    public void i_navigate_to_the_home_page() {
        homePage.goToHomePage();
    }

    @Then("I should see the email and password fields and the login button")
    public void i_should_see_the_email_and_password_fields_and_the_login_button() {
        Assert.assertTrue(testDivPage.emailInput.isDisplayed());
        Assert.assertTrue(testDivPage.passwordInput.isDisplayed());
        Assert.assertTrue(testDivPage.loginButton.isDisplayed());
    }

    @When("I enter {string} and {string} in the login form")
    public void i_enter_email_and_password_in_the_login_form(String email, String password) {
        testDivPage.enterLoginDetails(email, password);
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        testDivPage.clickLogin();
    }

    @Then("I should see 3 items in the list group")
    public void i_should_see_items_in_the_list_group() {
        Assert.assertEquals(3, testDivPage.listGroupItems.size());
    }

    @Then("the second item's value should be {string}")
    public void the_second_item_s_value_should_be(String expectedValue) {
        Assert.assertEquals(expectedValue, testDivPage.getListItemValue(2));
    }

    @Then("the badge value should be {int}")
    public void the_badge_value_should_be(int expectedBadgeValue) {
        Assert.assertEquals(expectedBadgeValue, testDivPage.getListItemBadgeValue(2));
    }

    @Then("the default selected value should be {string}")
    public void the_default_selected_value_should_be(String expectedDefaultValue) {
        Assert.assertEquals(expectedDefaultValue, testDivPage.getSelectedOption());
    }

    @When("I select {string} from the dropdown menu")
    public void i_select_from_the_dropdown_menu(String option) {
        testDivPage.selectDropdownOption(option);
    }

    @Then("the selected value should be {string}")
    public void the_selected_value_should_be(String expectedSelectedValue) {
        Assert.assertEquals(expectedSelectedValue, testDivPage.getSelectedOption());
    }

    @Then("the first button should be enabled")
    public void the_first_button_should_be_enabled() {
        Assert.assertTrue(testDivPage.firstButton.isEnabled());
    }

    @Then("the second button should be disabled")
    public void the_second_button_should_be_disabled() {
        Assert.assertFalse(testDivPage.secondButton.isEnabled());
    }

    @When("I wait for the button to appear and click it")
    public void i_wait_for_the_button_to_appear_and_click_it() {
        testDivPage.waitForButtonAndClick();
    }

    @Then("a success message should be displayed")
    public void a_success_message_should_be_displayed() {
        Assert.assertTrue(testDivPage.successMessage.isDisplayed());
    }

    @Then("the button should be disabled")
    public void the_button_should_be_disabled() {
        Assert.assertFalse(testDivPage.delayedButton.isEnabled());
    }

    @Then("the value of the cell at coordinates {int}, {int} should be {string}")
    public void the_value_of_the_cell_at_coordinates_should_be(int row, int col, String expectedValue) {
        Assert.assertEquals(expectedValue, testDivPage.getGridCellValue(row, col));
    }
}
