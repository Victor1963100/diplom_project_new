package ru.netology.qamid45.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static ru.netology.qamid45.data.Helper.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

import static ru.netology.qamid45.elements.AboutScreen.*;
public class AboutStep {

    public void checkScreenElementsAbout() {
        Allure.step("Проверка элементов экрана About us");
        elementWaiting(withId(R.id.about_company_info_label_text_view), 5000);
        trademark.check(matches(isDisplayed()));
        versionTitle.check(matches(isDisplayed()));
        versionValue.check(matches(isDisplayed()));
        privacyPolicyLabel.check(matches(isDisplayed()));
        privacyPolicyValue.check(matches(isDisplayed()));
        termsOfUseLabel.check(matches(isDisplayed()));
        termsOfUseValue.check(matches(isDisplayed()));
        companyInfoLabel.check(matches(isDisplayed()));
        returnButton.check(matches(isDisplayed()));
    }

    public void clickLinkPrivacyPolicy() {
        Allure.step("Кликабельность ссылки - Политика конфиденциальности");
        elementWaiting(withId(R.id.about_company_info_label_text_view), 5000);
        privacyPolicyValue.check(matches(isClickable()));
    }

    public void clickLinkTermsofUse() {
        Allure.step("Кликабельность ссылки - Условия использования");
        termsOfUseValue.check(matches(isClickable()));
    }

    public void checkReturnButton() {
        Allure.step("Работа кнопки возврат");
        returnButton.perform(click());
    }
}