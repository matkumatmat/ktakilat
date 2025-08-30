package com.google.firebase.sessions;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/google/firebase/sessions/UuidGeneratorImpl;", "Lcom/google/firebase/sessions/UuidGenerator;", "()V", "next", "Ljava/util/UUID;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UuidGeneratorImpl implements UuidGenerator {
    @NotNull
    public static final UuidGeneratorImpl INSTANCE = new UuidGeneratorImpl();

    private UuidGeneratorImpl() {
    }

    @NotNull
    public UUID next() {
        UUID randomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(randomUUID, "randomUUID()");
        return randomUUID;
    }
}
