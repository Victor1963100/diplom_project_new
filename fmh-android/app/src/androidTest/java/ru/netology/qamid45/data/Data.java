package ru.netology.qamid45.data;

import static ru.netology.qamid45.data.Helper.getCurrentDate;
import static ru.netology.qamid45.data.Helper.getCurrentTime;

import io.bloco.faker.Faker;
public class Data {
    static Faker faker = new Faker();

    public static final String validLogin = "login2";
    public static final String  validPass = "password2";
    public static final String invalidLogin = faker.name.firstName() + faker.number.between(1, 10);
    public static final String invalidPass = faker.internet.password();
    public static final String emptyLogin = "";
    public static final String emptyPass = "";
    public static final String executor = "Петров Петр Петрович";

    public String quoteText = "Все сотрудники хосписа - это адвокаты пациента, его прав и потребностей. " +
            "Поиск путей решения различных задач - это и есть хосписный индивидуальный подход к паллиативной помощи.";

    public String dateOfPublic = getCurrentDate();
    public String timeOfPublic = getCurrentTime();
    public String dateNonNews = "01.01.2111";

    public String descriptOnCyr = "Описание новости";
    public String descriptSymb = "=+_)(*&^%$#@!~";
    public String titleCyr = "Новость";
    public String titleSymb = "=+_)(*&^%$#@!~";
    public String descriptionEmptyText = "";
    public String newTitleEdit = "Отредактированное название";
    public String newDescriptionEdit = "Отредактированное описание";
    public String newTitle = "Новое название";
    public String newDescription = "Новое описание";

    public String claimDateOfPublic = getCurrentDate();
    public String claimTimeOfPublic = getCurrentTime();

    public String claimDescriptLatin = "Description claim";
    public String claimDescriptCyr = "Заявка на ремонт";
    public String claimDescriptSymb = "=+_)(*&^%$#@!~";
    public String claimDescriptSpace = " ";
    public String claimTitleLatin = "Claim";
    public String claimTitle51 = "ABCDEFGHIJKLMNOQPRSTUVWXYZabcdefghijklmnoqprstuvwxyz";
    public String claimTitleCyr = "Заявка на установку";
    public String claimTitleSymbols = "=+_)(*&^%$#@!~";
    public String claimTitleSpace = " ";
    public String claimEditedTitle = "Новое название";
    public String claimEditedDescription = "Новое описание";
    public String titleClaim = "Новость на экране";
    public String dateClaim = "30.10.2023";
    public String timeClaim = "10:31";

    public String commentCyr = "Комментарий" + faker.number.between(1, 100);
    public String editComment = "После редактировования";
}