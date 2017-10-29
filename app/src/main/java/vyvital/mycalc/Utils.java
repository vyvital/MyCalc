package vyvital.mycalc;

import android.app.Activity;
import android.content.Intent;


class Utils {
    private static int sTheme;


    public final static int THEME_DEFAULT = 0;
    public final static int ORANGE = 1;
    public final static int PINK = 2;
    public final static int RED = 3;
    public final static int LIME = 4;
    public final static int GREEN = 5;
    public final static int TEAL = 6;
    public final static int BLUE = 7;
    public final static int PURPLE = 8;
    public final static int DARK = 9;



    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));

    }

    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.AppTheme);
                break;
            case ORANGE:
                activity.setTheme(R.style.orangeTheme);
                break;
            case PINK:
                activity.setTheme(R.style.pinkTheme);
                break;
            case RED:
                activity.setTheme(R.style.redTheme);
                break;
            case GREEN:
                activity.setTheme(R.style.greenTheme);
                break;
            case TEAL:
                activity.setTheme(R.style.tealTheme);
                break;
            case BLUE:
                activity.setTheme(R.style.blueTheme);
                break;
            case PURPLE:
                activity.setTheme(R.style.purpleTheme);
                break;
            case DARK:
                activity.setTheme(R.style.darkTheme);
                break;
            case LIME:
                activity.setTheme(R.style.limeTheme);
                break;
        }
    }
}
