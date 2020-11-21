package com.minorproject.krashakmart;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.minorproject.krashakmart.Utils.Constant;
import com.minorproject.krashakmart.Utils.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity implements
        SignInFragment.OnFragmentInteractionListener,
        SignUpFragment.OnFragmentInteractionListener,
        ResetPasswordFragment.OnFragmentInteractionListener {

    FrameLayout frameLayout;

    FragmentManager fragmentManager = getSupportFragmentManager();

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        frameLayout = findViewById(R.id.frame_layout);

        addFragment(SignInFragment.newInstance());
    }

    private void addFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(frameLayout.getId(), fragment, Constant.TAG_SIGN_IN_FRAG);

        fragmentTransaction.commit();

    }

    @Override
    public void onClickDontHaveAccount() {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_out_from_left);
        fragmentTransaction.replace(frameLayout.getId(), SignUpFragment.newInstance(), Constant.TAG_SIGN_UP_FRAG);
        fragmentTransaction.commit();

    }

    @Override
    public void onClickForgotPassword() {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slide_out_from_left);

        fragmentTransaction.replace(frameLayout.getId(), ResetPasswordFragment.newInstance(), Constant.TAG_RESET_PASSWORD_FRAG);

        fragmentTransaction.commit();
    }

    @Override
    public void onSignIn(String email, String password) {

        final SignInFragment signInFragment = (SignInFragment) fragmentManager.findFragmentByTag(Constant.TAG_SIGN_IN_FRAG);

        assert signInFragment != null;
        signInFragment.onLoadingStart();

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

            if (task.isSuccessful()) {

                SystemClock.sleep(1000);

                jumpToMainActivitiy();

            } else {

                Toast.makeText(RegisterActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();

            }

            signInFragment.onLoadingStop();

        });

    }

    @Override
    public void onClickAlreadyHaveAccount() {

        jumpToSignInFragment();

    }

    @Override
    public void onSignUp(String email, String password, final String fullName) {

        final SignUpFragment signInFragment = (SignUpFragment) fragmentManager.findFragmentByTag(Constant.TAG_SIGN_UP_FRAG);

        assert signInFragment != null;
        signInFragment.onLoadingStart();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {

                        Map<String, String> userData = new HashMap<>();
                        userData.put(Constant.KEY_FULL_NAME, fullName);

                        addDataToFireStore(Constant.USER_COLlECTION, userData);
                        jumpToMainActivitiy();

                    } else {

                        Utils.makeLongToast(RegisterActivity.this, Objects.requireNonNull(task.getException()).getMessage());

                    }

                    signInFragment.onLoadingStop();

                });

    }

    @Override
    public void onClose() {

        jumpToMainActivitiy();
        this.finish();

    }

    @Override
    public void onClickGoBack() {

        jumpToSignInFragment();

    }

    @Override
    public void resetPassword(String email) {
        final ResetPasswordFragment resetFragment = (ResetPasswordFragment) fragmentManager.findFragmentByTag(Constant.TAG_RESET_PASSWORD_FRAG);

        assert resetFragment != null;
        resetFragment.onLoading();

        firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {

                        resetFragment.onSentEmailSuccessful();

                    }

                }
                );

    }

    private void jumpToMainActivitiy() {

        Intent mainIntent = new Intent(RegisterActivity.this, HomeActivity.class);

        startActivity(mainIntent);

        RegisterActivity.this.finish();

    }

    private void jumpToSignInFragment() {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slide_out_from_right);
        fragmentTransaction.replace(frameLayout.getId(), SignInFragment.newInstance(), Constant.TAG_SIGN_IN_FRAG);
        fragmentTransaction.commit();

    }

    private void addDataToFireStore(String collection, Object data) {

        firebaseFirestore.collection(collection)
                .add(data).addOnCompleteListener(task -> {

            if (!task.isSuccessful()) {

                Utils.makeLongToast(RegisterActivity.this, Objects.requireNonNull(task.getException()).getMessage());

            } else {
                Utils.makeLongToast(RegisterActivity.this, "Successful!");

            }

        });

    }

        @Override
    public void onBackPressed() {
        SignInFragment signInFragment = (SignInFragment) fragmentManager.findFragmentByTag(Constant.TAG_SIGN_IN_FRAG);
        if(signInFragment != null && signInFragment.isVisible()) {
            super.onBackPressed();
            return;
        }
        jumpToSignInFragment();
    }
}
