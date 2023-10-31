package ru.netology.qamid45.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class EditClaimsElement {
    public static ViewInteraction editingName = onView(withText("Editing"));
    public static ViewInteraction editDescriptionText = onView(withId(R.id.description_edit_text));
    public static ViewInteraction editTitleText = onView(withId(R.id.title_edit_text));

}