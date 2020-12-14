package com.bumie.agric4good;

import androidx.navigation.NavController;
import androidx.navigation.NavDirections;

public class NavManager {
    private static NavManager INSTANCE;
    NavController navController;

    public static NavManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NavManager();
        }

        return INSTANCE;
    }

    public void init(NavController navController) {
        this.navController = navController;
    }

    public void navigate(NavDirections navDirections) {
        navController.navigate(navDirections);
    }
}