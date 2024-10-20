package ru.qascooter.tests.homepage.tests;

import org.junit.Test;
import ru.qascooter.core.BaseTest;
import ru.qascooter.pageobject.HomePage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.qascooter.core.BaseUrls.HOME_PAGE_URL;
import static ru.qascooter.core.BaseUrls.ORDER_PAGE_URL;

public class EntryPointsToOrderPageTest extends BaseTest {

    @Test
    public void checkRedirectFromHeaderToOrderPage() {
        driver.get(HOME_PAGE_URL);
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickAcceptCookiesButton();
        objHomePage.clickHeaderOrderButton();
        String currentUrl = driver.getCurrentUrl();

        assertThat(String.format("Текущий Url не соответствует %s", ORDER_PAGE_URL), currentUrl, is(ORDER_PAGE_URL));
    }

    @Test
    public void checkRedirectFromRoadmapToOrderPage() {
        driver.get(HOME_PAGE_URL);
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickAcceptCookiesButton();
        objHomePage.scrollToRoadmapOrderButton();
        objHomePage.clickRoadmapOrderButton();
        String currentUrl = driver.getCurrentUrl();

        assertThat(String.format("Текущий Url не соответствует %s", ORDER_PAGE_URL), currentUrl, is(ORDER_PAGE_URL));
    }
}
