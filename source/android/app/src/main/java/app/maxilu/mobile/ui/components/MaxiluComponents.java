package app.maxilu.mobile.ui.components;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.maxilu.mobile.R;

/**
 * Shared native UI primitives for MAXILU Pocket.
 *
 * This class deliberately owns presentation only. Navigation, screen state,
 * Gateway calls, task actions and persistence remain in MainActivity/stores.
 */
public final class MaxiluComponents {
    private MaxiluComponents() {}

    private static int dp(Context context, int value) {
        return Math.round(value * context.getResources().getDisplayMetrics().density);
    }

    private static int color(Context context, int resourceId) {
        return context.getResources().getColor(resourceId);
    }

    private static GradientDrawable surface(Context context, int fill, int radiusDp, boolean outlined) {
        GradientDrawable background = new GradientDrawable();
        background.setColor(fill);
        background.setCornerRadius(dp(context, radiusDp));
        if (outlined) {
            background.setStroke(dp(context, 1), color(context, R.color.maxilu_outline));
        }
        return background;
    }

    public static LinearLayout card(Context context) {
        LinearLayout card = new LinearLayout(context);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(dp(context, 17), dp(context, 16), dp(context, 17), dp(context, 16));
        card.setBackground(surface(
                context,
                color(context, R.color.maxilu_surface),
                18,
                true
        ));
        return card;
    }

    public static TextView text(Context context, String value, int sp, int textColor, int style) {
        TextView view = new TextView(context);
        view.setText(value);
        view.setTextSize(sp);
        view.setTextColor(textColor);
        view.setTypeface(Typeface.create("sans-serif", style));
        view.setIncludeFontPadding(false);
        return view;
    }

    public static TextView title(Context context, String value) {
        TextView title = text(
                context,
                value,
                28,
                color(context, R.color.maxilu_text_primary),
                Typeface.BOLD
        );
        title.setLetterSpacing(-0.02f);
        LinearLayout.LayoutParams params = blockParams(context);
        params.bottomMargin = dp(context, 10);
        title.setLayoutParams(params);
        return title;
    }

    public static TextView paragraph(Context context, String value) {
        TextView paragraph = text(
                context,
                value,
                14,
                color(context, R.color.maxilu_text_secondary),
                Typeface.NORMAL
        );
        paragraph.setLineSpacing(0, 1.20f);
        LinearLayout.LayoutParams params = blockParams(context);
        params.bottomMargin = dp(context, 24);
        paragraph.setLayoutParams(params);
        return paragraph;
    }

    public static TextView sectionLabel(Context context, String value) {
        TextView label = text(
                context,
                value,
                11,
                color(context, R.color.maxilu_text_muted),
                Typeface.BOLD
        );
        label.setLetterSpacing(0.08f);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.topMargin = dp(context, 10);
        params.bottomMargin = dp(context, 10);
        label.setLayoutParams(params);
        return label;
    }

    public static LinearLayout infoCard(Context context, String title, String body) {
        LinearLayout card = card(context);
        card.addView(text(
                context,
                title,
                15,
                color(context, R.color.maxilu_text_primary),
                Typeface.BOLD
        ));
        TextView detail = text(
                context,
                body,
                13,
                color(context, R.color.maxilu_text_secondary),
                Typeface.NORMAL
        );
        detail.setLineSpacing(0, 1.14f);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.topMargin = dp(context, 6);
        card.addView(detail, params);
        card.setLayoutParams(blockParams(context));
        return card;
    }

    public static View methodButton(
            Context context,
            String title,
            String subtitle,
            View.OnClickListener listener
    ) {
        LinearLayout row = card(context);
        row.setClickable(true);
        row.setFocusable(true);
        row.setOnClickListener(listener);

        LinearLayout textBlock = new LinearLayout(context);
        textBlock.setOrientation(LinearLayout.VERTICAL);
        textBlock.addView(text(
                context,
                title,
                16,
                color(context, R.color.maxilu_text_primary),
                Typeface.BOLD
        ));

        TextView sub = text(
                context,
                subtitle,
                13,
                color(context, R.color.maxilu_text_secondary),
                Typeface.NORMAL
        );
        sub.setLineSpacing(0, 1.12f);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.topMargin = dp(context, 5);
        textBlock.addView(sub, params);
        row.addView(textBlock);
        row.setLayoutParams(blockParams(context));
        return row;
    }

    public static Button primaryButton(Context context, String value) {
        Button button = new Button(context);
        button.setText(value);
        button.setTextColor(color(context, R.color.maxilu_text_on_accent));
        button.setTextSize(14);
        button.setAllCaps(false);
        button.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        button.setStateListAnimator(null);
        button.setMinHeight(dp(context, 48));
        button.setBackground(surface(
                context,
                color(context, R.color.maxilu_accent),
                16,
                false
        ));
        return button;
    }

    public static Button smallButton(Context context, String value) {
        Button button = new Button(context);
        button.setText(value);
        button.setAllCaps(false);
        button.setTextColor(color(context, R.color.maxilu_text_primary));
        button.setTextSize(13);
        button.setStateListAnimator(null);
        button.setMinHeight(dp(context, 40));
        button.setBackground(surface(
                context,
                color(context, R.color.maxilu_surface_elevated),
                13,
                true
        ));
        return button;
    }

    public static Button compactComposerButton(Context context, String value) {
        Button button = new Button(context);
        button.setText(value);
        button.setAllCaps(false);
        button.setTextSize(12);
        button.setTextColor(color(context, R.color.maxilu_text_primary));
        button.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        button.setMinWidth(0);
        button.setMinHeight(dp(context, 48));
        button.setStateListAnimator(null);
        button.setPadding(dp(context, 6), 0, dp(context, 6), 0);
        button.setBackground(surface(
                context,
                "Send".equals(value)
                        ? color(context, R.color.maxilu_accent)
                        : color(context, R.color.maxilu_surface_elevated),
                20,
                !"Send".equals(value)
        ));
        return button;
    }

    public static EditText dialogInput(Context context, String hint) {
        EditText input = new EditText(context);
        input.setHint(hint);
        input.setTextColor(color(context, R.color.maxilu_text_primary));
        input.setHintTextColor(color(context, R.color.maxilu_text_muted));
        input.setTextSize(14);
        input.setPadding(dp(context, 15), dp(context, 13), dp(context, 15), dp(context, 13));
        input.setBackground(surface(
                context,
                color(context, R.color.maxilu_surface),
                14,
                true
        ));
        return input;
    }

    public static LinearLayout.LayoutParams blockParams(Context context) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.bottomMargin = dp(context, 10);
        return params;
    }

    public static LinearLayout.LayoutParams buttonBlockParams(Context context) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dp(context, 52)
        );
        params.bottomMargin = dp(context, 10);
        return params;
    }
}
