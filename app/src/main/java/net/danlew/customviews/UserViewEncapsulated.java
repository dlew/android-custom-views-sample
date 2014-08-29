package net.danlew.customviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Simple UserView that wraps multiple Views together. Does nothing else.
 */
public class UserViewEncapsulated extends FrameLayout {

    private ImageView mIconView;
    private TextView mNameView;

    public UserViewEncapsulated(Context context) {
        super(context);

        LayoutInflater.from(context).inflate(R.layout.user_view_merge, this);
        mIconView = (ImageView) findViewById(R.id.icon);
        mNameView = (TextView) findViewById(R.id.name);
    }

    public void bind(User user) {
        mIconView.setImageResource(user.getIcon());
        mNameView.setText(user.getName());
    }
}
