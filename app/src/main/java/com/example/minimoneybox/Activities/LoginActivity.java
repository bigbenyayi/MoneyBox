package com.example.minimoneybox.Activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.example.minimoneybox.Api.Api;
import com.example.minimoneybox.Models.BearerRequest;
import com.example.minimoneybox.Models.SessionResponse;
import com.example.minimoneybox.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {


    /////////////// Views \\\\\\\\\\\\\\\\
    //Edittexts
    EditText emailEditText;
    EditText passwordEditText;
    EditText nameEditText;

    //Button
    Button signInButton;

    //Lottie
    LottieAnimationView pigAnimation;

    //TextInputLayout
    TextInputLayout emailTIL;
    TextInputLayout passwordTIL;
    TextInputLayout nameTIL;

    /////////////// Variables \\\\\\\\\\\\\\\\
    String bearerToken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_java);
        setupViews();

    }

    @Override
    protected void onStart() {
        super.onStart();

        pigAnimation.setMinAndMaxFrame(0, 109);
        pigAnimation.loop(false);
        pigAnimation.playAnimation();

        pigAnimation.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                pigAnimation.setMinAndMaxFrame(131, 158);
                pigAnimation.loop(true);
                pigAnimation.playAnimation();
            }
        });
    }

    private void setupViews() {
        emailEditText = findViewById(R.id.et_email);
        passwordEditText = findViewById(R.id.et_password);
        nameEditText = findViewById(R.id.et_name);
        signInButton = findViewById(R.id.btn_sign_in);
        pigAnimation = findViewById(R.id.animation);
        emailTIL = findViewById(R.id.til_email);
        passwordTIL = findViewById(R.id.til_password);
        nameTIL = findViewById(R.id.til_name);

        signInButton.setOnClickListener(v -> {
            if (allFieldsValid()) {
                Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
                Api api = retrofit.create(Api.class);
                Call<SessionResponse> call1 = api.postLoginDetails(new BearerRequest(emailEditText.getText().toString(), passwordEditText.getText().toString(), "ANYTHING"));

                call1.enqueue(new Callback<SessionResponse>() {
                    @Override
                    public void onResponse(Call<SessionResponse> call, Response<SessionResponse> response) {

                        if (response.body() != null) {

                            Toast.makeText(LoginActivity.this, getString(R.string.input_valid), Toast.LENGTH_SHORT).show();
                            Intent myIntent = new Intent(LoginActivity.this, UserAccountActivity.class);
                            myIntent.putExtra("name", nameEditText.getText().toString());

                            Log.d("bearer", response.body().getSession().getBearerToken());

                            SharedPreferences mPrefs = getSharedPreferences( "shared_prefs", MODE_PRIVATE);
                            mPrefs.edit().putString("bearer", response.body().getSession().getBearerToken()).apply();
                            bearerToken = response.body().getSession().getBearerToken();


                            startActivity(myIntent);
                        }
                    }

                    @Override
                    public void onFailure(Call<SessionResponse> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Failure " + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    private boolean allFieldsValid() {
        boolean emailValid = false;
        boolean passwordValid = false;
        boolean nameValid = false;

        String EMAIL_REGEX = "[^@]+@[^.]+\\..+";
        String NAME_REGEX = "[a-zA-Z]{6,30}";
        String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[A-Z]).{10,50}$";

        if (Pattern.matches(EMAIL_REGEX, emailEditText.getText().toString())) {
            emailValid = true;
            emailTIL.setError("");
            emailTIL.setHint("Email");
        } else {
            emailTIL.setError(getString(R.string.prompt_email));
            emailTIL.setHint("");
        }

        if (Pattern.matches(PASSWORD_REGEX, passwordEditText.getText().toString())) {
            passwordValid = true;
            passwordTIL.setError("");
            passwordTIL.setHint(getString(R.string.prompt_password));
        } else {
            passwordTIL.setError(getString(R.string.password_error));
            passwordTIL.setHint("");
        }

        if (Pattern.matches(NAME_REGEX, nameEditText.getText().toString()) || nameEditText.getText().toString().equals("")) {
            nameValid = true;
            nameTIL.setError("");
            nameTIL.setHint(getString(R.string.prompt_full_name));
        } else {
            nameTIL.setError(getString(R.string.full_name_error));
            nameTIL.setHint("");
        }
        return emailValid && passwordValid && nameValid;
    }

//        val firstAnim = 0 to 109;
//        val secondAnim = 131 to 158;


}
