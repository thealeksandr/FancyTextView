package com.thealeksandr.fancytextview.patterns;

/**
 * Created by Aleksandr Nikiforov on 6/29/17.
 */

public class MentionFancyPattern extends FancyTextViewPattern {

    @Override
    public String getPattern() {
        return "([@])\\b\\w+\\b";
    }

}

