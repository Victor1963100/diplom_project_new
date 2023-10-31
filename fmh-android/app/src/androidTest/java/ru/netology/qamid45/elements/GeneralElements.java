package ru.netology.qamid45.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.netology.qamid45.data.Helper;

public class GeneralElements {
    public static ViewInteraction butterflyNewsListImage = onView(withId(R.id.empty_news_list_image_view));
    public static ViewInteraction butterflyClaimsListImage = onView(withId(R.id.empty_claim_list_image_view));
    public static ViewInteraction butterflyPanelListImage=
            onView(withId(R.id.control_panel_empty_news_list_image_view));
    public static ViewInteraction GeneralCancelButton = onView(withId(R.id.cancel_button));
    public static ViewInteraction GeneralSaveButton = onView(withId(R.id.save_button));
    public static ViewInteraction deleteDocText = onView(withText("Are you sure you want to permanently " +
            "delete the document? These changes cannot be reversed in the future."));
    public static ViewInteraction cancelButton = onView(withText("Cancel"));
    public static ViewInteraction oKButton = onView(withText("OK"));
    public static ViewInteraction refreshText = onView(withText("Refresh"));
    public static ViewInteraction nothingText = onView(withText("There is nothing here yet…"));
    public static ViewInteraction EnterValidTimeNext = onView(withText("Enter a valid time"));
    public static ViewInteraction invalidData(String text) {
        return onView(allOf(withId(android.R.id.message), withText(text)));
    }
    public static ViewInteraction emptyToastMatcher(int id) {
        return onView(withText(id)).inRoot(new Helper.ToastMatcher());
    }
    public static ViewInteraction errorToastMatcher(int id) {
        return onView(withText(id)).inRoot(new Helper.ToastMatcher());
    }
    public static ViewInteraction emptyMessage(int id) {
        return onView(allOf(withId(android.R.id.message), withText(id)));
    }
}