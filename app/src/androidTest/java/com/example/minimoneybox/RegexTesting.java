package com.example.minimoneybox;

import android.content.Context;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.EditText;
import com.example.minimoneybox.Activities.LoginActivity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Pattern;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.IsNull.notNullValue;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static org.junit.Assert.*;

@SuppressWarnings("WeakerAccess")
@RunWith(AndroidJUnit4.class)
public class RegexTesting {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = getTargetContext();

        assertEquals("com.example.benja.go4lunch", appContext.getPackageName());
    }

    @Rule
    public final ActivityTestRule<LoginActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(LoginActivity.class);



    private LoginActivity mActivity = null;

    @Before
    public void setUp() {

        mActivity = mainActivityActivityTestRule.getActivity();
        Intents.init();
        assertThat(mActivity, notNullValue());
    }

    @Test
    public void emailRegexTest() {

        //Checking if writing in ET works
        EditText emailET = mActivity.findViewById(R.id.et_email);

        //Check if EditText appears
        onView(withId(R.id.et_email))
                .perform(typeText("This is a test"))
                .check(matches(isDisplayed()));

        String inputSearch = emailET.getText().toString();
        String correctEmail = "androidtest@moneyboxapp.com";

        assertEquals("This is a test", inputSearch);

        //Check if Regex is working
        assertFalse(Pattern.matches("[^@]+@[^.]+\\..+", inputSearch));
        assertTrue(Pattern.matches("[^@]+@[^.]+\\..+", correctEmail));
    }
    @Test
    public void passwordRegexTest() {

        //Checking if writing in ET works
        EditText password = mActivity.findViewById(R.id.et_password);

        //Check if EditText appears
        onView(withId(R.id.et_password))
                .perform(typeText("p455word12"))
                .check(matches(isDisplayed()));

        String incorrect = password.getText().toString();
        String anotherIncorrect = "PaSsWoRd";
        String anotherIncorrect2 = "123456";
        String correctPassword = "P455word12";

        assertEquals("p455word12", incorrect);

        //Check if Regex is working
        assertFalse(Pattern.matches("^(?=.*[0-9])(?=.*[A-Z]).{10,50}$", incorrect));
        assertFalse(Pattern.matches("^(?=.*[0-9])(?=.*[A-Z]).{10,50}$", anotherIncorrect));
        assertFalse(Pattern.matches("^(?=.*[0-9])(?=.*[A-Z]).{10,50}$", anotherIncorrect2));
        assertTrue(Pattern.matches("^(?=.*[0-9])(?=.*[A-Z]).{10,50}$", correctPassword));
    }

    @Test
    public void nameRegexTest() {

        //Checking if writing in ET works
        EditText name = mActivity.findViewById(R.id.et_name);

        //Check if EditText appears
        onView(withId(R.id.et_name))
                .perform(typeText("Benjamin Corben"))
                .check(matches(isDisplayed()));

        String incorrect = name.getText().toString();
        String anotherIncorrect = "benj!";
        String anotherIncorrect2 = "123456";
        String correctName = "Benjamin";

        assertEquals("Benjamin Corben", incorrect);

        //Check if Regex is working
        assertFalse(Pattern.matches("[a-zA-Z]{6,30}", incorrect));
        assertFalse(Pattern.matches("[a-zA-Z]{6,30}", anotherIncorrect));
        assertFalse(Pattern.matches("[a-zA-Z]{6,30}", anotherIncorrect2));
        assertTrue(Pattern.matches("[a-zA-Z]{6,30}", correctName));
    }
}
