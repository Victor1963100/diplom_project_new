package ru.netology.qamid45.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static ru.netology.qamid45.data.Helper.elementWaiting;
import static ru.netology.qamid45.data.Helper.nestedScrollTo;
import static ru.netology.qamid45.elements.ClaimsScreen.*;
import static ru.netology.qamid45.elements.FilterClaimsElement.*;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.netology.qamid45.data.Helper;

public class ClaimsStep {
    public void checkClaimsScreenElements() {
        Allure.step("Элементы экрана - Claims");
        claimName.check(matches(isDisplayed()));
        claimList.check(matches(isDisplayed()));
    }

    public void checkClaimElements() {
        Allure.step("Элементы претензии");
        titleLabelText.check(matches(isDisplayed()));
        titleText.check(matches(isDisplayed()));
        executorLabelText.check(matches(isDisplayed()));
        executorNameText.check(matches(isDisplayed()));
        dateLabelText.check(matches(isDisplayed()));
        claimDateText.check(matches(isDisplayed()));
        claimTimeText.check(matches(isDisplayed()));
        description.check(matches(isDisplayed()));
        descriptionText.check(matches(isDisplayed()));
        authorLabelText.check(matches(isDisplayed()));
        authorNameText.check(matches(isDisplayed()));
        createLabelText.check(matches(isDisplayed()));
        createDateText.check(matches(isDisplayed()));
        createTimeText.check(matches(isDisplayed()));
    }
    public void openFilter() {
        Allure.step("Открыть окно фильтра");
        claimFilterButton.perform(click());
    }

    public void checkFilterElements() {
        Allure.step("Элеменмты окна - Filter");
        filterName.check(matches(isDisplayed()));
        filterOpen.check(matches(isDisplayed()));
        filterInProgress.check(matches(isDisplayed()));
        filterExecuted.check(matches(isDisplayed()));
        filterCancelled.check(matches(isDisplayed()));
    }

    public void expandClaim(int index) {
        Allure.step("Развернуть претензию");
        claimListCard(index).perform(click());
        elementWaiting(withId(R.id.status_icon_image_view), 10000);

    }

    public void checkInProgress() {
        Allure.step("Кликнуть - In progress");
        filterInProgress.perform(click());
    }

    public void checkOpen() {
        Allure.step("Кликнуть - Open");
        filterOpen.perform(click());
    }

    public void checkExecuted() {
        Allure.step("Кликнуть - Executed");
        filterExecuted.perform(click());
    }

    public void checkCancelled() {
        Allure.step("Кликнуть - Cancelled");
        filterCancelled.perform(click());
    }

    public void clickEditClaimButton() {
        Allure.step("Нажать - редактировать претензию");
        editProcessButton.perform(nestedScrollTo());
        editProcessButton.perform(click());
    }

    public void clickAddCommentButton() {
        Allure.step("Добавление комментария");
        addCommentButton.perform(nestedScrollTo());
        addCommentButton.perform(click());
    }

    public void clickEditStatusButton() {
        Allure.step("Нажать - изменение статуса");
        statusProcessButton.perform(nestedScrollTo());
        statusProcessButton.check(matches(isDisplayed()));
        statusProcessButton.perform(click());
    }

    public void clickTakeToWork() {
        Allure.step("Нажать - Take to work");
        takeToWorkText.check(matches(isDisplayed()));
        takeToWorkText.perform(click());
    }

    public void clickCancelClaim() {
        Allure.step("Нажать - Cancel");
        cancelText.check(matches(isDisplayed()));
        cancelText.perform(click());
    }

    public void goBackToPreviousScreen() {
        Allure.step("Вернуться на предыдущий экран");
        returnButton.perform(nestedScrollTo());
        returnButton.perform(click());
    }

    public void clickCommentEditButton(int index) {
        Allure.step("Нажать - редактирование комментария");
        editCommentButton(index).check(matches(isDisplayed()));
        editCommentButton(index).perform(click());
    }

    public void checkComment(String text) {
        Allure.step("Отображение комментария");
        addComment(text).check(matches(isDisplayed()));
    }

    public String getClaimComment(int index) {
        Allure.step("Получить текст комментария");
        return Helper.Text.getText(commentDescText(index));
    }

    public void statusIsDisplayed() {
        Allure.step("Видимость статуса - Претензии");
        statusIconImage.check(matches(isDisplayed()));
    }

    public void checkClaimStatus(String status) {
        Allure.step("Статус претензии");
        String claimStatus = Helper.Text.getText(onView(withId(R.id.status_label_text_view)));
        assertEquals(status, claimStatus);
    }

    public void clickNewClaimButton() {
        Allure.step("Нажать - добавить претензию");
        addClaimButton.perform(click());
    }

    public String getClaimTitle() {
        Allure.step("Tекст заголовка претензии");
        return Helper.Text.getText(onView(withId(R.id.title_text_view)));
    }

    public String getClaimDescription() {
        Allure.step("Tекст описания претензии");
        return Helper.Text.getText(onView(withId(R.id.description_text_view)));
    }

    public String getClaimTime() {
        Allure.step("Время претензии");
        return Helper.Text.getText(onView(withId(R.id.plan_time_text_view)));
    }

    public String getClaimDate() {
        Allure.step("Дата претензии");
        return Helper.Text.getText(onView(withId(R.id.plane_date_text_view)));
    }

    public void checkCreateClaimElement(String title, String description, String date, String time) {
        assertEquals(title, getClaimTitle());
        assertEquals(description, getClaimDescription());
        assertEquals(date, getClaimDate());
        assertEquals(time, getClaimTime());
    }

    public void allClaimElementsLoad() {
        Allure.step("Все элементы претензии");
        elementWaiting(withId(R.id.status_processing_image_button), 5000);
    }

    public void claimsListLoad() {
        Allure.step("Список претензий");
        elementWaiting(withId(R.id.claim_list_recycler_view), 5000);
    }

    public void emptyScreen() {
        Allure.step("Пустой экран");
        elementWaiting(withId(R.id.empty_claim_list_image_view), 5000);
    }
}