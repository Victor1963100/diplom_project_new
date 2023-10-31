package ru.netology.qamid45.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.netology.qamid45.data.Helper.waitForElement;

import io.qameta.allure.kotlin.Allure;
import static ru.netology.qamid45.elements.EditClaimsElement.*;

public class EditClaimStep {

    public void checkEditClaimElements() {
        Allure.step("Элементы экрана - Edit Claim");
        onView(isRoot()).perform(waitForElement(withText("Editing"), 5000));
        editingName.check(matches(isDisplayed()));
    }

    public void changeClaimTitle(String text) {
        Allure.step("Поменять заголовок претензии");
        editTitleText.perform(replaceText(text));
    }

    public void changeClaimDescription(String text) {
        Allure.step("Поменять описание претензии");
        editDescriptionText.perform(replaceText(text));
    }
}