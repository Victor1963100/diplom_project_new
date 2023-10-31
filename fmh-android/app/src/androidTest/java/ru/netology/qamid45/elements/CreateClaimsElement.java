package ru.netology.qamid45.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class CreateClaimsElement {
    public static ViewInteraction creatingName =
            onView(allOf(withId(R.id.custom_app_bar_title_text_view), withText("Creating")));
    public static ViewInteraction titleText = onView(withId(R.id.title_edit_text));
    public static ViewInteraction executorText =
            onView(withId(R.id.executor_drop_menu_auto_complete_text_view));
    public static ViewInteraction timeInPlanText =
            onView(withId(R.id.time_in_plan_text_input_edit_text));
    public static ViewInteraction descriptionText = onView(withId(R.id.description_edit_text));
    public static ViewInteraction dateInPlanText =
            onView(withId(R.id.date_in_plan_text_input_edit_text));

}