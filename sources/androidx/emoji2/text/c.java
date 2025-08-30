package androidx.emoji2.text;

import androidx.emoji2.text.FontRequestEmojiCompatConfig;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ FontRequestEmojiCompatConfig.FontRequestMetadataLoader d;

    public /* synthetic */ c(FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader, int i) {
        this.c = i;
        this.d = fontRequestMetadataLoader;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.createMetadata();
                return;
            default:
                this.d.loadInternal();
                return;
        }
    }
}
