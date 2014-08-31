package net.danlew.customviews.data;

/**
 * Represents a user
 */
public class User {

    private String mName;
    private int mIcon;

    public User(String name, int icon) {
        mName = name;
        mIcon = icon;
    }

    public String getName() {
        return mName;
    }

    public int getIcon() {
        return mIcon;
    }
}
