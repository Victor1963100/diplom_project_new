package ru.netology.qamid45.tests;

import androidx.test.espresso.PerformException;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.qamid45.data.Helper;
import ru.netology.qamid45.steps.AboutStep;
import ru.netology.qamid45.steps.AuthorizationStep;
import ru.netology.qamid45.steps.ClaimsStep;
import ru.netology.qamid45.steps.GeneralStep;
import ru.netology.qamid45.steps.CreateClaimStep;
import ru.netology.qamid45.steps.MainStep;
import ru.netology.qamid45.steps.NewsStep;
import ru.netology.qamid45.steps.QuotesStep;
import ru.netology.qamid45.steps.SplashStep;

@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки Главная мобильного приложения Мобильный хоспис")
public class MainTest {
    AuthorizationStep authStep = new AuthorizationStep();
    MainStep mainStep = new MainStep();
    ClaimsStep claimsStep = new ClaimsStep();
    NewsStep newsStep = new NewsStep();
    AboutStep aboutStep = new AboutStep();
    QuotesStep missionStep = new QuotesStep();
    CreateClaimStep createClaim = new CreateClaimStep();
    GeneralStep generalStep = new GeneralStep();
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
        }
    }

    @Test
    @DisplayName("# 19. Корректное отображение списка вкладок меню")
    @Description("В выпадающем списке есть разделы Main, Claims, News, About")
    public void testCheckMenuScreenList() {
        mainStep.clickMenuButton();
        mainStep.checkMenuList();
    }

    @Test
    @DisplayName("# 20. Навигация по меню - переход в раздел \"Claims\", \"Main\",  \"News\", " +
            "\"About\"")
    @Description("Переход на соответствующую вкладку из меню приложения")
    public void testCheckTransitionFromMenu() {
        mainStep.goToClaims();
        claimsStep.checkClaimsScreenElements();
        mainStep.goToNews();
        newsStep.checkNewsElements();
        mainStep.goToAbout();
        aboutStep.checkScreenElementsAbout();
//        mainStep.goToMain();
//        mainStep.checkMainElements();
    }

    @Test
    @DisplayName("# 21. Переход на вкладку Love is all")
    @Description("Переход на вкладку Love is all из главного экрана приложения. На экране список цитат. " +
            "Наличие title \"Love is all\"")
    public void testCheckTransitionToMissionScreen() {
        mainStep.clickMissionButton();
        missionStep.checkMissionElements();
    }

    @Test
    @DisplayName("# 22. Корректность отображения всех элементов на главной странице")
    @Description("Присутствуют элементы: на верхней панели кнопка меню (три полоски), " +
            "кнопка в виде бабочки, кнопка в виде человечка, блок News, ссылка на All News, блок Claims, " +
            "ссылка на All Claims, кнопка создания новой заявки")
    public void testCheckMainScreenElements() {
        mainStep.checkMainElements();
    }


    @Test
    @DisplayName("# 23. Развернуть и свернуть блок News")
    @Description("Блок новостей при нажатии сворачиваются, при повтороноа нажатии - разворачивается")
    public void testExpandAndCollapseNewsBlock() {
        mainStep.checkAllNews();
        mainStep.allNewsNotDisplay();
        mainStep.checkAllNews();
        mainStep.allNewsDisplay();
    }

    @Test
    @DisplayName("# 24. Переход на вкладку News с помощью All News и возврат на главный экран")
    @Description("На главном экране нажав кнопку All News совершается переход на вкладку News")
    public void testCheckAllNewsButton() {
        mainStep.clickAllNews();
        newsStep.checkNewsElements();
        mainStep.goToMain();
        mainStep.checkMainElements();
    }


    @Test
    @DisplayName("# 25. Развернуть и свернуть блок Claims")
    @Description("Блок претензий при нажатии сворачиваются, при повтороноа нажатии - разворачивается")
    public void testExpandAndCollapseClaimsBlock() {
        mainStep.checkAllClaims();
        mainStep.allClaimsNotDisplay();
        mainStep.checkAllClaims();
        mainStep.allClaimsDisplay();
    }


    @Test
    @DisplayName("# 26. Переход на вкладку Claims с помощью All Claims и возврат на главный экран")
    @Description("На главном экране нажав кнопку All Claims совершается переход на вкладку Claims")
    public void testCheckAllClaimsButton() {
        mainStep.clickAllClaims();
        claimsStep.checkClaimsScreenElements();
        mainStep.goToMain();
        mainStep.checkMainElements();
    }

    @Test
    @DisplayName("# 29. Начать создавать заявку и вернуться обратно на главный экран")
    @Description("Нажать + , переход на экран создания претензии. " +
            "Нажать Cancel, затем ОК возвращается обратно на главный экран")
    public void testCheckNewClaimButton() {
        mainStep.clickNewClaimButton();
        createClaim.checkCreateClaimElements();
        generalStep.clickCancelButton();
        generalStep.clickOkButton();
        mainStep.checkMainElements();
    }
}