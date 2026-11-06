package app.maxilu.mobile;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import app.maxilu.mobile.ui.components.MaxiluComponents;
import app.maxilu.mobile.ui.navigation.MaxiluNavigation;
import app.maxilu.mobile.ui.theme.MaxiluTheme;

/**
 * Public portfolio demo shell.
 *
 * This activity intentionally uses local sample content only. It has no
 * Gateway client, pairing, authentication, remote task dispatch or persistence.
 */
public final class MainActivity extends Activity {
    private LinearLayout root;
    private LinearLayout content;
    private String currentPage = "home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MaxiluTheme.applySystemBars(this);
        buildShell();
        showPage(currentPage);
    }

    private void buildShell() {
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(MaxiluTheme.color(this, R.color.maxilu_background));

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(dp(20), dp(24), dp(20), dp(20));

        ScrollView scroll = new ScrollView(this);
        scroll.setFillViewport(true);
        scroll.addView(content, new ScrollView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        root.addView(scroll, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f
        ));

        root.addView(MaxiluNavigation.createBottomNavigation(this, currentPage, page -> {
            currentPage = page;
            showPage(page);
        }));

        setContentView(root);
    }

    private void showPage(String page) {
        currentPage = page;
        content.removeAllViews();
        content.addView(MaxiluComponents.sectionLabel(this, "MAXILU POCKET  /  PUBLIC DEMO"));
        content.addView(MaxiluComponents.title(this, pageTitle(page)));
        content.addView(MaxiluComponents.paragraph(this, pageDescription(page)));

        if ("home".equals(page)) {
            addCard("System overview", "A mobile companion concept for the MAXILU ecosystem. The desktop/core remains the primary execution environment.");
            addCard("Connection", "Demo mode — no desktop connection is configured.");
            addCard("Recent activity", "Sample interface state only. No remote tasks are submitted.");
        } else if ("chat".equals(page)) {
            addCard("Conversation preview", "This is a visual preview of the mobile interaction surface. Messages are not sent to an AI service.");
            addCard("Input", "Live chat and model execution are not connected in this public demo.");
        } else if ("ai".equals(page)) {
            addCard("Model workspace", "Model availability is not connected to a runtime in this demo.");
            addCard("Runtime status", "DEMO / NOT CONNECTED");
        } else if ("creator".equals(page) || "create".equals(page)) {
            addCard("Creator workspace", "A preview area for future image, audio and content workflows.");
            addCard("Generation status", "No generation jobs are started by this demo.");
        } else {
            addCard("Demo information", "This public build contains selected Android presentation code and local sample content.");
            addCard("Private services", "Gateway, pairing, authentication, approvals and remote control remain excluded.");
        }

        TextView footer = MaxiluComponents.text(
                this,
                "MAXILU • PORTFOLIO BUILD • LOCAL DEMO DATA",
                10,
                MaxiluTheme.color(this, R.color.maxilu_text_muted),
                Typeface.BOLD
        );
        footer.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams footerParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, dp(40)
        );
        footerParams.topMargin = dp(16);
        content.addView(footer, footerParams);

        // Refresh the navigation presentation so the selected tab is accurate.
        View oldNav = root.getChildAt(1);
        if (oldNav != null) root.removeViewAt(1);
        root.addView(MaxiluNavigation.createBottomNavigation(this, currentPage, next -> {
            currentPage = next;
            showPage(next);
        }));
    }

    private void addCard(String title, String body) {
        content.addView(MaxiluComponents.infoCard(this, title, body));
    }

    private String pageTitle(String page) {
        switch (page) {
            case "chat": return "Chat";
            case "ai": return "AI Workspace";
            case "creator":
            case "create": return "Creator Studio";
            case "more": return "More";
            default: return "Your MAXILU";
        }
    }

    private String pageDescription(String page) {
        switch (page) {
            case "chat": return "A mobile conversation surface, presented here with offline sample content.";
            case "ai": return "A preview of model and runtime information areas.";
            case "creator":
            case "create": return "A preview of creative tools planned for the MAXILU ecosystem.";
            case "more": return "Project information and public-demo boundaries.";
            default: return "Your personal control surface for the MAXILU ecosystem.";
        }
    }

    private int dp(int value) {
        return MaxiluTheme.dp(this, value);
    }
}
