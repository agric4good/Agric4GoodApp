package com.bumie.agric4good;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.nexmo.client.NexmoClient;

public class Chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavManager.getInstance().init(navController);

        new NexmoClient.Builder().build(this);
    }
    @Override
    public void onBackPressed() {
        FragmentManager childFragmentManager =
                getSupportFragmentManager().getPrimaryNavigationFragment().getChildFragmentManager();

        Fragment currentNavigationFragment = childFragmentManager.getFragments().get(0);
        BackPressHandler backPressHandler = (BackPressHandler) currentNavigationFragment;

        if (backPressHandler != null) {
            backPressHandler.onBackPressed();
        }

        super.onBackPressed();
    }
}