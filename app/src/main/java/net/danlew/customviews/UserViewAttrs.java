package net.danlew.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * UserView that lets you tint the icon view a color from attributes.
 */
public class UserViewAttrs extends LinearLayout {

    private ImageView mIconView;
    private TextView mNameView;

    public UserViewAttrs(Context context) {
        // If you want to be able to create a View in code or XML, keep both constructors
        this(context, null);
    }

    public UserViewAttrs(Context context, AttributeSet attrs) {
        super(context, attrs);

        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER);

        LayoutInflater.from(context).inflate(R.layout.user_view_merge, this);
        mIconView = (ImageView) findViewById(R.id.icon);
        mNameView = (TextView) findViewById(R.id.name);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.UserView);
        setTint(ta.getColor(R.styleable.UserView_tint, Color.TRANSPARENT));
        ta.recycle();
    }

    // It's a good idea to allow styleable attributes to still be customized at runtime
    public void setTint(int color) {
        if (color == Color.TRANSPARENT) {
            mIconView.setColorFilter(null);
        }
        else {
            mIconView.setColorFilter(color);
        }
    }

    public void bind(User user) {
        mIconView.setImageResource(user.getIcon());
        mNameView.setText(user.getName());
    }
}
