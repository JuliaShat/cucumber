package Steps;
import Core.Config;
import Core.DriverFactory;
import Interfaces.IMainPage;
import Pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java8.Th;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class MainPageSteps extends Steps {

    String randomEmail;
    String secretAddress;

    @Given("^I open main page$")
    public void iOpenMainPage() {
        log.info("I open main page");
        DriverFactory.getDriver().get(Config.URL_SITE);
        DriverFactory.start();
    }

    @And("^I choose random name$")
    public void iChooseRandomName() {
        log.info("I click random name button");
        mp.getRandomNameButton().click();
    }

    @And("I click dropdown domain menu")
    public void iClickDropdownDomainMenu() {
        log.info("I click dropdown domain button");
        mp.getRandomDomainButton().click();
    }

    @And("^I choose rover info domain$")
    public void iChooseRoverInfoDomain() {
        log.info("I click rover info domain");
        mp.waitElementAndClick(mp.getRoverInfoDomain());
    }

    @Then ("^I remember email address$")
    public void iRememberEmailAddress() {
        log.info("I remember the email");
            randomEmail = mp.getEmailName().getAttribute("value") + mp.getRandomDomainButton().getText(); }


    @And("^I open settings$")
    public void iOpenSettings() {
        log.info("I click settings button");
        mp.getSettingsButton().click();
    }

    @And("I remember the secret address")
    public void iRememberTheSecretAddress() {
        log.info("I remember secret address");
        secretAddress = mp.getSecretAddress().getAttribute("textContent");
    }

    @And("^I close settings$")
    public void iCloseSettings() throws InterruptedException {
        log.info("I click close settings button");
        Thread.sleep(500);
        mp.waitElementAndClick(mp.getCloseSettingsButton());
    }


    @Then("^I check the settings window is closed$")
    public void iCheckTheSettingsWindowIsClosed() {
        log.info("I check the settings window is closed");
        Assert.assertTrue("Settings window is not closed",
                mp.getRandomNameButton().isDisplayed());
    }

    @Then("^I check waiting new letters string is visible$")
    public void iCheckWaitingNewLettersStringIsVisible() {
        log.info("I check waiting new letters string is visible");
        mp.waitForVisibility(mp.getWaitingForNewLettersField());
}



    @Given("^I write new letter$")
    public void iWriteNewLetter() {
        log.info("I click write letter button");
        mp.waitElementAndClick(mp.getWriteButton());
    }

    @And("I'm waiting for the email submission form is visible")
    public void iMWaitingForTheEmailSubmissionFormIsVisible() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue("Email submission form is not open",
                mp.getReceiverInput().isDisplayed());
    }


    @And("^I fill in the email$")
    public void iWriteTheLetterToMyEmailThemeBodyMySecretAddress() {
        log.info("I write the email");
        mp.sendEmail(
                mp.getReceiverInput(), randomEmail,
                mp.getTopicInput(), "Test",
                mp.getTextEmailInput(), secretAddress);
    }

    @And("^I send the email$")
    public void iSendTheEmail() {
        log.info("I click send letter button");
        mp.getSendButton().click();
    }


    @And("^I wait for the new letter income and open it$")
    public void iWaitForTheNewLetterIncomeAndOpenIt() throws InterruptedException {
        Thread.sleep(700);
        log.info("I open the income letter");
        mp.waitElementAndClick(mp.getNewLetterMessage());
    }


    @Then("^I check the income email content$")
    public void iCheckTheIncomeEmailContent() {
        log.info("I check the income email content");
        mp.checkIncomeEmail(
                mp.getReplyEmail(), randomEmail,
                mp.getIncomeEmailTopic(), "Test",
                mp.getIncomeEmailText(), secretAddress);
    }

    @And("^I click to reply$")
    public void iClickToReply() {
        log.info("I click reply button");
        mp.getReplyButton().click();
    }


    @And("I fill in and send the email Test2")
    public void iWriteToBodyTestTwo() throws InterruptedException {
        log.info("I send the email Test2");
        Thread.sleep(600);
        mp.replyEmail(mp.getTextEmailInput(), "Test2");
        mp.getSendButton().click();
    }


    @And("^I go back to the main page$")
    public void iGoBackToTheMainPage() {
        log.info("I click back button");
        mp.getBackButton().click();
    }


    @Then("I check letter ReTest")
    public void iCheckLetterReTest() {
        log.info("I check letter ReTest");
        String topic = "Re: Test";
        Assert.assertEquals(mp.getTopicOfIncomeEmail().getText(), topic);
    }

    @Given("^I open last income letter$")
    public void iOpenLastIncomeLetter() {
        log.info("I open last income letter");
        mp.waitElementAndClick(mp.getOpenLastIncomeEmail());
    }

    @And("I check the Re income email content")
    public void iCheckTheReIncomeEmailContent() {
        log.info("I check the Re income email content");
        mp.checkIncomeEmailText(mp.getIncomeEmailText(), "Test2");
    }

    @And("^I delete the email$")
    public void iDeleteTheLetter() throws InterruptedException {
        log.info("I click delete email button");
        mp.deleteEmail();
    }

    @Then("I check that Re email was deleted")
    public void iCheckThatReEmailWasDeleted() throws InterruptedException {
        log.info("I check that Re email was deleted");
        Thread.sleep(500);
        Assert.assertFalse(DriverFactory.getDriver().getPageSource().contains("Re: Test"));
    }

    @Then("I close browser")
    public void iCloseBrowser() {
        log.info("I click the close browser button");
        DriverFactory.quit();
    }
}

