package ru.netology.qamid45.tests;

import static ru.netology.qamid45.data.Helper.authInfo;

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
import ru.netology.qamid45.steps.AuthorizationStep;
import ru.netology.qamid45.steps.GeneralStep;
import ru.netology.qamid45.steps.MainStep;
import ru.netology.qamid45.steps.SplashStep;

@RunWith(AllureAndroidJUnit4.class)

@Epic("Проведение функционального тестирования вкладки Авторизация")
public class AuthorizationTest {

    AuthorizationStep authStep = new AuthorizationStep();
    MainStep mainStep = new MainStep();
    GeneralStep generalStep = new GeneralStep();
    SplashStep splashStep = new SplashStep();

    @Rule
    public androidx.test.rule.ActivityTestRule<AppActivity> ActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void logoutCheck() {
        splashStep.appDownload();
        try {
            authStep.loadAuthPage();
            authStep.checkAuthScreenElements();

        } catch (Exception e) {
            mainStep.clickLogOutButton();
            authStep.loadAuthPage();
        }
    }

    @Test
    @DisplayName("# 1. Наличие всех элементов формы авторизации (позитивный)")
    @Description("Элементы формы авторизации отображены корректно")
    public void testCheckAuthScreenElements() {
        authStep.checkAuthScreenElements();
    }

    @Test
    @DisplayName("# 2. Авторизация в приложении под валидными данными (позитивный)")
    @Description("После ввода валидного логина и пароля происходит переход на главный экран приложения")
    public void testLoginWithValidLoginAndPass() {
        authStep.authWithValidLoginAndPass(authInfo());
        authStep.clickSignInButton();
        mainStep.mainScreenLoad();
        mainStep.checkMainElements();
    }

    @Test
    @DisplayName("# 3. Выход из учетной записи (позитивный) ")
    @Description("Авторизованный пользователь выходит из приложения с помощью кнопки Log out")
    public void testLogOutApplication() {
        authStep.authWithValidLoginAndPass(authInfo());
        authStep.clickSignInButton();
        mainStep.mainScreenLoad();
        mainStep.checkMainElements();
        mainStep.clickLogOutButton();
        authStep.checkAuthScreenElements();
    }
     @Test
    @DisplayName("# 8. Авторизация в приложении, когда поле \"Пароль\" заполнено данными " +
            "незарегистрированного пользователя (негативный)")
    @Description("При вводе невалидных значений в поле Пароль всплывает сообщение о неверных данных" +
            "Wrong login or password")
    public void testLoginWithInvalidPass() {
        authStep.authWithInvalidPass(authInfo());
        authStep.clickSignInButton();
        generalStep.checkInvalidAuthDataToast();
    }

    @Test
    @DisplayName("# 9. Авторизация в приложении, когда поле \"Логин\" заполнено данными " +
            "незарегистрированного пользователя (негативный)")
    @Description("При вводе невалидных значений логина всплывает сообщение о неверных данных" +
            "Wrong login or password")
    public void testLoginWithInvalidLogin() {
        authStep.authWithInvalidLogin(authInfo());
        authStep.clickSignInButton();
        generalStep.checkInvalidAuthDataToast();
    }

    @Test
    @DisplayName("# 10. Авторизация в приложении, когда поле \"Логин\" пустое (негативный)")
    @Description("При авторизации с пустым логином пользователь не авторизуется. " +
            "Ошибка: Login and password cannot be empty")
    public void testLoginWithEmptyLogin() {
        authStep.authWithEmptyLogin(authInfo());
        authStep.clickSignInButton();
        generalStep.checkEmptyAuthDataToast();
    }

    @Test
    @DisplayName("# 11. Авторизация в приложении, когда поле \"Пароль\" пустое (негативный)")
    @Description("При авторизации с пустым паролем пользователь не авторизуется. " +
            "Ошибка: Login and password cannot be empty")
    public void testLoginWithEmptyPassword() {
        authStep.authWithEmptyPass(authInfo());
        authStep.clickSignInButton();
        generalStep.checkEmptyAuthDataToast();
    }

    @Test
    @DisplayName("# 12. Авторизация в приложении, когда поля \"Логин\" и \"Пароль\" пустые (негативный)")
    @Description("При авторизации с пустым логином и паролем пользователь не авторизуется. " +
            "Ошибка: Login and password cannot be empty")
    public void testLoginWithEmptyLoginAndPass() {
        authStep.clickSignInButton();
        generalStep.checkEmptyAuthDataToast();
    }
}