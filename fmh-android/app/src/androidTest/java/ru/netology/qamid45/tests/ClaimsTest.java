package ru.netology.qamid45.tests;

import static ru.netology.qamid45.data.Data.executor;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static org.junit.Assert.assertEquals;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.qamid45.data.Helper;
import ru.netology.qamid45.data.Data;
import ru.netology.qamid45.elements.ClaimsScreen;
import ru.netology.qamid45.elements.MainScreen;
import ru.netology.qamid45.steps.AuthorizationStep;
import ru.netology.qamid45.steps.ClaimsStep;
import ru.netology.qamid45.steps.CommentStep;
import ru.netology.qamid45.steps.GeneralStep;
import ru.netology.qamid45.steps.CreateClaimStep;
import ru.netology.qamid45.steps.EditClaimStep;
import ru.netology.qamid45.steps.MainStep;
import ru.netology.qamid45.steps.SplashStep;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тесты для проведения функционального тестирования вкладки Заявки")
public class ClaimsTest {

    AuthorizationStep authStep = new AuthorizationStep();
    ClaimsStep claimsStep = new ClaimsStep();
    MainScreen mainElement = new MainScreen();
    ClaimsScreen claimsElement = new ClaimsScreen();
    CreateClaimStep createClaimStep = new CreateClaimStep();
    MainStep mainStep = new MainStep();
    Data data = new Data();
    GeneralStep generalStep = new GeneralStep();
    CommentStep commentStep = new CommentStep();
    EditClaimStep editClaimsSteps = new EditClaimStep();
    SplashStep splashStep = new SplashStep();


    @Rule
    public androidx.test.rule.ActivityTestRule<AppActivity> ActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void logoutCheck() {
        splashStep.appDownload();
        try {
            mainStep.mainScreenLoad();
        } catch (Exception e) {
            authStep.authWithValidLoginAndPass(Helper.authInfo());
            authStep.clickSignInButton();
        } finally {
            mainStep.mainScreenLoad();
            mainStep.clickAllClaims();
        }
    }

    @Test
    @DisplayName("# 30. Отображение и полнота информации раскрытой претензии в блоке \"Claims  \"")
    @Description("Корректность отображения всех элементов Claims")
    public void testCheckClaimElements() {
        claimsStep.expandClaim(0);
        claimsStep.allClaimElementsLoad();
        claimsStep.checkClaimElements();
    }

    @Test
    @DisplayName("# 31. Открыть и закрыть претензию")
    @Description("При нажатии на претензию отображается ее содержание")
    public void testOpenAndCloseClaim() {
        claimsStep.expandClaim(0);
        claimsStep.allClaimElementsLoad();
        claimsStep.checkClaimElements();
        claimsStep.goBackToPreviousScreen();
        claimsStep.checkClaimsScreenElements();
    }

    @Test
    @DisplayName("# 32. Открытие окна с фильтром претензии")
    @Description("При нажатии на кнопку фильтра открывается окно с фильтром претензии")
    public void testOpenWindowWithClaimFilter() {
        claimsStep.openFilter();
        claimsStep.checkFilterElements();
    }

    @Test
    @DisplayName("# 33. Сортировка/фильтрация претензии по критерию \"Open\" во вкладке \"Claims\" " +
            "приложения (позитивный)")
    @Description("При фильтрации по статусу Open отображаются только претензии со статусом Open")
    public void testSortClaimsByOpen() {
        claimsStep.openFilter();
        claimsStep.checkInProgress();
        generalStep.clickOkButton();
        claimsStep.claimsListLoad();
        claimsStep.expandClaim(0);
        claimsStep.allClaimElementsLoad();
        claimsStep.checkClaimStatus("Open");
    }

    @Test
    @DisplayName("# 34. Отфильтровать претензии со статусом In Progress")
    @Description("При фильтрации по статусу In progress отображаются только претензии со статусом " +
            "In progress")
    public void testSortClaimsByInProgress() {
        claimsStep.openFilter();
        claimsStep.checkOpen();
        generalStep.clickOkButton();
        claimsStep.claimsListLoad();
        claimsStep.expandClaim(0);
        claimsStep.allClaimElementsLoad();
        claimsStep.checkClaimStatus("In progress");
    }

    @Test
    @DisplayName("# 35. Сортировка и фильтрация претензий по критерию \"Executed\" " +
            "во вкладке \"Claims\" приложения (позитивный)")
    @Description("При фильтрации по статусу Executed отображаются только претензии со статусом Executed")
    public void testSortClaimsByExecuted() {
        claimsStep.openFilter();
        claimsStep.checkOpen();
        claimsStep.checkInProgress();
        claimsStep.checkExecuted();
        generalStep.clickOkButton();
        claimsStep.claimsListLoad();
        claimsStep.expandClaim(0);
        claimsStep.allClaimElementsLoad();
        claimsStep.checkClaimStatus("Executed");
    }

