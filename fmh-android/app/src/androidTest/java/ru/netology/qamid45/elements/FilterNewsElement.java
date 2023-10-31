package ru.netology.qamid45.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class FilterNewsElement {
    public static ViewInteraction filterNewsName = onView(withText("Filter news"));
    public static ViewInteraction dateStartText =
            onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    public static ViewInteraction categoryText =
            onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static ViewInteraction filterButton = onView(withText("FILTER"));
    public static ViewInteraction dateEndText =
            onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));

    //   public ViewInteraction cancelBtn = onView(withId(R.id.cancel_button));
    public static ViewInteraction filterActive =
            onView(withId(R.id.filter_news_active_material_check_box));
    public static ViewInteraction filterNotActive =
            onView(withId(R.id.filter_news_inactive_material_check_box));
}