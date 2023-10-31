package ru.netology.qamid45.tests;

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
import ru.netology.qamid45.data.Data;
import ru.netology.qamid45.data.Helper;
import ru.netology.qamid45.steps.AuthorizationStep;
import ru.netology.qamid45.steps.MainStep;
import ru.netology.qamid45.steps.QuotesStep;
import ru.netology.qamid45.steps.SplashStep;

@RunWith(AllureAndroidJUnit4.class)

@Epic("Тесты для проведения функционального тестирования вкладки Тематические цитаты")
public class QuotesTest {

    AuthorizationStep authStep = new AuthorizationStep();
    QuotesStep missionStep = new QuotesStep();
    MainStep mainStep = new MainStep();
    SplashStep splashStep = new SplashStep();
    Data data = new Data();

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
            mainStep.clickMissionButton();
        }
    }

    @Test
    @DisplayName("# 76. Проверка корректности отображения элементов экрана во вкладке \"Love is all\" приложения (позитивный)")
    @Description("Корректность отображения всех элементов экрана с цитатами")
    public void testCheckMissionScreenElements() {
        missionStep.checkMissionElements();
    }

    @Test
    @DisplayName("# 77. Развернуть и свернуть цитату, во вкладке \"Love is all\" приложения (позитивный)")
    @Description("При нажатии - разворачивается содержимое цитаты")
    public void testExpandAndCollapseQuote() {
        missionStep.checkQuote(2);
        missionStep.descriptionIsDisplay(data.quoteText);
        missionStep.checkQuote(2);
        missionStep.descriptionNotDisplay(data.quoteText);
    }
}