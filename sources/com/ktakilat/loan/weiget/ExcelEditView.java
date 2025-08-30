package com.ktakilat.loan.weiget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.AppEventsConstants;

public class ExcelEditView extends AppCompatEditText {
    public int c = 6;
    public int d = ViewCompat.MEASURED_STATE_MASK;
    public boolean e = false;
    public float f = 0.0f;
    public int g = 0;

    public ExcelEditView(Context context) {
        super(context);
        addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ExcelEditView excelEditView = ExcelEditView.this;
                Editable text = excelEditView.getText();
                int length = text.length();
                int i4 = excelEditView.g;
                if (i4 > 0 && length > excelEditView.c * i4) {
                    int selectionEnd = Selection.getSelectionEnd(text);
                    excelEditView.setText(text.toString().substring(0, excelEditView.c * excelEditView.g));
                    Editable text2 = excelEditView.getText();
                    if (selectionEnd > text2.length()) {
                        selectionEnd = text2.length();
                    }
                    Selection.setSelection(text2, selectionEnd);
                }
            }
        });
    }

    public final void onDraw(Canvas canvas) {
        char[] charArray = getText().toString().toCharArray();
        int length = ((charArray.length - 1) / this.c) + 1;
        int i = this.g;
        if (i > 0 && length > i) {
            length = i;
        }
        if (this.e) {
            for (int i2 = 0; i2 < charArray.length; i2++) {
                charArray[i2] = '*';
            }
        }
        if (this.f == 0.0f) {
            this.f = (float) getHeight();
        }
        float f2 = this.f * ((float) length);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = (int) f2;
        setLayoutParams(layoutParams);
        float width = ((float) getWidth()) / ((float) this.c);
        float f3 = f2 / ((float) (length + 1));
        Paint paint = new Paint(257);
        paint.setColor(this.d);
        paint.setTextSize(getTextSize());
        paint.setTypeface(getTypeface());
        paint.setTextAlign(Paint.Align.CENTER);
        Rect rect = new Rect();
        paint.getTextBounds(AppEventsConstants.EVENT_PARAM_VALUE_YES, 0, 1, rect);
        float f4 = (float) (rect.bottom - rect.top);
        rect.right = rect.left;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = 0;
            while (true) {
                int i5 = this.c;
                if (i4 >= i5 || charArray.length <= (i3 * i5) + i4) {
                } else {
                    i4++;
                    canvas.drawText(String.valueOf(charArray[(i5 * i3) + i4]), (((float) i4) * width) - (width / 2.0f), (f4 / 2.0f) + (((float) (i3 + 1)) * f3), paint);
                }
            }
        }
    }

    public void setIsPassword(boolean z) {
        this.e = z;
    }

    public void setTextColor(int i) {
        super.setTextColor(i);
        this.d = i;
    }

    public void setmMaxLength(int i) {
        this.c = i;
    }

    public void setmMaxLine(int i) {
        this.g = i;
    }

    public ExcelEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ExcelEditView excelEditView = ExcelEditView.this;
                Editable text = excelEditView.getText();
                int length = text.length();
                int i4 = excelEditView.g;
                if (i4 > 0 && length > excelEditView.c * i4) {
                    int selectionEnd = Selection.getSelectionEnd(text);
                    excelEditView.setText(text.toString().substring(0, excelEditView.c * excelEditView.g));
                    Editable text2 = excelEditView.getText();
                    if (selectionEnd > text2.length()) {
                        selectionEnd = text2.length();
                    }
                    Selection.setSelection(text2, selectionEnd);
                }
            }
        });
    }
}
