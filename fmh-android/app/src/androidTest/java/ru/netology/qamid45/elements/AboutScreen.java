package ru.netology.qamid45.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutScreen {
    public static ViewInteraction trademark = onView(withId(R.id.trademark_image_view));
    public static ViewInteraction versionTitle = onView(withId(R.id.about_version_title_text_view));
    public static ViewInteraction versionValue = onView(withId(R.id.about_version_value_text_view));
    public static ViewInteraction privacyPolicyLabel =
            onView(withId(R.id.about_privacy_policy_label_text_view));
    public static ViewInteraction privacyPolicyValue =
            onView(withId(R.id.about_privacy_policy_value_text_view));
    public static ViewInteraction termsOfUseLabel =
            onView(withId(R.id.about_terms_of_use_label_text_view));
    public static ViewInteraction termsOfUseValue =
            onView(withId(R.id.about_privacy_policy_value_text_view));
    public static ViewInteraction companyInfoLabel =
            onView(withId(R.id.about_company_info_label_text_view));
    public static ViewInteraction returnButton = onView(withId(R.id.about_back_image_button));
}