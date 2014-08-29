package net.danlew.customviews;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SampleActivity extends Activity {

    private ViewGroup mSampleContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sample);

        mSampleContainer = (ViewGroup) findViewById(R.id.sample_container);

        User user = new User("Dan Lew", R.drawable.user_dan);

        // Binds without a custom View, as demonstration
        addNonCustomView(user);
    }

    private void addSample(CharSequence title, View sample) {
        SampleView sampleView = new SampleView(this);
        sampleView.bind(title, sample);
        mSampleContainer.addView(sampleView);
    }

    private void addNonCustomView(User user) {
        SampleView sampleView = new SampleView(this);

        View view = LayoutInflater.from(this).inflate(R.layout.user_not_custom, sampleView, false);
        TextView nameView = (TextView) view.findViewById(R.id.name);
        nameView.setText(user.getName());
        ImageView iconView = (ImageView) view.findViewById(R.id.icon);
        iconView.setImageResource(user.getIcon());

        sampleView.bind("Without using custom Views", view);

        mSampleContainer.addView(sampleView);
    }
}
