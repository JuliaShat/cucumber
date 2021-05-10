package Interfaces;

import org.openqa.selenium.WebElement;

public interface IMainPage extends IPage {
    WebElement getRandomNameButton();

    WebElement getRandomDomainButton();

    WebElement getRoverInfoDomain();

    WebElement getEmailName();

    WebElement getSettingsButton();

    WebElement getSecretAddress();

    WebElement getCloseSettingsButton();

    WebElement getWaitingForNewLettersField();

    WebElement getWriteButton();

    WebElement getSendButton();

    WebElement getReceiverInput();

    WebElement getTopicInput();

    WebElement getTextEmailInput();

    WebElement getNewLetterMessage();

    WebElement getReplyButton();

    WebElement getReplyEmail();

    WebElement getIncomeEmailTopic();

    WebElement getIncomeEmailText();

    WebElement getBackButton();

    WebElement getTopicOfIncomeEmail();

    WebElement getOpenLastIncomeEmail();

    WebElement getDeleteLetter ();

    WebElement getConfirmDeleteLetter();

    void waitElementAndClick(WebElement element);

    void waitForVisibility(WebElement element);

    void sendEmail ( WebElement receiverInput,String receiver, WebElement topicInput, String topic,
                   WebElement textEmailInput, String text);

    void checkIncomeEmail(WebElement email, String exp1, WebElement theme, String exp2,
                          WebElement body, String exp3);

    void replyEmail (WebElement element, String str);

    void deleteEmail() throws InterruptedException;
}
