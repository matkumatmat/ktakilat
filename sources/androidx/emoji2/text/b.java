package androidx.emoji2.text;

import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer;
import java.util.concurrent.ThreadPoolExecutor;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ EmojiCompatInitializer.BackgroundDefaultLoader c;
    public final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback d;
    public final /* synthetic */ ThreadPoolExecutor e;

    public /* synthetic */ b(EmojiCompatInitializer.BackgroundDefaultLoader backgroundDefaultLoader, EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
        this.c = backgroundDefaultLoader;
        this.d = metadataRepoLoaderCallback;
        this.e = threadPoolExecutor;
    }

    public final void run() {
        this.c.lambda$load$0(this.d, this.e);
    }
}
