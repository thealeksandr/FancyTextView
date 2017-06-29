package com.thealeksandr.fancytextview.patterns;

import com.thealeksandr.fancytextview.FancyTextViewCallback;

/**
 * Created by Aleksandr Nikiforov on 6/29/17.
 */

public abstract class FancyTextViewPattern {

    public static final int DEFAULT_COLOR = 0xFF000077;

    public int getColor() {
        return DEFAULT_COLOR;
    }

    public abstract String getPattern();

    public FancyTextViewCallback getCallBack() {
        return null;
    }
}
