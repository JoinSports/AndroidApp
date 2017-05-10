package org.joinsports.joinsports;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CreateNewUserTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void createNewUserTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.main_bt_create_user), withText("User erstellen"),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.create_user_tf_username), isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.create_user_tf_username), isDisplayed()));
        appCompatEditText2.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.create_user_tf_username), isDisplayed()));
        appCompatEditText3.perform(replaceText("testuserab"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.create_user_tf_firstname), isDisplayed()));
        appCompatEditText4.perform(replaceText("Max"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.create_user_tf_lastname), isDisplayed()));
        appCompatEditText5.perform(replaceText("Gollum"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.create_user_tf_email), isDisplayed()));
        appCompatEditText6.perform(replaceText("hal@lol.com"), closeSoftKeyboard());


        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.create_user_tf_password), isDisplayed()));
        appCompatEditText9.perform(replaceText("1234567"), closeSoftKeyboard());


        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.create_user_tf_password_repeat), isDisplayed()));
        appCompatEditText10.perform(replaceText("1234567"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.create_user_bt_create_user), withText("User erstellen"), isDisplayed()));
        appCompatButton2.perform(click());

    }

}
