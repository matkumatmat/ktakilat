package defpackage;

import android.view.View;
import android.widget.ImageView;
import com.baidu.idl.face.platform.ILivenessStrategy;
import com.katkilat.baidu_face.BaseLivenessBaiduActivity;
import com.katkilat.baidu_face.R;

/* renamed from: w0  reason: default package */
public final /* synthetic */ class w0 implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ BaseLivenessBaiduActivity d;

    public /* synthetic */ w0(BaseLivenessBaiduActivity baseLivenessBaiduActivity, int i) {
        this.c = i;
        this.d = baseLivenessBaiduActivity;
    }

    public final void onClick(View view) {
        int i;
        switch (this.c) {
            case 0:
                int i2 = BaseLivenessBaiduActivity.E;
                this.d.onBackPressed();
                return;
            default:
                BaseLivenessBaiduActivity baseLivenessBaiduActivity = this.d;
                baseLivenessBaiduActivity.r = !baseLivenessBaiduActivity.r;
                ImageView imageView = baseLivenessBaiduActivity.z().soundImage;
                if (baseLivenessBaiduActivity.r) {
                    i = R.mipmap.icon_titlebar_voice2;
                } else {
                    i = R.drawable.collect_image_voice_selector;
                }
                imageView.setImageResource(i);
                ILivenessStrategy iLivenessStrategy = baseLivenessBaiduActivity.o;
                if (iLivenessStrategy != null) {
                    iLivenessStrategy.setLivenessStrategySoundEnable(baseLivenessBaiduActivity.r);
                    return;
                }
                return;
        }
    }
}
