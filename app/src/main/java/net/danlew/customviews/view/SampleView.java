package net.danlew.customviews.view;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import net.danlew.customviews.R;

/**
 * The sample View is a custom View! When will the madness end?!
 */
public class SampleView extends LinearLayout {

    private TextView mTitleView;

    public SampleView(Context context) {
        super(context);

        setOrientation(LinearLayout.VERTICAL);
        setGravity(Gravity.CENTER);

        LayoutInflater.from(context).inflate(R.layout.sample_view, this, true);
        mTitleView = (TextView) findViewById(R.id.title);
    }

    public void bind(CharSequence title, View view) {
        // Don't allow binding multiple views
        if (getChildCount() == 2) {
            removeViewAt(1);
        }

        mTitleView.setText(title);

        addView(view);
    }
}
