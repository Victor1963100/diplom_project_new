package ru.netology.qamid45.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static ru.netology.qamid45.data.Helper.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

import static ru.netology.qamid45.elements.CommentElement.*;
import static ru.netology.qamid45.elements.GeneralElements.*;

public class CommentStep {

    public void checkCommentScreenElements() {
        Allure.step("Элементы экрана - Comment");
        commentText.check(matches(isDisplayed()));
        commentName.check(matches(isDisplayed()));
        GeneralSaveButton.check(matches(isDisplayed()));
        cancelButton.check(matches(isDisplayed()));
    }

    public void addComment(String comment) {
        Allure.step("Добавить комментарий");
        commentText.perform(click()).perform(replaceText(comment));

    }
}