package ru.netology.qamid45.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class CommentElement {
    public static ViewInteraction commentName = onView(withHint("Comment"));
    public static ViewInteraction commentText = onView(allOf(withHint("Comment"),
            withParent(withParent(withId(R.id.comment_text_input_layout)))));
}