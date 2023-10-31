package ru.netology.qamid45.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.netology.qamid45.data.Helper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ClaimsScreen {
    public static ViewInteraction claimName = onView(withText("Claims"));
    public static ViewInteraction claimFilterButton = onView(withId(R.id.filters_material_button));
    public static ViewInteraction addClaimButton = onView(withId(R.id.add_new_claim_material_button));
    public static ViewInteraction claimList = onView(withId(R.id.claim_list_recycler_view));
    public static ViewInteraction executorLabelText = onView(withId(R.id.executor_name_label_text_view));
    public static ViewInteraction executorNameText = onView(withId(R.id.executor_name_text_view));
    public static ViewInteraction titleLabelText = onView(withId(R.id.title_label_text_view));
    public static ViewInteraction titleText = onView(withId(R.id.title_text_view));
    public static ViewInteraction description = onView(withId(R.id.description_material_card_view));
    public static ViewInteraction descriptionText = onView(withId(R.id.description_text_view));
    public static ViewInteraction dateLabelText = onView(withId(R.id.plane_date_label_text_view));
    public static ViewInteraction claimDateText = onView(withId(R.id.plane_date_text_view));
    public static ViewInteraction claimTimeText = onView(withId(R.id.plan_time_text_view));
    public static ViewInteraction createLabelText = onView(withId(R.id.create_data_label_text_view));
    public static ViewInteraction createDateText = onView(withId(R.id.create_data_text_view));
    public static ViewInteraction createTimeText = onView(withId(R.id.create_time_text_view));
    public static ViewInteraction authorLabelText = onView(withId(R.id.author_label_text_view));
    public static ViewInteraction authorNameText = onView(withId(R.id.author_name_text_view));

    public static ViewInteraction statusIconImage = onView(withId(R.id.status_icon_image_view));
    public static ViewInteraction changeComment = onView(withId(R.id.editText));

    public static ViewInteraction takeToWorkText = onView(withText("take to work"));
    public static ViewInteraction cancelText = onView(withText("Cancel"));
    public static ViewInteraction toExecuteText = onView(withText("To execute"));
    public static ViewInteraction throwOffText = onView(withText("Throw off"));
    public static ViewInteraction statusProcessButton =
            onView(withId(R.id.status_processing_image_button));
    public static ViewInteraction returnButton = onView(withId(R.id.close_image_button));
    public static ViewInteraction addCommentButton = onView(withId(R.id.add_comment_image_button));
    public static ViewInteraction editProcessButton = onView(withId(R.id.edit_processing_image_button));
    public static ViewInteraction addComment(String text) {
        return onView(withText(text));
    }
    public static ViewInteraction claimListCard(int index) {
        return onView(withIndex(withId(R.id.claim_list_card), index));
    }
    public static ViewInteraction commentDescText(int position) {
        return onView(withIndex(withId(R.id.comment_description_text_view), position));
    }
    public static ViewInteraction editCommentButton(int index) {
        return onView(allOf(withIndex(withId(R.id.edit_comment_image_button), index),
                withContentDescription("button edit comment")));
    }
}