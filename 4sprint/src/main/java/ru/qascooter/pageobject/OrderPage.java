package ru.qascooter.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    // Поле для заполнения "Имя"
    private final By firstNameInputLocator = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    // Поле для заполнения "Фамилия"
    private final By secondNameInputLocator = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    // Поле для заполнения "Адрес"
    private final By deliveryAddressInputLocator = By.xpath(".//input[contains(@placeholder, 'Адрес')]");
    // Поле для выбора "Станция метро"
    private final By metroStationInputLocator = By.xpath(".//input[@class='select-search__input']");
    // Список с доступными станциями метро
    private final By metroStationOptionsLocator = By.xpath(".//button[contains(@class, 'select-search__option')]");
    // Поле для заполнения "Телефон"
    private final By phoneInputLocator = By.xpath(".//input[contains(@placeholder, 'Телефон')]");
    // Кнопка "Далее"
    private final By continueButtonLocator = By.xpath(".//button[contains(@class, 'Button') and text()='Далее']");
    // Поле для заполнения даты "Когда привезти самокат"
    private final By dateOfDeliveryLocator = By.xpath(".//input[contains(@placeholder, 'самокат')]");
    // Клик по телу текущей страницы
    private final By bodyOfCurrentPageLocator = By.xpath(".//body");
    // Выпадающий список "Срок аренды"
    private final By rentalOptionsLocator = By.xpath(".//div[contains(@class, 'Dropdown-placeholder') and contains(text(), 'Срок аренды')]");
    // Путь для формирования локатора выбора срока аренды
    private final String rentalOptionPath = ".//div[@class='Dropdown-option' and contains(text(), '%s')]";
    // Путь для формирования локатора для цвета самоката
    private final String scooterColourPath = ".//label[contains(text(), '%s')]/input[@type='checkbox']";
    // Комментарий для курьера
    private final By commentForDeliveryLocator = By.xpath(".//input[contains(@placeholder, 'Комментарий для курьера')]");
    // кнопка "Заказать" на форме заказа
    private final By submitOrderButtonLocator = By.xpath(".//div[contains(@class, 'Order_Buttons')]/button[text()='Заказать']");
    // кнопка подтверждения заказа
    private final By confirmWithOrderButtonLocator = By.xpath(".//div[contains(@class, 'Order_Buttons')]/button[text()='Да']");
    // Модалка успешного заказа
    private final By successModalLocator = By.xpath(".//div[contains(@class, 'Order_Modal') and text()='Заказ оформлен']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String firstName) {
        WebElement firstNameInput = waitingForElementToBeClickable(firstNameInputLocator);
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void setSecondName(String lastName) {
        WebElement secondNameInput = waitingForElementToBeClickable(secondNameInputLocator);
        secondNameInput.click();
        secondNameInput.clear();
        secondNameInput.sendKeys(lastName);
    }

    public void setDeliveryAddress(String deliveryAddress) {
        WebElement deliveryAddressInput = waitingForElementToBeClickable(deliveryAddressInputLocator);
        deliveryAddressInput.click();
        deliveryAddressInput.clear();
        deliveryAddressInput.sendKeys(deliveryAddress);
    }

    public void selectMetroStation(String stationName) {
        WebElement metroStationInput = waitingForElementToBeClickable(metroStationInputLocator);
        metroStationInput.click();
        metroStationInput.clear();
        metroStationInput.sendKeys(stationName);

        WebElement stationOption = waitingForElementToBeClickable(metroStationOptionsLocator);
        stationOption.click();
    }

    public void setPhone(String phone) {
        WebElement phoneInput = waitingForElementToBeClickable(phoneInputLocator);
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void clickContinueButton() {
        waitingForElementToBeClickable(continueButtonLocator)
                .click();
    }

    public void setDateOfDelivery(String dateOfDelivery) {
        WebElement dateOfDeliveryInput = waitingForElementToBeClickable(dateOfDeliveryLocator);
        dateOfDeliveryInput.click();
        dateOfDeliveryInput.clear();
        dateOfDeliveryInput.sendKeys(dateOfDelivery);
        driver.findElement(bodyOfCurrentPageLocator).click();
    }

    public void selectRentalPeriod(String rentalPeriod) {
        WebElement rentalOptions = waitingForElementToBeClickable(rentalOptionsLocator);
        rentalOptions.click();

        String xpathForRentalOption = String.format(rentalOptionPath, rentalPeriod);

        WebElement rentalOption = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathForRentalOption)));
        rentalOption.click();
    }

    public void selectScooterColour(String scooterColour) {
        String xpathForCheckbox = String.format(scooterColourPath, scooterColour);

        WebElement scooterColourCheckbox = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpathForCheckbox)));
        if (!scooterColourCheckbox.isSelected()) {
            scooterColourCheckbox.click();
        }
    }

    public void setCommentForDelivery(String commentForDelivery) {
        WebElement commentForDeliveryInput = waitingForElementToBeClickable(commentForDeliveryLocator);
        commentForDeliveryInput.click();
        commentForDeliveryInput.clear();
        commentForDeliveryInput.sendKeys(commentForDelivery);
    }

    public void clickSubmitOrderButton() {
        waitingForElementToBeClickable(submitOrderButtonLocator)
                .click();
    }

    public void clickConfirmOrderButton() {
        waitingForElementToBeClickable(confirmWithOrderButtonLocator)
                .click();
    }

    public boolean isModalOfSuccessVisible() {
        WebElement modalOfSuccess = new WebDriverWait(driver, Duration.ofSeconds(7)).
                until(ExpectedConditions.visibilityOfElementLocated(successModalLocator));
        return modalOfSuccess.isDisplayed();
    }

    public WebElement waitingForElementToBeClickable(By locatorOfElement) {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(locatorOfElement));
    }
}