    @Test
    @DisplayName("# 36. Сортировка и фильтрация претензий по критерию \"Cancelled \" " +
            "во вкладке \"Claims\" приложения (позитивный)")
    @Description("При фильтрации по статусу Cancelled отображаются только претензии со статусом Cancelled")
    public void testSortClaimsByCancelled() {
        claimsStep.openFilter();
        claimsStep.checkOpen();
        claimsStep.checkInProgress();
        claimsStep.checkCancelled();
        generalStep.clickOkButton();
        claimsStep.claimsListLoad();
        claimsStep.expandClaim(0);
        claimsStep.allClaimElementsLoad();
        claimsStep.checkClaimStatus("Canceled");
    }

    @Test
    @DisplayName("# 37. Не выбран ни один фильтр во вкладке \"Claims\" приложения (негативный)")
    @Description("Претензии без статуса не отображается, надпсиь There is nothing here yet")
    public void testNotCheckFiltersClaims() {
        claimsStep.openFilter();
        claimsStep.checkOpen();
        claimsStep.checkInProgress();
        generalStep.clickOkButton();
        claimsStep.emptyScreen();
        generalStep.checkClaimButterfly();
        generalStep.checkNothingToShow();
    }

    @Test
    @DisplayName("# 39. Создание претензии из главного экрана приложения через кнопку +")
    @Description("Тест падает, т.к. претензию не найти, на экране отображаются претензии с ранней датой, " +
            "например 1895 года. Но ведь новые претензии должны быть наверху!!!")
    public void testCreateClaimFromMainScreen() {
        mainStep.clickNewClaimButton();
        createClaimStep.checkCreateClaimElements();
        createClaimStep.fillInTitleField(data.titleClaim);
        createClaimStep.fillInExecutorField(executor);
        createClaimStep.fillInDateField(data.dateClaim);
        createClaimStep.fillInTimeField(data.timeClaim);
        createClaimStep.fillItDescriptionField(data.claimDescriptCyr);
        generalStep.clickSaveButton();
        mainStep.mainScreenLoad();
        mainElement.claimsText.perform(swipeUp());
        mainStep.claimOnMainload();
        mainStep.clickClaimOnMain(0);
        claimsStep.allClaimElementsLoad();
        assertEquals(data.titleClaim, claimsStep.getClaimTitle());
        assertEquals(data.claimDescriptCyr, claimsStep.getClaimDescription());
        assertEquals(data.dateClaim, claimsStep.getClaimDate());
        assertEquals(data.timeClaim, claimsStep.getClaimTime());
    }

    @Test
    @DisplayName("# 40. Создание претензии из раздела \"Claims\" меню приложения на кириллице")
    @Description("Тест падает! Создается претензия на кириллице")
    public void testCreateNewClaimCyrillic() {
        claimsStep.clickNewClaimButton();
        createClaimStep.checkCreateClaimScreenLoad();
        createClaimStep.checkCreateClaimElements();
        createClaimStep.fillInTitleField(data.claimTitleCyr);
        createClaimStep.fillInExecutorField(executor);
        createClaimStep.fillInDateField(data.dateClaim);
        createClaimStep.fillInTimeField(data.timeClaim);
        createClaimStep.fillItDescriptionField(data.claimDescriptCyr);
        generalStep.clickSaveButton();
        claimsStep.claimsListLoad();
        claimsElement.claimList.perform(swipeDown());
        claimsStep.checkClaimsScreenElements();
        claimsStep.expandClaim(0);
        claimsStep.allClaimElementsLoad();
        claimsStep.checkCreateClaimElement(data.claimTitleCyr, data.claimDescriptCyr, data.dateClaim, data.timeClaim);

    }

    @Test
    @DisplayName("# 42. Создание претензии с пустыми полями  (негативный)")
    @Description("Не заполняется, всплывает предупреждение о необходимости заполнить пустые поля")
    public void testCreateClaimEmptyFields() {
        claimsStep.clickNewClaimButton();
        createClaimStep.checkCreateClaimScreenLoad();
        createClaimStep.checkCreateClaimElements();
        generalStep.clickSaveButton();
        generalStep.checkFillEmptyFieldsMessage();
    }

