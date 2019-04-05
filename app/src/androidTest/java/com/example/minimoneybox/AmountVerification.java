package com.example.minimoneybox;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.view.VelocityTracker;
import android.widget.EditText;
import android.widget.TextView;
import com.example.minimoneybox.Activities.LoginActivity;
import com.example.minimoneybox.Activities.UserAccountActivity;
import com.example.minimoneybox.Api.Api;
import com.example.minimoneybox.Models.BearerRequest;
import com.example.minimoneybox.Models.InverstorProducts;
import com.example.minimoneybox.Models.ProductResponse;
import com.example.minimoneybox.Models.SessionResponse;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
import java.util.regex.Pattern;

import static android.content.Context.MODE_PRIVATE;
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
    String bearerToken;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = getTargetContext();

        assertEquals("com.example.minimoneybox", appContext.getPackageName());
    }

    @Rule
    public final ActivityTestRule<UserAccountActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(UserAccountActivity.class);


    private UserAccountActivity mActivity = null;

    @Before
    public void setUp() {

        mActivity = mainActivityActivityTestRule.getActivity();
        assertThat(mActivity, notNullValue());
    }

    @Test
    public void totalValueExactness() {

        //Comparing values from APIs ----- Checking if Total Plan Value actually equals the total of the others
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);
        Call<SessionResponse> call1 = api.postLoginDetails(new BearerRequest("androidtest@moneyboxapp.com", "P455word12", "ANYTHING"));
        call1.enqueue(new Callback<SessionResponse>() {
            @Override
            public void onResponse(Call<SessionResponse> call, Response<SessionResponse> response) {
                bearerToken = response.body().getSession().getBearerToken();

                Call<InverstorProducts> call123 = api.getInvestorProducts("Bearer " + bearerToken,
                        "3a97b932a9d449c981b595",
                        "application/json",
                        "5.10.0",
                        "3.0.0");
                call123.enqueue(new Callback<InverstorProducts>() {
                    @Override
                    public void onResponse(Call<InverstorProducts> call, Response<InverstorProducts> response) {
                        InverstorProducts responseObject = response.body();
                        List<ProductResponse> listResponse = responseObject.getProductResponses();

                        int number = 0;

                        for (int i = 0; i < listResponse.size(); i++) {
                            number = (int) (number +  Math.round(listResponse.get(i).getPlanValue()));
                        }

                        assertEquals(number, (int) responseObject.getTotalPlanValue());
                    }

                    @Override
                    public void onFailure(Call<InverstorProducts> call, Throwable t) {

                    }
                });
            }


            @Override
            public void onFailure(Call<SessionResponse> call, Throwable t) {

            }
        });

    }
}
