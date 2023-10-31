package ru.netology.qamid45.tests;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.qamid45.data.Helper;
import ru.netology.qamid45.steps.AboutStep;
import ru.netology.qamid45.steps.AuthorizationStep;
import ru.netology.qamid45.steps.MainStep;
import ru.netology.qamid45.steps.SplashStep;

@RunWith(AllureAndroidJUnit4.class)
public class AboutTest {

    AuthorizationStep authoStep = new AuthorizationStep();
    AboutStep aboutStep = new AboutStep();
    MainStep mainStep = new MainStep();
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
            authoStep.authWithValidLoginAndPass(Helper.authInfo());
            authoStep.clickSignInButton();
        } finally {
            mainStep.mainScreenLoad();
            mainStep.goToAbout();
        }
    }

    @Test
    @DisplayName("# 78. Корректность отображения всех элементов экрана About")
    @Description("Корректность отображения всех элементов экрана About")
    public void testCheckScreenElementsAbout() {
        aboutStep.checkScreenElementsAbout();
    }

    @Test
    @DisplayName("# 79. Работа ссылки \"Политика конфиденциальности\" во вкладке \"О приложении\" (позитивный)")
    public void testCheckingClickabilityLinks() {
        aboutStep.clickLinkPrivacyPolicy();
        aboutStep.clickLinkTermsofUse();
    }

    @Test
    @DisplayName("# 80. Работа ссылки \"Пользовательское соглашение\" во вкладке \"О приложении\" (позитивный)")
    public void testclickLinkTermsofUse() {
        aboutStep.clickLinkTermsofUse();
        aboutStep.clickLinkTermsofUse();
    }

    @Test
    @DisplayName("# 81. Возврат на главный экран приложения со страницы About")
    public void testCheckGoBackMainScreen() {
        aboutStep.checkScreenElementsAbout();
        aboutStep.checkReturnButton();
        mainStep.mainScreenLoad();
        mainStep.checkMainElements();
    }
}