package com.thealeksandr.fancytextview.patterns;

/**
 * Created by Aleksandr Nikiforov on 6/29/17.
 */

public class HashTagFancyPattern extends FancyTextViewPattern {

    @Override
    public String getPattern() {
        return "([#])\\b\\w+\\b";
    }

}
