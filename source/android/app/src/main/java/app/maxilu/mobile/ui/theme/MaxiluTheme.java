package app.maxilu.mobile.ui.theme;

import android.app.Activity;
import android.content.Context;

import app.maxilu.mobile.R;

/** Shared access to MAXILU Pocket theme resources and Android system bars. */
public final class MaxiluTheme {
    private MaxiluTheme() {}

    public static int color(Context context, int colorResource) {
        return context.getResources().getColor(colorResource);
    }

    public static int dp(Context context, int value) {
        return Math.round(value * context.getResources().getDisplayMetrics().density);
    }

    public static void applySystemBars(Activity activity) {
        int background = color(activity, R.color.maxilu_background);
        activity.getWindow().setStatusBarColor(background);
        activity.getWindow().setNavigationBarColor(background);
    }
}
