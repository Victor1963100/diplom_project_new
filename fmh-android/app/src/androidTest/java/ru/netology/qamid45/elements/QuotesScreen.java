package ru.netology.qamid45.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import static ru.netology.qamid45.data.Helper.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class QuotesScreen {
    public static ViewInteraction missionName = onView((withId(R.id.our_mission_title_text_view)));
    public static ViewInteraction missionList = onView(withId(R.id.our_mission_item_list_recycler_view));
    public static ViewInteraction missionConstraintLayout = onView(allOf(withId(R.id.our_mission_item_list_recycler_view),
            childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")), 0)));
}