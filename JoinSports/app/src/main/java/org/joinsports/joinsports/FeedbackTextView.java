package org.joinsports.joinsports;

import android.graphics.Color;
import android.widget.TextView;

/**
 * Created by Alex on 12.06.2017.
 */

public class FeedbackTextView {

    private final static int COLOR_SUCCESS = Color.BLACK;
    private final static int COLOR_ERROR = Color.RED;

    private TextView textView;

    public FeedbackTextView(TextView textView) {
        this.textView = textView;
    }

    public void displaySuccess(String text) {
        textView.setText(text);
        textView.setTextColor(COLOR_SUCCESS);
    }

    public void displayError(String text) {
        textView.setText(text);
        textView.setTextColor(COLOR_ERROR);
    }

}
