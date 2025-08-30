package com.appsflyer.internal;

import android.annotation.SuppressLint;
import com.appsflyer.internal.AFe1tSDK;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class AFe1uSDK {
    @NotNull
    public final AFc1qSDK AFAdRevenueData;
    @NotNull
    private final AFe1lSDK component3;
    @NotNull
    private final AFf1gSDK component4;
    @NotNull
    private final AFg1qSDK getCurrencyIso4217Code;
    @NotNull
    private final ExecutorService getMediationNetwork;
    @NotNull
    private final AFc1pSDK getMonetizationNetwork;
    @NotNull
    public final AFc1iSDK getRevenue;

    public AFe1uSDK(@NotNull AFc1qSDK aFc1qSDK, @NotNull AFc1iSDK aFc1iSDK, @NotNull AFc1pSDK aFc1pSDK, @NotNull ExecutorService executorService, @NotNull AFg1qSDK aFg1qSDK, @NotNull AFf1gSDK aFf1gSDK, @NotNull AFe1lSDK aFe1lSDK) {
        Intrinsics.checkNotNullParameter(aFc1qSDK, "");
        Intrinsics.checkNotNullParameter(aFc1iSDK, "");
        Intrinsics.checkNotNullParameter(aFc1pSDK, "");
        Intrinsics.checkNotNullParameter(executorService, "");
        Intrinsics.checkNotNullParameter(aFg1qSDK, "");
        Intrinsics.checkNotNullParameter(aFf1gSDK, "");
        Intrinsics.checkNotNullParameter(aFe1lSDK, "");
        this.AFAdRevenueData = aFc1qSDK;
        this.getRevenue = aFc1iSDK;
        this.getMonetizationNetwork = aFc1pSDK;
        this.getMediationNetwork = executorService;
        this.getCurrencyIso4217Code = aFg1qSDK;
        this.component4 = aFf1gSDK;
        this.component3 = aFe1lSDK;
    }

    @SuppressLint({"NewApi"})
    public final void getMediationNetwork(@NotNull AFe1tSDK aFe1tSDK, @NotNull Function1<? super AFe1rSDK, Unit> function1) {
        Intrinsics.checkNotNullParameter(aFe1tSDK, "");
        Intrinsics.checkNotNullParameter(function1, "");
        AFf1zSDK aFf1zSDK = new AFf1zSDK(aFe1tSDK, this.getMediationNetwork, this.getMonetizationNetwork, this.getRevenue, this.getCurrencyIso4217Code, this.component4, function1);
        AFe1lSDK aFe1lSDK = this.component3;
        aFe1lSDK.getRevenue.execute(new Runnable(aFf1zSDK) {
            private /* synthetic */ AFe1sSDK getMonetizationNetwork;

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run(
/*
Method generation error in method: com.appsflyer.internal.AFe1lSDK.5.run():void, dex: classes.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.appsflyer.internal.AFe1lSDK.5.run():void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/
        });
    }

    @SuppressLint({"NewApi"})
    public final void getRevenue() {
        if (!this.AFAdRevenueData.getMediationNetwork("didSendRevenueTriggerOnLastBackground", true) && AFj1iSDK.getRevenue(this.getRevenue.getMonetizationNetwork)) {
            getMediationNetwork(AFe1tSDK.AFa1uSDK.INSTANCE, new Function1<AFe1rSDK, Unit>(this) {
                private /* synthetic */ AFe1uSDK getRevenue;

                {
                    this.getRevenue = r1;
                }

                public final void getRevenue(@NotNull AFe1rSDK aFe1rSDK) {
                    Intrinsics.checkNotNullParameter(aFe1rSDK, "");
                    if (aFe1rSDK == AFe1rSDK.SUCCESS) {
                        this.getRevenue.AFAdRevenueData.getCurrencyIso4217Code("didSendRevenueTriggerOnLastBackground", true);
                    }
                }

                public final /* synthetic */ Object invoke(Object obj) {
                    getRevenue((AFe1rSDK) obj);
                    return Unit.f696a;
                }
            });
        }
    }
}
