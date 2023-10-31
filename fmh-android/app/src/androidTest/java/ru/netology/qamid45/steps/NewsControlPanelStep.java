package ru.netology.qamid45.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.assertEquals;
import static ru.netology.qamid45.data.Helper.waitForElement;
import static ru.netology.qamid45.data.Helper.withIndex;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.netology.qamid45.data.Helper;
import static ru.netology.qamid45.elements.NewsControlPanelScreen.*;

public class NewsControlPanelStep {

    public void checkPanelElements() {
        Allure.step("Элементы - Control panel");
        panelName.check(matches(isDisplayed()));
        sortNewsButton.check(matches(isDisplayed()));
        filterNewsButton.check(matches(isDisplayed()));
        addNewsButton.check(matches(isDisplayed()));
    }

    public String getFirstNewsDate(int index) {
        Allure.step("Дата публикации первой новости");
        return Helper.Text.getText(onView(withIndex(withId(R.id.news_item_publication_date_text_view), index)));
    }

    public String getFirstNewsDateAfterSecondSort(int index) {
        Allure.step("Получить дату публикации первой новости после двух сортировок");
        return Helper.Text.getText(onView(withIndex(withId(R.id.news_item_publication_date_text_view), index)));
    }
    public void checkPanelSort() {
        Allure.step("Cортировка новостей");
        String firstNewsPublication = getFirstNewsDate(0);
        clickSortNewsButton();
        newsList.perform(swipeDown());
        clickSortNewsButton();
        newsList.perform(swipeDown());
        String firstNewsPublicationAfterSecondSorting = getFirstNewsDateAfterSecondSort(0);
        assertEquals(firstNewsPublication, firstNewsPublicationAfterSecondSorting);
    }
    public void clickSortNewsButton() {
        Allure.step("Нажать кнопку сортировки");
        sortNewsButton.perform(click());
    }

    public void openNewsFilter() {
        Allure.step("Открыть расширенный фильтр");
        filterNewsButton.perform(click());
    }

    public void clickCreateNewsButton() {
        Allure.step("Нажать - создание новости");
        addNewsButton.perform(click());
    }

    public void clickEditNews(int index) {
        Allure.step("Нажать редактирование новости");
        onView(withIndex(withId(R.id.edit_news_item_image_view), index)).perform(click());
        onView(isRoot()).perform(waitForElement(withText("Editing"), 5000));
    }

    public void clickOneNewsItem(int index) {
        Allure.step("Нажать любую новость");
        newsList.perform(actionOnItemAtPosition(index, click()));
    }

    public String getEditNewsTitle(int index) {
        Allure.step("Редактированный заголовок новости");
        return Helper.Text.getText(onView(withIndex(withId(R.id.news_item_title_text_view), index)));
    }

    public String getEditNewsDescription(int index) {
        Allure.step("Редактированное содержание новости");
        return Helper.Text.getText(onView(withIndex(withId(R.id.news_item_description_text_view), index)));
    }

    public void checkStatusNotActive() {
        Allure.step("Статус - Not active");
        statusNotActive.check(matches(withText("Not active")));
    }

    public void checkStatusActive() {
        Allure.step("Статус - Active");
        statusActive.check(matches(withText("Active")));
    }

    public void checkCreateNews(int position, String titleText, String descriptionText) {
        Allure.step("Заголовщк и содержание новости");
        newsList.perform(actionOnItemAtPosition(position, click()));
        onView(isRoot()).perform(waitForElement(withId(R.id.news_item_description_text_view),5000));
        newsTitleText.check(matches(withText(titleText)));
        newsDescriptionText.check(matches(withText(descriptionText)));
    }
}