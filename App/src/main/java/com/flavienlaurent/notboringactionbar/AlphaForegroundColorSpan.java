package com.flavienlaurent.notboringactionbar;

import android.graphics.Color;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

public class AlphaForegroundColorSpan extends CharacterStyle implements UpdateAppearance, ParcelableSpan {

    public static final int FOREGROUND_COLOR_SPAN = 2;

    private int mColor;

	public AlphaForegroundColorSpan(int color) {
        mColor = color;
	}

    public AlphaForegroundColorSpan(Parcel src) {
        mColor = src.readInt();
    }
    
    public int getSpanTypeId() {
        return FOREGROUND_COLOR_SPAN;
    }
    
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mColor);
    }

	public int getForegroundColor() {
		return mColor;
	}

	@Override
	public void updateDrawState(TextPaint ds) {
		ds.setColor(mColor);
	}

    public void setAlpha(float alpha) {
        mColor = Color.argb((int) (alpha * 255), Color.red(mColor), Color.green(mColor), Color.blue(mColor));
    }
}