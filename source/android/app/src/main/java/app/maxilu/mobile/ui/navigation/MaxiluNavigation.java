package app.maxilu.mobile.ui.navigation;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.maxilu.mobile.R;
import app.maxilu.mobile.ui.components.MaxiluComponents;

/** Bottom navigation presentation. Screen routing remains owned by MainActivity. */
public final class MaxiluNavigation {
    public interface Listener {
        void onNavigate(String page);
    }

    private MaxiluNavigation() {}

    private static int dp(Activity activity, int value) {
        return Math.round(value * activity.getResources().getDisplayMetrics().density);
    }

    public static LinearLayout createBottomNavigation(
            Activity activity,
            String currentPage,
            Listener listener
    ) {
        LinearLayout outer = new LinearLayout(activity);
        outer.setOrientation(LinearLayout.VERTICAL);
        outer.setPadding(dp(activity, 10), dp(activity, 6), dp(activity, 10), dp(activity, 10));
        outer.setBackgroundColor(activity.getResources().getColor(R.color.maxilu_background));

        LinearLayout nav = new LinearLayout(activity);
        nav.setOrientation(LinearLayout.HORIZONTAL);
        nav.setGravity(Gravity.CENTER);
        nav.setPadding(dp(activity, 4), dp(activity, 4), dp(activity, 4), dp(activity, 4));

        GradientDrawable navBackground = new GradientDrawable();
        navBackground.setColor(activity.getResources().getColor(R.color.maxilu_surface));
        navBackground.setCornerRadius(dp(activity, 24));
        navBackground.setStroke(dp(activity, 1), activity.getResources().getColor(R.color.maxilu_outline));
        nav.setBackground(navBackground);

        addItem(activity, nav, currentPage, "Home", "home", listener);
        addItem(activity, nav, currentPage, "Chat", "chat", listener);
        addItem(activity, nav, currentPage, "AI", "ai", listener);
        addItem(activity, nav, currentPage, "Create", "creator", listener);
        addItem(activity, nav, currentPage, "More", "more", listener);

        outer.addView(nav, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dp(activity, 56)
        ));
        return outer;
    }

    private static void addItem(
            Activity activity,
            LinearLayout nav,
            String currentPage,
            String label,
            String page,
            Listener listener
    ) {
        boolean active = page.equals(currentPage)
                || ("creator".equals(page) && "create".equals(currentPage));
        int foreground = activity.getResources().getColor(
                active ? R.color.maxilu_text_primary : R.color.maxilu_text_muted
        );
        TextView item = MaxiluComponents.text(
                activity,
                label,
                11,
                foreground,
                active ? Typeface.BOLD : Typeface.NORMAL
        );
        item.setGravity(Gravity.CENTER);
        item.setClickable(true);
        item.setFocusable(true);
        item.setMinHeight(dp(activity, 48));
        if (active) {
            GradientDrawable activeBackground = new GradientDrawable();
            activeBackground.setColor(activity.getResources().getColor(R.color.maxilu_accent_soft));
            activeBackground.setCornerRadius(dp(activity, 16));
            item.setBackground(activeBackground);
        }
        item.setOnClickListener(view -> listener.onNavigate(page));

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.MATCH_PARENT,
                1f
        );
        params.setMargins(dp(activity, 2), dp(activity, 2), dp(activity, 2), dp(activity, 2));
        nav.addView(item, params);
    }
}
