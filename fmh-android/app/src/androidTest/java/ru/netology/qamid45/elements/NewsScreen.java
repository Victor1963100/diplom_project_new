package ru.netology.qamid45.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.netology.qamid45.data.Helper.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsScreen {
    public static ViewInteraction newsName = onView(withText("News"));
    public static ViewInteraction filterNewsButton = onView(withId(R.id.filter_news_material_button));
    public static ViewInteraction sortNewsButton = onView(withId(R.id.sort_news_material_button));

    public static ViewInteraction allNewsBlock = onView(withId(R.id.all_news_cards_block_constraint_layout));
    public static ViewInteraction childNewsButton = onView(allOf(withId(R.id.news_list_recycler_view),
            childAtPosition(withClassName(is("android.widget.LinearLayout")),
                    withId(R.id.all_news_cards_block_constraint_layout),0)));
    public static ViewInteraction editNewsButton = onView(
            allOf(withId(R.id.edit_news_material_button),
                    childAtPosition(
                            withClassName(is("android.widget.LinearLayout")), childAtPosition(
                                    withClassName(is("android.widget.LinearLayout")),
                                    withId(R.id.container_list_news_include),0),3)));
}