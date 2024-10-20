package ru.qascooter.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class HomePage {
    private WebDriver driver;
    // Кнопка согласия с куками "да все привыкли"
    private final By acceptCookieButtonLocator = By.xpath(".//button[contains(@class, 'App_CookieButton')]");
    // Список вопросов из аккордеона в разделе "Вопросы о важном"
    private final By accordionQuestionElementsLocator = By.xpath(".//div[contains(@id, 'accordion__heading')" + " and @role='button']");
    // Список ответов на вопросы из аккордеона в разделе "Вопросы о важном"
    private final By accordionAnswerElementsLocator = By.xpath(".//div[contains(@id, 'accordion__panel')]/p");
    // Кнопка "Заказать" в хедере
    private final By headerOrderButtonLocator = By.xpath(".//div[contains(@class, 'Header_Nav')]" + "/button[text()='Заказать']");
    // Кнопка "Заказать" в середине страницы
    private final By roadmapOrderButtonLocator = By.xpath(".//div[contains(@class, 'Home_RoadMap')]/div/button[text()='Заказать']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getAccordionQuestionsElements() {
        return driver.findElements(accordionQuestionElementsLocator);
    }

    public List<WebElement> getAccordionAnswersElements() {
        return driver.findElements(accordionAnswerElementsLocator);
    }

    public String getAccordionAnswerText(WebElement answerElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(answerElement))
                .getText();
    }

    public void scrollToAccordionQuestionElement(WebElement question) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", question);
    }

    public void scrollToRoadmapOrderButton() {
        WebElement roadmapOrderButton = waitingForElementToBeClickable(roadmapOrderButtonLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", roadmapOrderButton);
    }

    public void clickHeaderOrderButton() {
        waitingForElementToBeClickable(headerOrderButtonLocator)
                .click();
    }

    public void clickRoadmapOrderButton() {
        waitingForElementToBeClickable(roadmapOrderButtonLocator)
                .click();
    }

    public void clickAcceptCookiesButton() {
        waitingForElementToBeClickable(acceptCookieButtonLocator)
                .click();
    }

    public void clickAccordionQuestionElement(WebElement questionElement) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(questionElement))
                .click();
    }

    public WebElement waitingForElementToBeClickable(By locatorOfElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(locatorOfElement));
    }
}
