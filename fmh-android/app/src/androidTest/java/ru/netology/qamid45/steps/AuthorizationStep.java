package ru.netology.qamid45.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static ru.netology.qamid45.data.Helper.elementWaiting;
import static ru.netology.qamid45.data.Helper.emptyLogin;
import static ru.netology.qamid45.data.Helper.emptyPassword;
import static ru.netology.qamid45.data.Helper.invalidAuthData;
import static ru.netology.qamid45.data.Helper.invalidLoginData;
import static ru.netology.qamid45.data.Helper.invalidPassData;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.netology.qamid45.data.Helper;
import static ru.netology.qamid45.elements.AuthorizationScreen.*;

public class AuthorizationStep {
    public void loadAuthPage() {
        Allure.step("Загрузка страницы авторизации");
        elementWaiting(withId(R.id.enter_button), 5000);
    }

    public void checkAuthScreenElements() {
        Allure.step("Элементы экрана авторизации");
        nameAuthText.check(matches(isDisplayed()));
        loginText.check(matches(isDisplayed()));
        passText.check(matches(isDisplayed()));
        signButton.check(matches(isDisplayed()));
    }

    public void authWithValidLoginAndPass (Helper.User info) {
        Allure.step("Авторизация с валидным логином и паролем");
        checkAuthScreenElements();
        loginText.perform(replaceText(info.getLogin()));
        passText.perform(replaceText(info.getPass()));
    }

    public void authWithInvalidLoginAndPass (Helper.User info) {
        Allure.step("Авторизация с невалидными логином и паролем");
        checkAuthScreenElements();
        loginText.perform(replaceText(invalidAuthData().getLogin()));
        passText.perform(replaceText(invalidAuthData().getPass()));
    }

    public void authWithInvalidLogin (Helper.User info) {
        Allure.step("Авторизация с невалидным логином и валидным паролем");
        checkAuthScreenElements();
        loginText.perform(replaceText(invalidLoginData().getLogin()));
        passText.perform(replaceText(invalidLoginData().getPass()));
    }

    public void authWithInvalidPass (Helper.User info) {
        Allure.step("Авторизация с невалидным паролем и валидным логином");
        checkAuthScreenElements();
        loginText.perform(replaceText(invalidPassData().getLogin()));
        passText.perform(replaceText(invalidPassData().getPass()));
    }

    public void authWithEmptyPass (Helper.User info) {
        Allure.step("Авторизация с пустым паролем");
        loginText.perform(replaceText(emptyPassword().getLogin()));
        passText.perform(replaceText(emptyPassword().getPass()));
    }

    public void authWithEmptyLogin (Helper.User info) {
        Allure.step("Авторизация с пустым логином");
        loginText.perform(replaceText(emptyLogin().getLogin()));
        passText.perform(replaceText(emptyLogin().getPass()));
    }

    public static void clickLoginFieldWithSpecialCharacters() {
        Allure.step("Ввести в поле Логин спецсимволы");
        loginText.perform(replaceText(emptyLogin().getLogin()));
        passText.perform(replaceText(emptyLogin().getPass()));
    }


    public void clickSignInButton() {
        Allure.step("Нажать кнопку SignIn");
        signButton.perform(click());
    }
}