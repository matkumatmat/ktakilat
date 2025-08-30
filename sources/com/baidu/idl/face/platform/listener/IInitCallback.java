package com.baidu.idl.face.platform.listener;

public interface IInitCallback {
    void initFailure(int i, String str);

    void initSuccess();
}
