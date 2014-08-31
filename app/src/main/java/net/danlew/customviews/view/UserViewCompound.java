package net.danlew.customviews.view;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import net.danlew.customviews.R;

/**
 * Simple UserView that wraps multiple Views together. Does nothing else.
 */
public class UserViewCompound extends LinearLayout {

    private ImageView mIconView;
    private TextView mNameView;

    public UserViewCompound(Context context) {
        super(context);

        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER);

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
