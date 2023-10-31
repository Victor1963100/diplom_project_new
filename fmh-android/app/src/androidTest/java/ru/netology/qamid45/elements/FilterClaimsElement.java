package ru.netology.qamid45.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class FilterClaimsElement {
    public static ViewInteraction filterName = onView(withId(R.id.claim_filter_dialog_title));
    public static ViewInteraction filterOpen =
            onView(allOf(withId(R.id.item_filter_open), withText("Open")));
    public static ViewInteraction filterInProgress =
            onView(allOf(withId(R.id.item_filter_in_progress), withText("In progress")));
    public static ViewInteraction filterExecuted =
            onView(allOf(withId(R.id.item_filter_executed), withText("Executed")));
    public static ViewInteraction filterCancelled =
            onView(allOf(withId(R.id.item_filter_cancelled), withText("Cancelled")));
}