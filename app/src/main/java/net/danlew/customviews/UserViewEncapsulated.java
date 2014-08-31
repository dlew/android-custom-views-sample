package net.danlew.customviews;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * UserView that has a special knowledge of how to bind relevant data.
 */
public class UserViewEncapsulated extends LinearLayout {

    private ImageView mIconView;
    private TextView mNameView;

    public UserViewEncapsulated(Context context) {
        super(context);

        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER);

        LayoutInflater.from(context).inflate(R.layout.user_view_merge, this);
        mIconView = (ImageView) findViewById(R.id.icon);
        mNameView = (TextView) findViewById(R.id.name);
    }

    public void bind(User user) {
        mIconView.setImageResource(user.getIcon());
        mNameView.setText(user.getName());
    }
}
