package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AnimationUtilsCompat {
    private AnimationUtilsCompat() {
    }

    @NonNull
    private static Interpolator createInterpolatorFromXml(@NonNull Context context, @NonNull XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Interpolator pathInterpolatorCompat;
        int depth = xmlPullParser.getDepth();
        Interpolator interpolator = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
                    String name = xmlPullParser.getName();
                    name.getClass();
                    char c = 65535;
                    switch (name.hashCode()) {
                        case -2140409460:
                            if (name.equals("pathInterpolator")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -2120889007:
                            if (name.equals("anticipateInterpolator")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1248486260:
                            if (name.equals("linearInterpolator")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -935873468:
                            if (name.equals("accelerateInterpolator")) {
                                c = 3;
                                break;
                            }
                            break;
                        case -425326737:
                            if (name.equals("bounceInterpolator")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 1192587314:
                            if (name.equals("overshootInterpolator")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 1472030440:
                            if (name.equals("anticipateOvershootInterpolator")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 1962594083:
                            if (name.equals("decelerateInterpolator")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 2019672672:
                            if (name.equals("accelerateDecelerateInterpolator")) {
                                c = 8;
                                break;
                            }
                            break;
                        case 2038238413:
                            if (name.equals("cycleInterpolator")) {
                                c = 9;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            pathInterpolatorCompat = new PathInterpolatorCompat(context, asAttributeSet, xmlPullParser);
                            break;
                        case 1:
                            pathInterpolatorCompat = new AnticipateInterpolator(context, asAttributeSet);
                            break;
                        case 2:
                            interpolator = new LinearInterpolator();
                            continue;
                        case 3:
                            pathInterpolatorCompat = new AccelerateInterpolator(context, asAttributeSet);
                            break;
                        case 4:
                            interpolator = new BounceInterpolator();
                            continue;
                        case 5:
                            pathInterpolatorCompat = new OvershootInterpolator(context, asAttributeSet);
                            break;
                        case 6:
                            pathInterpolatorCompat = new AnticipateOvershootInterpolator(context, asAttributeSet);
                            break;
                        case 7:
                            pathInterpolatorCompat = new DecelerateInterpolator(context, asAttributeSet);
                            break;
                        case 8:
                            interpolator = new AccelerateDecelerateInterpolator();
                            continue;
                        case 9:
                            pathInterpolatorCompat = new CycleInterpolator(context, asAttributeSet);
                            break;
                        default:
                            throw new RuntimeException("Unknown interpolator name: " + xmlPullParser.getName());
                    }
                    interpolator = pathInterpolatorCompat;
                }
            }
        }
        if (interpolator != null) {
            return interpolator;
        }
        throw new RuntimeException("Failed to parse interpolator, no start tag found");
    }

    @NonNull
    public static Interpolator loadInterpolator(@NonNull Context context, @AnimRes int i) throws Resources.NotFoundException {
        Interpolator loadInterpolator = AnimationUtils.loadInterpolator(context, i);
        ObjectsCompat.requireNonNull(loadInterpolator, "Failed to parse interpolator, no start tag found");
        return loadInterpolator;
    }
}
