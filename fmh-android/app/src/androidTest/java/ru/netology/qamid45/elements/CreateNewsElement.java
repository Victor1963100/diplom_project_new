package ru.netology.qamid45.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class CreateNewsElement {
    public static ViewInteraction titleName = onView(withHint("Title"));
    public static ViewInteraction categoryName = onView(withHint("Category"));
    public static ViewInteraction descriptionName = onView(withHint("Description"));
    public static ViewInteraction publicationDateName = onView(withHint("Publication date"));
    public static ViewInteraction creatingName = onView(withText("Creating"));
    public static ViewInteraction categoryText =
            onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static ViewInteraction titleText = onView(withId(R.id.news_item_title_text_input_edit_text));
    public static ViewInteraction descriptionText =
            onView(withId(R.id.news_item_description_text_input_edit_text));
    public static ViewInteraction timeText =
            onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public static ViewInteraction publishDateText =
            onView(withId(R.id.news_item_publish_date_text_input_edit_text));
}