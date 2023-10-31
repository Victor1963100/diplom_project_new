package ru.netology.qamid45.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.junit.Assert.assertEquals;

import static ru.netology.qamid45.data.Helper.elementWaiting;
import static ru.netology.qamid45.data.Helper.withIndex;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.netology.qamid45.data.Helper;
import ru.netology.qamid45.data.Data;
import static ru.netology.qamid45.elements.NewsScreen.*;

public class NewsStep {
    Data data = new Data();

    public void newsListLoad() {
        Allure.step("Загрузка списка новостей");
        elementWaiting(withId(R.id.news_list_recycler_view), 5000);
    }

    public void checkNewsElements() {
        Allure.step("Элементы экрана - News");
        newsName.check(matches(isDisplayed()));
        allNewsBlock.check(matches(isDisplayed()));
    }

    public void openFilter() {
        Allure.step("Открыть фильтр");
        filterNewsButton.check(matches(isDisplayed()));
        filterNewsButton.perform(click());
    }

    public void clickSortButton() {
        Allure.step("Нажать - сортировку");
        sortNewsButton.check(matches(isDisplayed()));
        sortNewsButton.perform(click());
    }

    public void clickEditButton() {
        Allure.step("Нажать - редактирование");
        editNewsButton.check(matches(isDisplayed()));
        editNewsButton.perform(click());
    }

    public void checkOpenNews(int position) {
        Allure.step("Развернуть выбранную новость");
        childNewsButton.perform(actionOnItemAtPosition(position, click()));
    }

    public String getFirstNewsTitle(int index) {
        Allure.step("Заголовок первой новости");
        return Helper.Text.getText(onView(withIndex(withId(R.id.news_item_title_text_view), index)));
    }

    public String getFirstNewsAfterSecondSort(int index) {
        Allure.step("Заголовок первой новости после второй сортировки");
        return Helper.Text.getText(onView(withIndex(withId(R.id.news_item_title_text_view), index)));
    }

    public void checkPublicationDate() {
        Allure.step("Дата публикации первой новости");
        String firstNewsPublicationDate = Helper.Text.getText(onView(withIndex(withId(R.id.news_item_date_text_view), 0)));
        assertEquals(firstNewsPublicationDate, data.dateOfPublic);
    }

    public String getCreateNewsDescription(int index) {
        Allure.step("Описание созданной новости");
        return Helper.Text.getText(onView(withIndex(withId(R.id.news_item_description_text_view), index)));
    }
}