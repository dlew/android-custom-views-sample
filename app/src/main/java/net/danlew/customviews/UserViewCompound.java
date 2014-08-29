package net.danlew.customviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Simple UserView that wraps multiple Views together. Does nothing else.
 */
public class UserViewCompound extends FrameLayout {

    private ImageView mIconView;
    private TextView mNameView;

    public UserViewCompound(Context context) {
        super(context);

        LayoutInflater.from(context).inflate(R.layout.user_view_merge, this);
        mIconView = (ImageView) findViewById(R.id.icon);
        mNameView = (TextView) findViewById(R.id.name);
    }

    public void setIcon(int drawable) {
        mIconView.setImageResource(drawable);
    }

    public void setName(CharSequence name) {
        mNameView.setText(name);
    }
}
