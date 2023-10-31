package ru.netology.qamid45.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

import io.qameta.allure.kotlin.Allure;

import ru.iteco.fmhandroid.R;
import static ru.netology.qamid45.elements.QuotesScreen.*;

public class QuotesStep {
    public void checkMissionElements() {
        Allure.step("Элементы экрана - Our mission");
        missionName.check(matches(isDisplayed()));
        missionList.check(matches(isDisplayed()));
    }

    public void checkQuote(int number) {
        Allure.step("Развернуть/свернуть цитату");
        missionConstraintLayout.check(matches(isDisplayed()));
        missionConstraintLayout.perform(actionOnItemAtPosition(number, click()));
    }

    public void descriptionNotDisplay(String text) {
        Allure.step("Отображение цитаты");
        onView(allOf(withId(R.id.our_mission_item_description_text_view),
                withText(text))).check(matches(not(isDisplayed())));
    }

    public void descriptionIsDisplay(String text) {
        Allure.step("Cкрытие цитаты");
        onView(allOf(withId(R.id.our_mission_item_description_text_view),
                withText(text))).check(matches(isDisplayed()));
    }
}