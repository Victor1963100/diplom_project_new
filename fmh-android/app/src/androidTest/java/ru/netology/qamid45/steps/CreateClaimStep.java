package ru.netology.qamid45.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static ru.netology.qamid45.data.Helper.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import static ru.netology.qamid45.elements.GeneralElements.*;
import static ru.netology.qamid45.elements.CreateClaimsElement.*;

public class CreateClaimStep {
    public void checkCreateClaimScreenLoad() {
        Allure.step("Cтраница создания претензии  checkCreateClaimScreenElements");
        elementWaiting(withId(R.id.title_edit_text), 5000);
    }

    public void timeFieldLoaded() {
        Allure.step("Загрузка поля ввода данных");
        elementWaiting(withId(R.id.time_in_plan_text_input_edit_text), 5000);
    }

    public void checkCreateClaimElements() {
        Allure.step("Элементы экрана - Creating Claims");
        creatingName.check(matches(isDisplayed()));
        titleText.check(matches(isDisplayed()));
        executorText.check(matches(isDisplayed()));
        dateInPlanText.check(matches(isDisplayed()));
        timeInPlanText.check(matches(isDisplayed()));
        descriptionText.check(matches(isDisplayed()));
        GeneralSaveButton.check(matches(isDisplayed()));
    }

    public void fillInTitleField(String title) {
        Allure.step("Поле заголовок - ввод данных");
        titleText.perform(replaceText(title));
    }

    public void fillInExecutorField(String executor) {
        Allure.step("Поле исполнитель - ввод данных");
        executorText.perform(replaceText(executor));
    }

    public void fillInDateField(String date) {
        Allure.step("Поле дата - ввод данных");
        dateInPlanText.perform(replaceText(date));
    }

    public void fillInTimeField(String time) {
        Allure.step("Поле время - ввод данных");
        timeInPlanText.perform(replaceText(time));
    }

    public void fillItDescriptionField(String description) {
        Allure.step("Поле описание - ввод данных");
        descriptionText.perform(replaceText(description));
    }

    public void fillItTimeField() {
        Allure.step("Поле время - ввод данных");
        timeInPlanText.perform(click());
    }
}