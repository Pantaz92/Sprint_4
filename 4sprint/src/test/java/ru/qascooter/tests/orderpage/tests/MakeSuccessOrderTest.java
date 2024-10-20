package ru.qascooter.tests.orderpage.tests;

import org.junit.Test;
import ru.qascooter.core.BaseTest;
import ru.qascooter.pageobject.OrderPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.qascooter.core.BaseUrls.ORDER_PAGE_URL;

public class MakeSuccessOrderTest extends BaseTest {

    @Test
    public void makeSuccessOrderForAirport() {
        driver.get(ORDER_PAGE_URL);
        OrderPage objOrderPage = new OrderPage(driver);

        objOrderPage.setFirstName("Евгений");
        objOrderPage.setSecondName("Вольнов");
        objOrderPage.setDeliveryAddress("Улица Пушкина, дом Колотушкина");
        objOrderPage.selectMetroStation("Аэропорт");
        objOrderPage.setPhone("79258656238");
        objOrderPage.clickContinueButton();

        objOrderPage.setDateOfDelivery("31.12.2024");
        objOrderPage.selectRentalPeriod("сутки");
        objOrderPage.selectScooterColour("чёрный жемчуг");
        objOrderPage.setCommentForDelivery("Квартира Петрова, спросите Вольнова");
        objOrderPage.clickSubmitOrderButton();

        objOrderPage.clickConfirmOrderButton();
        boolean isSuccessVisible = objOrderPage.isModalOfSuccessVisible();

        assertThat("Модалка успеха не найдена", isSuccessVisible, is(true));
    }

    @Test
    public void makeSuccessOrderForSokol() {
        driver.get(ORDER_PAGE_URL);
        OrderPage objOrderPage = new OrderPage(driver);

        objOrderPage.setFirstName("Артемий");
        objOrderPage.setSecondName("Лебедев");
        objOrderPage.setDeliveryAddress("Улица Петушкова");
        objOrderPage.selectMetroStation("Сокол");
        objOrderPage.setPhone("79278655218");
        objOrderPage.clickContinueButton();

        objOrderPage.setDateOfDelivery("15.12.2024");
        objOrderPage.selectRentalPeriod("четверо суток");
        objOrderPage.selectScooterColour("серая безысходность");
        objOrderPage.setCommentForDelivery("Квартира Какадуева, спросите Петушкова");
        objOrderPage.clickSubmitOrderButton();

        objOrderPage.clickConfirmOrderButton();
        boolean isSuccessVisible = objOrderPage.isModalOfSuccessVisible();

        assertThat("Модалка успеха не найдена", isSuccessVisible, is(true));
    }
}
