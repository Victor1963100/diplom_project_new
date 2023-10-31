package ru.netology.qamid45.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import static ru.netology.qamid45.elements.CreateNewsElement.*;

public class CreateNewsStep {
    public void checkNewsScreenElements() {
        Allure.step("Элементы экрана - Creating News");
        creatingName.check(matches(isDisplayed()));
        categoryName.check(matches(isDisplayed()));
        categoryText.check(matches(isDisplayed()));
        titleText.check(matches(isDisplayed()));
        titleName.check(matches(isDisplayed()));
        publishDateText.check(matches(isDisplayed()));
        publicationDateName.check(matches(isDisplayed()));
        timeText.check(matches(isDisplayed()));
        titleName.check(matches(isDisplayed()));
        descriptionText.check(matches(isDisplayed()));
        descriptionName.check(matches(isDisplayed()));
    }

    public void fillInNewsCategoryField(String text) {
        Allure.step("Поле категория - ввод данных");
        categoryText.perform(replaceText(text));
    }

    public void fillInNewsTitleField(String text) {
        Allure.step("Поле заголовок - ввод данных");
        titleText.perform(replaceText(text));
    }

    public void fillInPublicDateField(String text) {
        Allure.step("Поле дата публикации - ввод данных");
        publishDateText.perform(replaceText(text));
    }

    public void fillInTimeField(String text) {
        Allure.step("Поле время - ввод данных");
        timeText.perform(replaceText(text));
    }

    public void fillInNewsDescriptionField(String text) {
        Allure.step("Поле описание - ввод данных");
        descriptionText.perform(replaceText(text));
    }

    public void createNews(String category, String title, String publicationDate,
                           String publicationTime, String description) {
        Allure.step("Создать новость");
        fillInNewsCategoryField(category);
        fillInNewsTitleField(title);
        fillInPublicDateField(publicationDate);
        fillInTimeField(publicationTime);
        fillInNewsDescriptionField(description);
    }

    public void clickTimeField() {
        Allure.step("Нажать - поле время");
        timeText.perform(click());
    }
}