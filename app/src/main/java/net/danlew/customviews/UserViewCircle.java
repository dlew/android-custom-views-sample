package net.danlew.customviews;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * UserView that lets you tint the icon view a color from attributes.
 */
public class UserViewCircle extends LinearLayout {

    private CircleView mIconView;
    private TextView mNameView;

    public UserViewCircle(Context context) {
        super(context);

        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER);

        LayoutInflater.from(context).inflate(R.layout.user_view_circle, this);
        mIconView = (CircleView) findViewById(R.id.icon);
        mNameView = (TextView) findViewById(R.id.name);
    }

    public void bind(User user) {
        mIconView.setBitmapResource(user.getIcon());
        mNameView.setText(user.getName());
    }
}
