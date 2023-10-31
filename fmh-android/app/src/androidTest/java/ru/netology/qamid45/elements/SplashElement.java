package ru.netology.qamid45.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class SplashElement {
    public static ViewInteraction splashImage = onView(withId(R.id.splashscreen_image_view));
    public static ViewInteraction splashText = onView(withId(R.id.splashscreen_text_view));
    public static ViewInteraction splashProgressIndicator =
            onView(withId(R.id.splash_screen_circular_progress_indicator));

}