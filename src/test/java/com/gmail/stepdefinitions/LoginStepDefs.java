package com.gmail.stepdefinitions;

import com.gmail.pages.SignInPage;
import com.gmail.utilities.BrowserUtils;
import com.gmail.utilities.ConfigurationReader;
import com.gmail.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    SignInPage signInPage = new SignInPage();

    @Given("user should be on the gmail sign in page")
    public void user_should_be_on_the_gmail_sign_in_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("user enters valid username")
    public void user_enters_valid_username() {
        signInPage.userNameBox.sendKeys(ConfigurationReader.get("username"));
    }

    @When("clicks forward button")
    public void clicks_forward_button() {
        signInPage.forwardButton.click();
    }

    @When("user enters valid password")
    public void user_enters_valid_password() {
        signInPage.passwordBox.sendKeys(ConfigurationReader.get("password"));
    }

    @Then("user should be able to login")
    public void user_should_be_able_to_login() throws InterruptedException {
        BrowserUtils.waitForVisibility(signInPage.inboxButton,5);
        Assert.assertTrue(Driver.get().getTitle().contains("Gelen Kutusu"));
    }

    @When("user enters invalid username")
    public void user_enters_invalid_username() {
        signInPage.userNameBox.sendKeys("WrongUserName");
    }

    @Then("user should not be able to login")
    public void user_should_not_be_able_to_login() throws InterruptedException {
        Assert.assertTrue(signInPage.passwordWarning.isDisplayed());
    }

    @When("user enters invalid password")
    public void user_enters_invalid_password() {
        signInPage.passwordBox.sendKeys("WrongPassword");
    }

    @Then("user should see the {string} message")
    public void user_should_see_the_message(String string) {
        BrowserUtils.waitForVisibility(signInPage.tryAgainButton,5);
        Assert.assertEquals(string,signInPage.warningMessage.getText());
    }

    @When("user enters wrong username")
    public void user_enters_wrong_username() {
        signInPage.userNameBox.sendKeys("abc@gmail.com");
    }

    @Then("user should see the Your Google Account was not found message")
    public void user_should_see_the_Your_Google_Account_was_not_found_message() {
        Assert.assertTrue(signInPage.notFoundMessage.isDisplayed());
    }

    @Then("user should see the empty warning message for username")
    public void user_should_see_the_empty_warning_message_for_username() {
        Assert.assertTrue(signInPage.emptyUsernameWarning.isDisplayed());
    }

    @Then("user should see the empty warning message for password")
    public void user_should_see_the_empty_warning_message_for_password() {
        Assert.assertTrue(signInPage.emptyPasswordWarning.isDisplayed());
    }

    @When("waits for password screen to load")
    public void waits_for_password_screen_to_load() {
        BrowserUtils.waitForVisibility(signInPage.showPasswordButton,5);
    }


}
