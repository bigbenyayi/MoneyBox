package com.example.minimoneybox;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.VelocityTracker;
import android.widget.EditText;
import android.widget.TextView;
import com.example.minimoneybox.Activities.LoginActivity;
import com.example.minimoneybox.Activities.UserAccountActivity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Pattern;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeDown;
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
public class AmountVerification {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = getTargetContext();

        assertEquals("com.example.benja.go4lunch", appContext.getPackageName());
    }

    @Rule
    public final ActivityTestRule<UserAccountActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(UserAccountActivity.class);


    private UserAccountActivity mActivity = null;

    @Before
    public void setUp() {

        mActivity = mainActivityActivityTestRule.getActivity();
        Intents.init();
        assertThat(mActivity, notNullValue());
    }

    @Test
    public void totalValueExactness() {

        SystemClock.sleep(5000);

        SharedPreferences mPrefs = getTargetContext().getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);


        Integer totalPlanValueShouldBe = mPrefs.getInt("isaPlanValue", 0) +
                mPrefs.getInt("lisaPlanValue", 0) +
                mPrefs.getInt("giaPlanValue", 0) +
                mPrefs.getInt("pensionPlanValue", 0);

        assertSame(totalPlanValueShouldBe, mPrefs.getInt("totalPlanValue", 1));

    }
}
