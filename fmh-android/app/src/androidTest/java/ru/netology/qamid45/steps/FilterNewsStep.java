package ru.netology.qamid45.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;

import io.qameta.allure.kotlin.Allure;
import static ru.netology.qamid45.elements.FilterNewsElement.*;

public class FilterNewsStep {
    public void checkFilterElements() {
        Allure.step("Элементы экрана - Фильтр");
        filterNewsName.check(matches(isDisplayed()));
        categoryText.check(matches(isDisplayed()));
        dateStartText.check(matches(isDisplayed()));
        dateEndText.check(matches(isDisplayed()));
        filterButton.check(matches(isClickable()));
    }

    public void clickFilter() {
        Allure.step("Нажать кнопку - Фильтр");
        filterButton.perform(click());
    }

    public void fillInStartDateField(String startDate) {
        Allure.step("Поле начальная дата - ввод данных");
        dateStartText.perform(replaceText(startDate));
    }

    public void fillInEndDateField(String endDate) {
        Allure.step("Поле конечная дата - ввод данных");
        dateEndText.perform(replaceText(endDate));
    }

    public void clickActiveCheckBox() {
        Allure.step("Нажать чекбокс - Active");
        filterActive.perform(click());
    }

    public void clickNotActiveCheckBox() {
        Allure.step("Нажать чекбокс - Not active");
        filterNotActive.perform(click());
    }

    public void checkBoxStatusActive(boolean checked) {
        Allure.step("Проверка нажатия - Active");
        if (checked) {
            filterActive.check(matches(isChecked()));
        } else {
            filterActive.check(matches(isNotChecked()));
        }
    }

    public void checkBoxStatusNotActive(boolean checked) {
        Allure.step("Проверка нажатия - Not active");
        if (checked) {
            filterNotActive.check(matches(isChecked()));
        } else {
            filterNotActive.check(matches(isNotChecked()));
        }
    }
}