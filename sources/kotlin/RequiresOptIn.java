package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.enums.EnumEntries;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.3")
@Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Retention(AnnotationRetention.BINARY)
@java.lang.annotation.Target({ElementType.ANNOTATION_TYPE})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0014\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006R\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\t"}, d2 = {"Lkotlin/RequiresOptIn;", "", "message", "", "level", "Lkotlin/RequiresOptIn$Level;", "()Ljava/lang/String;", "()Lkotlin/RequiresOptIn$Level;", "Level", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
public @interface RequiresOptIn {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/RequiresOptIn$Level;", "", "WARNING", "ERROR", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum Level {
        ;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: kotlin.RequiresOptIn$Level[]} */
        /* JADX WARNING: type inference failed for: r2v0, types: [kotlin.RequiresOptIn$Level, java.lang.Enum] */
        /* JADX WARNING: type inference failed for: r3v1, types: [kotlin.RequiresOptIn$Level, java.lang.Enum] */
        /* JADX WARNING: Multi-variable type inference failed */
        static {
            /*
                r0 = 1
                r1 = 0
                kotlin.RequiresOptIn$Level r2 = new kotlin.RequiresOptIn$Level
                java.lang.String r3 = "WARNING"
                r2.<init>(r3, r1)
                WARNING = r2
                kotlin.RequiresOptIn$Level r3 = new kotlin.RequiresOptIn$Level
                java.lang.String r4 = "ERROR"
                r3.<init>(r4, r0)
                ERROR = r3
                r4 = 2
                kotlin.RequiresOptIn$Level[] r4 = new kotlin.RequiresOptIn.Level[r4]
                r4[r1] = r2
                r4[r0] = r3
                c = r4
                kotlin.enums.EnumEntries r0 = kotlin.enums.EnumEntriesKt.a(r4)
                d = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.RequiresOptIn.Level.<clinit>():void");
        }

        @NotNull
        public static EnumEntries<Level> getEntries() {
            return d;
        }
    }

    Level level() default Level.ERROR;

    String message() default "";
}
