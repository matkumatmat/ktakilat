package com.google.firebase.components;

import java.util.List;

public interface ComponentRegistrarProcessor {
    public static final ComponentRegistrarProcessor NOOP = new x2(2);

    List<Component<?>> processRegistrar(ComponentRegistrar componentRegistrar);
}
