package Pages;

import Core.DriverFactory;
import Interfaces.IMainPage;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Core.DriverFactory.getDriver;

@Getter

    public class MainPage implements IMainPage {

        public MainPage() {
            PageFactory.initElements(DriverFactory.getDriver(), this);
        }
        WebDriverWait wait;

        @FindBy(css = "#pre_rand")
        private WebElement randomNameButton;

        @FindBy(css = "#domain")
        private WebElement randomDomainButton;

        @FindBy(css = "#pre_form > div > div.dropdown.mb-30.mb-md-0.show > div > button:nth-child(6)")
        private WebElement roverInfoDomain;

        @FindBy(css = "#pre_settings")
        private WebElement settingsButton;

        @FindBy(css = "#pre_button")
        private WebElement emailName;

        @FindBy(css = "#secret-address")
        private WebElement secretAddress;

        @FindBy(css = "#modal-settings > div > form > div.modal-header > div > button")
        private WebElement closeSettingsButton;

        @FindBy(css = "#container-body > div > div.inbox > div > span")
        private WebElement waitingForNewLettersField;

        @FindBy(css = "#compose")
        private WebElement writeButton;

        @FindBy(css = "#submit")
        private WebElement sendButton;

        @FindBy(css = "#to")
        private WebElement receiverInput;

        @FindBy(css = "#subject")
        private WebElement topicInput;

        @FindBy(css = "#text")
        private WebElement textEmailInput;

        @FindBy(css = "#container-body > div > div.inbox > div.mail > div > div.from.col-9.col-md-4")
        private WebElement newLetterMessage;

        @FindBy(xpath = "//*[@id=\"reply\"]")
        private WebElement replyButton;

        @FindBy(xpath = "//*[@id=\"info\"]/div[1]/div[1]/span")
        private WebElement replyEmail;

        @FindBy(css = "#info > div.subject.mb-20")
        private WebElement incomeEmailTopic;

        @FindBy(css = "#info > div.overflow-auto.mb-20")
        private WebElement incomeEmailText;

        @FindBy(css = "#back")
        private WebElement backButton;

        @FindBy(css = "#container-body > div > div.inbox > div:nth-child(2) > div > div.subj.col-12.col-md-7.px-md-3 > span")
        private WebElement topicOfIncomeEmail;

        @FindBy(css = "#container-body > div > div.inbox > div:nth-child(2) > div > div.from.col-9.col-md-4")
        private WebElement openLastIncomeEmail;

        @FindBy(css = "#delete_mail")
        private WebElement deleteLetter;

        @FindBy(css = "#confirm_mail")
        private WebElement confirmDeleteLetter;

    public void waitElementAndClick(WebElement element) {
        new WebDriverWait(getDriver(), 120).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForVisibility(WebElement element) {
        new WebDriverWait(getDriver(), 120).until(ExpectedConditions.visibilityOf(element));}



        public void sendEmail( WebElement receiverInput,String receiver, WebElement topicInput, String topic,
                               WebElement textEmailInput, String text) {
            getReceiverInput().sendKeys(receiver);
            getTopicInput().sendKeys(topic);
            getTextEmailInput().sendKeys(text);
        }

        public void checkIncomeEmail(WebElement email, String exp1, WebElement theme, String exp2,
                                     WebElement body, String exp3) {
            String checkEmail = getReplyEmail().getAttribute("textContent");
            Assert.assertEquals(exp1, checkEmail);
            String checkTopic = getIncomeEmailTopic().getAttribute("textContent");
            Assert.assertEquals(exp2, checkTopic);
            String checkText = getIncomeEmailText().getAttribute("textContent");
            Assert.assertEquals(exp3, checkText);
        }

    public void replyEmail (WebElement element, String string) {
        element.sendKeys(string);
    }

    public void checkIncomeEmailText (WebElement element, String theme) {
        String toCheckRe = element.getAttribute("textContent");
        Assert.assertEquals(theme, toCheckRe);
    }

        public void deleteEmail () throws InterruptedException {
            getDeleteLetter().click();
            Thread.sleep(500);
            getConfirmDeleteLetter().click();
        }
}
