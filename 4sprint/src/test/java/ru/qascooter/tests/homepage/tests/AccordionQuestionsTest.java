package ru.qascooter.tests.homepage.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebElement;
import ru.qascooter.core.BaseTest;
import ru.qascooter.pageobject.HomePage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.qascooter.core.BaseUrls.HOME_PAGE_URL;

@RunWith(Parameterized.class)
public class AccordionQuestionsTest extends BaseTest {

    private final int questionIndex;
    private final String expectedAnswerText;

    public AccordionQuestionsTest(int questionIndex, String expectedAnswerText) {
        this.questionIndex = questionIndex;
        this.expectedAnswerText = expectedAnswerText;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestionsAndAnswers() {

        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    @Test
    public void accordionTest() {
        driver.get(HOME_PAGE_URL);
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickAcceptCookiesButton();

        WebElement questionElement = objHomePage.getAccordionQuestionsElements().get(questionIndex);
        WebElement answerElement = objHomePage.getAccordionAnswersElements().get(questionIndex);

        objHomePage.scrollToAccordionQuestionElement(questionElement);
        objHomePage.clickAccordionQuestionElement(questionElement);
        String actualAnswerText = objHomePage.getAccordionAnswerText(answerElement);

        assertThat("Ответ не соответствует ожидаемому", actualAnswerText, is(expectedAnswerText));
    }
}