    @Test
    @DisplayName("# 43. Создание претензии с полем, которое состоит из 51 символа")
    @Description("Сохраняются только 50 символов. Чтобы тест проходил надо поставить самую раннюю дату" +
            "которая есть у претензий в приложении")
    public void testCheckTitleClaimLength() {
        claimsStep.clickNewClaimButton();
        createClaimStep.checkCreateClaimScreenLoad();;
        createClaimStep.fillInTitleField(data.claimTitle51);
        createClaimStep.fillInDateField(data.dateClaim);
        createClaimStep.fillInTimeField(data.timeClaim);
        createClaimStep.fillItDescriptionField(data.claimDescriptLatin);
        generalStep.clickSaveButton();
        claimsStep.claimsListLoad();
        claimsElement.claimList.perform(swipeDown());
        claimsStep.expandClaim(0);
        claimsStep.allClaimElementsLoad();
        claimsStep.getClaimTitle();
        assertEquals("а2а4а6а8а!а2а4а6а8а!а2а4а6а8а!а2а4а6а8а!а2а4а6а8а!", claimsStep.getClaimTitle());
    }

    @Test
    @DisplayName("# 44. Создание претензии пробелами в названии и описании (негативный)")
    @Description("Претензия не создается, предупреждение о необходимости заполнить пустые поля")
    public void testCreateClaimWithSpaces() {
        claimsStep.clickNewClaimButton();
        createClaimStep.checkCreateClaimScreenLoad();
        createClaimStep.checkCreateClaimElements();
        createClaimStep.fillInTitleField(data.claimTitleSpace);
        createClaimStep.fillInExecutorField(executor);
        createClaimStep.fillInDateField(data.claimDateOfPublic);
        createClaimStep.fillInTimeField(data.claimTimeOfPublic);
        createClaimStep.fillItDescriptionField(data.claimDescriptSpace);
        generalStep.clickSaveButton();
        generalStep.checkFillEmptyFieldsMessage();
    }

    @Test
    @DisplayName("# 45. Создание претензии со спецсимволами в полях названии и описании (негативный)")
    @Description("Тест падает. Форма дает возможность ввода спецсимволов в поля")
    public void testCreateClaimsWithSymbols() {
        claimsStep.clickNewClaimButton();
        createClaimStep.checkCreateClaimScreenLoad();
        createClaimStep.checkCreateClaimElements();
        createClaimStep.fillInTitleField(data.claimTitleSymbols);
        createClaimStep.fillInExecutorField(executor);
        createClaimStep.fillInDateField(data.claimDateOfPublic);
        createClaimStep.fillInTimeField(data.claimTimeOfPublic);
        createClaimStep.fillItDescriptionField(data.claimDescriptSymb);
        generalStep.clickSaveButton();
        generalStep.checkInvalidData("Wrong format data", true);
    }

    @Test
    @DisplayName("# 46. Создание претензии с ручным вводом валидного времени в поле (Позитивный)")
    @Description("При ручном вводе в поле время валидного времени заявка создается")
    public void testClaimWithManualTimeInput() {
        String date = "19.11.1942";
        claimsStep.clickNewClaimButton();
        createClaimStep.checkCreateClaimScreenLoad();
        createClaimStep.checkCreateClaimElements();
        createClaimStep.fillInTitleField(data.claimTitleLatin);
        createClaimStep.fillInExecutorField(executor);
        createClaimStep.fillInDateField(date);
        createClaimStep.fillItDescriptionField(data.claimDescriptLatin);
        createClaimStep.fillItTimeField();
        generalStep.manualTimeInput("22", "44");
        generalStep.clickSaveButton();
        claimsStep.claimsListLoad();
        claimsStep.expandClaim(0);
        claimsStep.checkCreateClaimElement(data.claimTitleLatin, data.claimDescriptLatin, date, "22:44");
    }

    @Test
    @DisplayName("# 47. Ручной ввод невалидного часа")
    @Description("Предупреждение о невалидном времени")
    public void testCheckErrorInvalidHour() {
        claimsStep.clickNewClaimButton();
        createClaimStep.checkCreateClaimScreenLoad();
        createClaimStep.checkCreateClaimElements();
        createClaimStep.fillInTitleField(data.claimTitleLatin);
        createClaimStep.fillInExecutorField(executor);
        createClaimStep.fillInDateField(data.claimDateOfPublic);
        createClaimStep.fillItDescriptionField(data.claimDescriptLatin);
        createClaimStep.fillItTimeField();
        generalStep.manualTimeInput("25", "00");
        generalStep.checkErrorInvalidTime();
    }

