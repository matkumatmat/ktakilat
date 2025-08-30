package com.katkilat.baidu_face.manager;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.ILivenessStrategyCallback;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.baidu.idl.face.platform.manager.TimeManager;
import com.baidu.idl.face.platform.model.ImageInfo;
import com.baidu.idl.face.platform.utils.Base64Utils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.katkilat.baidu_face.R;
import com.katkilat.baidu_face.manager.FacePointManager;
import com.katkilat.baidu_face.widget.FaceDetectRoundView;
import com.ktakilat.cbase.datacollect.KtaCollect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/katkilat/baidu_face/manager/FacePointManager$initParams$2", "Lcom/baidu/idl/face/platform/ILivenessStrategyCallback;", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFacePointManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FacePointManager.kt\ncom/katkilat/baidu_face/manager/FacePointManager$initParams$2\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,563:1\n37#2:564\n36#2,3:565\n37#2:568\n36#2,3:569\n*S KotlinDebug\n*F\n+ 1 FacePointManager.kt\ncom/katkilat/baidu_face/manager/FacePointManager$initParams$2\n*L\n157#1:564\n157#1:565,3\n159#1:568\n159#1:569,3\n*E\n"})
public final class FacePointManager$initParams$2 implements ILivenessStrategyCallback {
    public final /* synthetic */ FacePointManager c;

    public FacePointManager$initParams$2(FacePointManager facePointManager) {
        this.c = facePointManager;
    }

