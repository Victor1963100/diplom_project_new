package ru.netology.qamid45.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.core.IsNot.not;

import static ru.netology.qamid45.data.Helper.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import static ru.netology.qamid45.elements.GeneralElements.*;
import static ru.netology.qamid45.elements.TimeElement.*;

public class GeneralStep {

    public void clickSaveButton() {
        Allure.step("Нажать - SAVE");
        GeneralSaveButton.perform(click());
    }

    public void clickCancelButton() {
        Allure.step("Нажать - CANCEL");
        GeneralCancelButton.perform(click());
    }

    public void clickOkButton() {
        Allure.step("Нажать - ОК");
        oKButton.perform(click());
    }

    public void clickCancelInDialog() {
        Allure.step("Нажать - Cancel");
        cancelButton.perform(click());
    }

    public void checkEmptyMessage(int id, boolean visible) {
        if (visible) {
            emptyMessage(id).check(matches(isDisplayed()));
        } else {
            emptyMessage(id).check(matches(not(isDisplayed())));
        }
    }

    public void checkFillEmptyFieldsMessage() {
        Allure.step("Текст сообщения - empty");
        checkEmptyMessage(R.string.empty_fields, true);
    }

    public void checkEmptyToast(int id, boolean visible) {
        if (visible) {
            emptyToastMatcher(id).check(matches(isDisplayed()));
        } else {
            emptyToastMatcher(id).check(matches(not(isDisplayed())));
        }
    }

    public void checkCancelToast() {
        Allure.step("Проверка предупреджения");
        checkEmptyMessage(R.string.cancellation, true);
    }

    public void checkInvalidAuthDataToast() {
        Allure.step("Проверка предупреджения");
        checkEmptyToast(R.string.wrong_login_or_password, true);
    }

    public void checkEmptyAuthDataToast() {
        Allure.step("Проверка предупреджения");
        checkEmptyToast(R.string.empty_login_or_password, true);
    }

    public void checkErrorToast(int id, boolean visible) {
        if (visible) {
            errorToastMatcher(id).check(matches(isDisplayed()));
        } else {
            errorToastMatcher(id).check(matches(not(isDisplayed())));
        }
    }

    public void checkEmptyFieldError() {
        Allure.step("Текст ошибки - empty fields");
        checkErrorToast(R.string.empty_fields, true);
    }

    public void checkInvalidData(String text, boolean visible) {
        if (visible) {
            invalidData(text).check(matches(isDisplayed()));
        } else {
            invalidData(text).check(matches(not(isDisplayed())));
        }
    }

    public void checkNewsButterfly() {
        Allure.step("Картинка с бабочкой - News");
        butterflyNewsListImage.check(matches(isDisplayed()));
    }

    public void checkClaimButterfly() {
        Allure.step("Картинки с бабочкой - Claims");
        butterflyClaimsListImage.check(matches(isDisplayed()));
    }

    public void checkNothingToShow() {
        Allure.step("Элементы экрана - Nothing to show");
        nothingText.check(matches(isDisplayed()));
        refreshText.check(matches(isDisplayed()));
    }

    public void manualTimeInput(String hour, String minute) {
        Allure.step("Ввести время вручную");
        manualTimeButton.perform(click());
        hourInputText.perform(replaceText(hour));
        minuteInputText.perform(replaceText(minute));
        clickOkButton();
    }

    public void checkErrorInvalidTime() {
        Allure.step("Предупреждение о невалидном времени");
        elementWaiting(withText("Enter a valid time"), 5000);
        EnterValidTimeNext.check(matches(isDisplayed()));
    }
}