    @Test
    @DisplayName("# 48. Ручной ввод невалидных минут")
    @Description("Предупреждение о невалидном времени")
    public void testCheckErrorInvalidMinutes() {
        claimsStep.clickNewClaimButton();
        createClaimStep.checkCreateClaimScreenLoad();
        createClaimStep.checkCreateClaimElements();
        createClaimStep.fillInTitleField(data.claimTitleLatin);
        createClaimStep.fillInExecutorField(executor);
        createClaimStep.fillInDateField(data.claimDateOfPublic);
        createClaimStep.fillItDescriptionField(data.claimDescriptLatin);
        createClaimStep.fillItTimeField();
        generalStep.manualTimeInput("23", "61");
        generalStep.checkErrorInvalidTime();
    }

    @Test
    @DisplayName("№ 50. Создать претензию с пустой датой и временем")
    @Description("Предупреждение о необходимости заполнить пустые поля")
    public void testCreateClaimWithEmptyDateAndTime() {
        claimsStep.clickNewClaimButton();
        createClaimStep.checkCreateClaimScreenLoad();
        createClaimStep.checkCreateClaimElements();
        createClaimStep.fillInTitleField(data.claimTitleLatin);
        createClaimStep.fillItDescriptionField(data.claimDescriptLatin);
        generalStep.clickSaveButton();
        generalStep.checkFillEmptyFieldsMessage();
    }

    @Test
    @DisplayName("# 51. Добавить комментарий на кириллице  к претензии (позитивный)")
    @Description("Комментарий сохраняется")
    public void testAddCommentInCyrillic() {
        claimsStep.clickNewClaimButton();
        createClaimStep.checkCreateClaimScreenLoad();
        createClaimStep.checkCreateClaimElements();
        createClaimStep.fillInTitleField(data.claimTitleCyr);
        createClaimStep.fillInExecutorField(executor);
        createClaimStep.fillInDateField(data.dateClaim);
        createClaimStep.fillInTimeField(data.timeClaim);
        createClaimStep.fillItDescriptionField(data.claimDescriptCyr);
        generalStep.clickSaveButton();
        claimsStep.claimsListLoad();
        claimsStep.expandClaim(0);
        claimsStep.allClaimElementsLoad();
        claimsStep.clickAddCommentButton();
        commentStep.checkCommentScreenElements();
        commentStep.addComment(data.commentCyr);
        generalStep.clickSaveButton();
        claimsStep.allClaimElementsLoad();
        claimsElement.statusIconImage.perform(swipeUp()).perform(swipeUp()).perform(swipeUp());
        claimsStep.checkComment(data.commentCyr);
    }

    @Test
    @DisplayName("# 52. Редактирование комментария во вкладке \"Claims\" (позитивный)")
    @Description("Измененный комменатрий отображается")
    public void testEditCommentClaim() {
        claimsStep.clickNewClaimButton();
        createClaimStep.checkCreateClaimScreenLoad();
        createClaimStep.checkCreateClaimElements();
        createClaimStep.fillInTitleField(data.claimTitleCyr);
        createClaimStep.fillInExecutorField(executor);
        createClaimStep.fillInDateField(data.dateClaim);
        createClaimStep.fillInTimeField(data.timeClaim);
        createClaimStep.fillItDescriptionField(data.claimDescriptCyr);
        generalStep.clickSaveButton();
        claimsStep.claimsListLoad();
        claimsStep.expandClaim(0);
        claimsStep.allClaimElementsLoad();
        claimsStep.clickAddCommentButton();
        commentStep.checkCommentScreenElements();
        commentStep.addComment(data.commentCyr);
        generalStep.clickSaveButton();
        claimsStep.clickCommentEditButton(0);
        commentStep.addComment(data.editComment);
        generalStep.clickSaveButton();
        claimsStep.allClaimElementsLoad();
        claimsStep.checkComment(data.editComment);
    }

    @Test
    @DisplayName("# 53. Отменить комментирование к претензии (позитивный)")
    @Description("Комментарий не сохраняется")
    public void testCancelCommentingClaim() {
        claimsStep.clickNewClaimButton();
        createClaimStep.checkCreateClaimScreenLoad();
        createClaimStep.checkCreateClaimElements();
        createClaimStep.fillInTitleField(data.claimTitleCyr);
        createClaimStep.fillInExecutorField(executor);
        createClaimStep.fillInDateField(data.dateClaim);
        createClaimStep.fillInTimeField(data.timeClaim);
        createClaimStep.fillItDescriptionField(data.claimDescriptCyr);
        generalStep.clickSaveButton();
        claimsStep.claimsListLoad();
        claimsStep.expandClaim(0);
        claimsStep.clickAddCommentButton();
        commentStep.checkCommentScreenElements();
        commentStep.addComment(data.commentCyr);
        generalStep.clickSaveButton();
        claimsStep.allClaimElementsLoad();
        String initialCommentContent = claimsStep.getClaimComment(0);
        claimsStep.clickCommentEditButton(0);
        commentStep.addComment(data.editComment);
        generalStep.clickCancelButton();
        claimsStep.allClaimElementsLoad();
        String commentAfterCancelledEditing = claimsStep.getClaimComment(0);
        assertEquals(initialCommentContent, commentAfterCancelledEditing);
    }

