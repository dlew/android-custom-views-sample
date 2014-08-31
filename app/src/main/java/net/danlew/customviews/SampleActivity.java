package net.danlew.customviews;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import net.danlew.customviews.data.User;
import net.danlew.customviews.view.SampleView;
import net.danlew.customviews.view.UserViewAttrs;
import net.danlew.customviews.view.UserViewCircle;
import net.danlew.customviews.view.UserViewCompound;
import net.danlew.customviews.view.UserViewEncapsulated;

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

        // Simple compound View demonstration
        addCompoundUserView();

        // Encapsulation-bound compound View demonstration
        addEncapsulatedUserView();

        // UserView with XML-defined attributes
        addStyledUserView();

        // UserView with a CircleView in it
        addCircleUserView();
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

    private void addEncapsulatedUserView() {
        UserViewEncapsulated userView = new UserViewEncapsulated(this);
        userView.bind(mUser);

        addSample("Encapsulated compound View", userView);
    }

    private void addStyledUserView() {
        // Normally you would provide a way to set these attributes in code; in our case
        // we're demonstrating XML attributes so we're doing it the hard way.
        UserViewAttrs userView = (UserViewAttrs) LayoutInflater.from(this)
            .inflate(R.layout.user_view_attrs, null, false);
        userView.bind(mUser);

        addSample("Styled UserView", userView);
    }

    private void addCircleUserView() {
        UserViewCircle userView = new UserViewCircle(this);
        userView.bind(mUser);

        addSample("UserView w/ custom drawing", userView);
    }
}
