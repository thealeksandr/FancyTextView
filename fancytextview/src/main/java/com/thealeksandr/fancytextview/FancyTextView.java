package com.thealeksandr.fancytextview;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aleksandr Nikiforov on 6/29/17.
 */
public class FancyTextView extends TextView {

    private static final int DEFAULT_COLOR = 0xFF885555;

    private FancyTextViewCallback mHashTagCallback;
    private FancyTextViewCallback mMentionCallback;


    public FancyTextView(Context context){
        super(context);
    }

    public FancyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setText(String text) {
        super.setText(text);

        SpannableString spannableString = new SpannableString(text);
        Pattern pattern = Pattern.compile("([#])\\b\\w+\\b");

        Matcher matcher = pattern.matcher(text);


        while (matcher.find()) {
            final String str = matcher.group();
            NoUnderlineClickableSpan clickSpan = new NoUnderlineClickableSpan(DEFAULT_COLOR) {
                @Override
                public void onClick(View widget) {
                    if (mHashTagCallback != null) {
                        mHashTagCallback.onClick(str);
                    }
                }
            };
            final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
            spannableString.setSpan(clickSpan, matcher.start(), matcher.end(),
                    Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            spannableString.setSpan(bss, matcher.start(), matcher.end(),
                    Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        }

        Pattern patternM = Pattern.compile("([@])\\b\\w+\\b");

        Matcher matcherM = patternM.matcher(text);

        while (matcherM.find()) {
            final String str = matcherM.group();
            ClickableSpan clickSpan = new NoUnderlineClickableSpan(DEFAULT_COLOR) {
                @Override
                public void onClick(View widget) {
                    if (mHashTagCallback != null) {
                        mHashTagCallback.onClick(str);
                    }
                }
            };
            final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
            spannableString.setSpan(clickSpan, matcherM.start(), matcherM.end(),
                    Spanned.SPAN_INCLUSIVE_INCLUSIVE);
            spannableString.setSpan(bss, matcherM.start(), matcherM.end(),
                    Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        }

        super.setText(spannableString);
    }

    public interface FancyTextViewCallback {

        void onClick(String data);

    }


    public abstract class NoUnderlineClickableSpan extends ClickableSpan {

        private int mColor;

        public NoUnderlineClickableSpan(int color) {
            mColor = color;
        }

        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(false);
            ds.setColor(mColor);
        }
    }

}