    @Test
    @DisplayName("# 54. Отменить создание комментария к претензии (позитивный)")
    @Description("Комментарий не добавляется")
    public void testCancelCommentAdd() {
        claimsStep.clickNewClaimButton();
        createClaimStep.checkCreateClaimScreenLoad();
        createClaimStep.checkCreateClaimElements();
        createClaimStep.fillInTitleField(data.claimTitleLatin);
        createClaimStep.fillInExecutorField(executor);
        createClaimStep.fillInDateField(data.dateClaim);
        createClaimStep.fillInTimeField(data.timeClaim);
        createClaimStep.fillItDescriptionField(data.claimDescriptLatin);
        generalStep.clickSaveButton();
        claimsStep.claimsListLoad();
        claimsStep.expandClaim(0);
        claimsStep.allClaimElementsLoad();
        claimsStep.clickAddCommentButton();
        commentStep.checkCommentScreenElements();
        generalStep.clickCancelButton();
        claimsStep.allClaimElementsLoad();
        claimsStep.statusIsDisplayed();
    }

    @Test
    @DisplayName("# 55. Изменить статус претензии с Open на Cancelled")
    @Description("Кнопка - Take to work, статус - на In progress, нажать на cancel статус - Canceled")
    public void testChangeStatusToCanceled() {
        claimsStep.clickNewClaimButton();
        createClaimStep.checkCreateClaimScreenLoad();
        createClaimStep.checkCreateClaimElements();
        createClaimStep.fillInTitleField(data.claimTitleCyr);
        createClaimStep.fillInExecutorField(executor);
        createClaimStep.fillInDateField(data.dateClaim);
        createClaimStep.fillInTimeField(data.timeClaim);
        createClaimStep.fillItDescriptionField(data.claimDescriptCyr);
        generalStep.clickSaveButton();
        claimsStep.claimsListLoad();
        claimsStep.checkClaimsScreenElements();
        claimsStep.openFilter();
        claimsStep.checkInProgress();
        generalStep.clickOkButton();
        claimsStep.expandClaim(0);
        claimsStep.allClaimElementsLoad();
        claimsStep.checkClaimStatus("Open");
        claimsStep.clickEditStatusButton();
        claimsStep.clickCancelClaim();
        claimsStep.checkClaimStatus("Canceled");
    }

    @Test
    @DisplayName("# 56. Редактировать претензию")
    @Description("Претензия отображается с новыми данными")
    public void testEditClaim() {
        claimsStep.openFilter();
        claimsStep.checkInProgress();
        generalStep.clickOkButton();
        claimsStep.claimsListLoad();
        claimsStep.expandClaim(0);
        claimsStep.allClaimElementsLoad();
        claimsStep.clickEditClaimButton();
        editClaimsSteps.changeClaimTitle(data.claimEditedTitle);
        editClaimsSteps.changeClaimDescription(data.claimEditedDescription);
        generalStep.clickSaveButton();
        assertEquals(data.claimEditedTitle, claimsStep.getClaimTitle());
        assertEquals(data.claimEditedDescription, claimsStep.getClaimDescription());
    }

    @Test
    @DisplayName("# 57. Отменить редактирование претензии в статусе Open")
    @Description("При отмене редактирования без подтверждения редактирование можно продолжить," +
            " при подтверждении отмены - претензия не редактируется")
    public void testCancelClaimEdit() {
        claimsStep.openFilter();
        claimsStep.checkInProgress();
        generalStep.clickOkButton();
        claimsStep.claimsListLoad();
        claimsStep.expandClaim(0);
        claimsStep.allClaimElementsLoad();
        claimsStep.clickEditClaimButton();
        generalStep.clickCancelButton();
        generalStep.checkCancelToast();
        generalStep.clickCancelInDialog();
        editClaimsSteps.checkEditClaimElements();
        generalStep.clickCancelButton();
        generalStep.checkCancelToast();
        generalStep.clickOkButton();
        claimsStep.statusIsDisplayed();
    }
}