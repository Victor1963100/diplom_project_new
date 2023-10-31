package ru.netology.qamid45.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;

import static ru.netology.qamid45.elements.EditNewsElement.*;

public class EditNewsStep {
    public void checkEditNewsElements() {
        Allure.step("Элементы экрана - News");
        editingName.check(matches(isDisplayed()));
        newsCategoryText.check(matches(isDisplayed()));
        newsTitleEditText.check(matches(isDisplayed()));
        newsPublishTimeText.check(matches(isDisplayed()));
        newsDescriptionText.check(matches(isDisplayed()));
        switcher.check(matches(isDisplayed()));
    }

    public void changeStatus() {
        Allure.step("Поменять статус новости");
        switcher.perform(click());
    }

    public void changeTitle(String text) {
        Allure.step("Поменять заголовок новости");
        newsTitleEditText.perform(replaceText(text));
    }

    public void changeDescription(String text) {
        Allure.step("Поменять описание новости");
        newsDescriptionText.perform(replaceText(text));
    }
}