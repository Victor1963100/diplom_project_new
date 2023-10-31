package ru.netology.qamid45.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class EditNewsElement {
    public static ViewInteraction editingName = onView(withText("Editing"));
    public static ViewInteraction newsCategoryText =
            onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static ViewInteraction newsPublishTimeText =
            onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public static ViewInteraction newsTitleEditText =
            onView(withId(R.id.news_item_title_text_input_edit_text));
    public static ViewInteraction newsDescriptionText =
            onView(withId(R.id.news_item_description_text_input_edit_text));

    //  public ViewInteraction newsPublichTimeText = onView(withId(R.id.news_item_publish_time_text_input_edit_text));

    public static ViewInteraction switcher = onView(withId(R.id.switcher));
}