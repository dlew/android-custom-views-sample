package net.danlew.customviews;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;

public class SampleActivity extends Activity {

    private User mUser;

    private ViewGroup mSampleContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sample);

        mSampleContainer = (ViewGroup) findViewById(R.id.sample_container);

        mUser = new User("Dan Lew", R.drawable.user_dan);

        // Binds without a custom View, as demonstration
        addNonCustomView();

        // Simple Compound View demonstration
        addCompoundUserView();
    }

    private void addSample(CharSequence title, View sample) {
        SampleView sampleView = new SampleView(this);
        sampleView.bind(title, sample);
        mSampleContainer.addView(sampleView);

        Space space = new Space(this);
        mSampleContainer.addView(space);
        space.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.sample_padding);
    }

    private void addNonCustomView() {
        View view = LayoutInflater.from(this).inflate(R.layout.user_view_not_custom, null, false);
        TextView nameView = (TextView) view.findViewById(R.id.name);
        nameView.setText(mUser.getName());
        ImageView iconView = (ImageView) view.findViewById(R.id.icon);
        iconView.setImageResource(mUser.getIcon());

        addSample("Without using custom Views", view);
    }

    private void addCompoundUserView() {
        UserViewCompound userView = new UserViewCompound(this);
        userView.setName(mUser.getName());
        userView.setIcon(mUser.getIcon());

        addSample("Simple compound View", userView);
    }
}