    public final void onLivenessCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap hashMap, HashMap hashMap2, int i) {
        ImageInfo imageInfo;
        int i2;
        int i3;
        Drawable drawable;
        Intrinsics.checkNotNullParameter(faceStatusNewEnum, "status");
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        FacePointManager facePointManager = this.c;
        if (!facePointManager.p) {
            int i4 = FacePointManager.WhenMappings.f460a[faceStatusNewEnum.ordinal()];
            String str2 = null;
            Activity activity = facePointManager.f459a;
            switch (i4) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    FacePointManager.Companion.InitCall initCall = facePointManager.A;
                    if (initCall != null) {
                        initCall.c(str);
                    }
                    FacePointManager.Companion.InitCall initCall2 = facePointManager.A;
                    if (initCall2 != null) {
                        initCall2.a("");
                    }
                    FaceDetectRoundView faceDetectRoundView = facePointManager.c;
                    if (faceDetectRoundView != null) {
                        FaceConfig faceConfig = facePointManager.k;
                        if (faceConfig != null) {
                            faceDetectRoundView.setProcessCount(i, faceConfig.getLivenessTypeList().size());
                            facePointManager.h();
                            break;
                        } else {
                            Intrinsics.k("mFaceConfig");
                            throw null;
                        }
                    } else {
                        Intrinsics.k("mFaceRoundView");
                        throw null;
                    }
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    FacePointManager.Companion.InitCall initCall3 = facePointManager.A;
                    if (initCall3 != null) {
                        initCall3.c(str);
                    }
                    FacePointManager.Companion.InitCall initCall4 = facePointManager.A;
                    if (initCall4 != null) {
                        initCall4.a("");
                    }
                    FaceDetectRoundView faceDetectRoundView2 = facePointManager.c;
                    if (faceDetectRoundView2 != null) {
                        FaceConfig faceConfig2 = facePointManager.k;
                        if (faceConfig2 != null) {
                            faceDetectRoundView2.setProcessCount(i, faceConfig2.getLivenessTypeList().size());
                            break;
                        } else {
                            Intrinsics.k("mFaceConfig");
                            throw null;
                        }
                    } else {
                        Intrinsics.k("mFaceRoundView");
                        throw null;
                    }
                case 14:
                case 15:
                case 16:
                case 17:
                    FacePointManager.Companion.InitCall initCall5 = facePointManager.A;
                    if (initCall5 != null) {
                        initCall5.c(activity.getString(R.string.liveness_tip));
                    }
                    FacePointManager.Companion.InitCall initCall6 = facePointManager.A;
                    if (initCall6 != null) {
                        initCall6.a(str);
                    }
                    FaceDetectRoundView faceDetectRoundView3 = facePointManager.c;
                    if (faceDetectRoundView3 != null) {
                        FaceConfig faceConfig3 = facePointManager.k;
                        if (faceConfig3 != null) {
                            faceDetectRoundView3.setProcessCount(i, faceConfig3.getLivenessTypeList().size());
                            break;
                        } else {
                            Intrinsics.k("mFaceConfig");
                            throw null;
                        }
                    } else {
                        Intrinsics.k("mFaceRoundView");
                        throw null;
                    }
                case 18:
                    FaceDetectRoundView faceDetectRoundView4 = facePointManager.c;
                    if (faceDetectRoundView4 != null) {
                        FaceConfig faceConfig4 = facePointManager.k;
                        if (faceConfig4 != null) {
                            faceDetectRoundView4.setProcessCount(i, faceConfig4.getLivenessTypeList().size());
                            RelativeLayout relativeLayout = facePointManager.d;
                            if (relativeLayout != null) {
                                if (relativeLayout.getVisibility() == 4) {
                                    RelativeLayout relativeLayout2 = facePointManager.d;
                                    if (relativeLayout2 != null) {
                                        relativeLayout2.setVisibility(0);
                                    } else {
                                        Intrinsics.k("mAddIvLayout");
                                        throw null;
                                    }
                                }
                                LivenessTypeEnum livenessTypeEnum = facePointManager.z;
                                if (livenessTypeEnum != null) {
                                    switch (FacePointManager.WhenMappings.b[livenessTypeEnum.ordinal()]) {
                                        case 1:
                                            ImageView imageView = facePointManager.g;
                                            if (imageView != null) {
                                                imageView.setBackgroundResource(R.drawable.anim_eye);
                                                break;
                                            }
                                            break;
                                        case 2:
                                            ImageView imageView2 = facePointManager.g;
                                            if (imageView2 != null) {
                                                imageView2.setBackgroundResource(R.drawable.anim_left);
                                                break;
                                            }
                                            break;
                                        case 3:
                                            ImageView imageView3 = facePointManager.g;
                                            if (imageView3 != null) {
                                                imageView3.setBackgroundResource(R.drawable.anim_right);
                                                break;
                                            }
                                            break;
                                        case 4:
                                            ImageView imageView4 = facePointManager.g;
                                            if (imageView4 != null) {
                                                imageView4.setBackgroundResource(R.drawable.anim_down);
                                                break;
                                            }
                                            break;
                                        case 5:
                                            ImageView imageView5 = facePointManager.g;
                                            if (imageView5 != null) {
                                                imageView5.setBackgroundResource(R.drawable.anim_up);
                                                break;
                                            }
                                            break;
                                        case 6:
                                            ImageView imageView6 = facePointManager.g;
                                            if (imageView6 != null) {
                                                imageView6.setBackgroundResource(R.drawable.anim_mouth);
                                                break;
                                            }
                                            break;
                                    }
                                    ImageView imageView7 = facePointManager.g;
                                    if (imageView7 != null) {
                                        drawable = imageView7.getBackground();
                                    } else {
                                        drawable = null;
                                    }
                                    Intrinsics.d(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                                    AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
                                    facePointManager.y = animationDrawable;
                                    animationDrawable.start();
                                }
                                AnimationDrawable animationDrawable2 = facePointManager.y;
                                if (animationDrawable2 != null) {
                                    i2 = animationDrawable2.getNumberOfFrames();
                                } else {
                                    i2 = 0;
                                }
                                int i5 = 0;
                                for (int i6 = 0; i6 < i2; i6++) {
                                    AnimationDrawable animationDrawable3 = facePointManager.y;
                                    if (animationDrawable3 != null) {
                                        i3 = animationDrawable3.getDuration(i6);
                                    } else {
                                        i3 = 0;
                                    }
                                    i5 += i3;
                                }
                                TimeManager.getInstance().setActiveAnimTime(i5);
                                break;
                            } else {
                                Intrinsics.k("mAddIvLayout");
                                throw null;
                            }
                        } else {
                            Intrinsics.k("mFaceConfig");
                            throw null;
                        }
                    } else {
                        Intrinsics.k("mFaceRoundView");
                        throw null;
                    }
                default:
                    FacePointManager.Companion.InitCall initCall7 = facePointManager.A;
                    if (initCall7 != null) {
                        initCall7.c(activity.getString(R.string.liveness_tip));
                    }
                    FacePointManager.Companion.InitCall initCall8 = facePointManager.A;
                    if (initCall8 != null) {
                        initCall8.a(str);
                    }
                    FaceDetectRoundView faceDetectRoundView5 = facePointManager.c;
                    if (faceDetectRoundView5 != null) {
                        FaceConfig faceConfig5 = facePointManager.k;
                        if (faceConfig5 != null) {
                            faceDetectRoundView5.setProcessCount(i, faceConfig5.getLivenessTypeList().size());
                            break;
                        } else {
                            Intrinsics.k("mFaceConfig");
                            throw null;
                        }
                    } else {
                        Intrinsics.k("mFaceRoundView");
                        throw null;
                    }
            }
            if (faceStatusNewEnum == FaceStatusNewEnum.OK) {
                facePointManager.p = true;
                if (hashMap != null && hashMap.size() > 0) {
                    ArrayList arrayList = new ArrayList(hashMap.entrySet());
                    Collections.sort(arrayList, new a7(new e3(5), 0));
                    ImageInfo imageInfo2 = (ImageInfo) ((Map.Entry) arrayList.get(0)).getValue();
                    if (imageInfo2 != null) {
                        str2 = imageInfo2.getBase64();
                    }
                    if (!(hashMap2 == null || (imageInfo = (ImageInfo) hashMap2.get(((Map.Entry) arrayList.get(0)).getKey())) == null)) {
                        imageInfo.getBase64();
                    }
                }
                KtaCollect.n_face_result(AppEventsConstants.EVENT_PARAM_VALUE_YES);
                FacePointManager.Companion.InitCall initCall9 = facePointManager.A;
                if (initCall9 != null) {
                    byte[] decode = Base64Utils.decode(str2, 2);
                    Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
                    initCall9.d(decode);
                }
            } else if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
                KtaCollect.n_face_result(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                FacePointManager.Companion.InitCall initCall10 = facePointManager.A;
                if (initCall10 != null) {
                    initCall10.b();
                }
            }
        }
    }
}
