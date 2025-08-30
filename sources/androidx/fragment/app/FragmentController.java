package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FragmentController {
    private final FragmentHostCallback<?> mHost;

    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.mHost = fragmentHostCallback;
    }

    @NonNull
    public static FragmentController createController(@NonNull FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController((FragmentHostCallback) Preconditions.checkNotNull(fragmentHostCallback, "callbacks == null"));
    }

    public void attachHost(@Nullable Fragment fragment) {
        FragmentManager fragmentManager = this.mHost.getFragmentManager();
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        fragmentManager.attachController(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    public void dispatchActivityCreated() {
        this.mHost.getFragmentManager().dispatchActivityCreated();
    }

    @Deprecated
    public void dispatchConfigurationChanged(@NonNull Configuration configuration) {
        this.mHost.getFragmentManager().dispatchConfigurationChanged(configuration, true);
    }

    public boolean dispatchContextItemSelected(@NonNull MenuItem menuItem) {
        return this.mHost.getFragmentManager().dispatchContextItemSelected(menuItem);
    }

    public void dispatchCreate() {
        this.mHost.getFragmentManager().dispatchCreate();
    }

    @Deprecated
    public boolean dispatchCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        return this.mHost.getFragmentManager().dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public void dispatchDestroy() {
        this.mHost.getFragmentManager().dispatchDestroy();
    }

    public void dispatchDestroyView() {
        this.mHost.getFragmentManager().dispatchDestroyView();
    }

    @Deprecated
    public void dispatchLowMemory() {
        this.mHost.getFragmentManager().dispatchLowMemory(true);
    }

    @Deprecated
    public void dispatchMultiWindowModeChanged(boolean z) {
        this.mHost.getFragmentManager().dispatchMultiWindowModeChanged(z, true);
    }

    @Deprecated
    public boolean dispatchOptionsItemSelected(@NonNull MenuItem menuItem) {
        return this.mHost.getFragmentManager().dispatchOptionsItemSelected(menuItem);
    }

    @Deprecated
    public void dispatchOptionsMenuClosed(@NonNull Menu menu) {
        this.mHost.getFragmentManager().dispatchOptionsMenuClosed(menu);
    }

    public void dispatchPause() {
        this.mHost.getFragmentManager().dispatchPause();
    }

    @Deprecated
    public void dispatchPictureInPictureModeChanged(boolean z) {
        this.mHost.getFragmentManager().dispatchPictureInPictureModeChanged(z, true);
    }

    @Deprecated
    public boolean dispatchPrepareOptionsMenu(@NonNull Menu menu) {
        return this.mHost.getFragmentManager().dispatchPrepareOptionsMenu(menu);
    }

    @Deprecated
    public void dispatchReallyStop() {
    }

    public void dispatchResume() {
        this.mHost.getFragmentManager().dispatchResume();
    }

    public void dispatchStart() {
        this.mHost.getFragmentManager().dispatchStart();
    }

    public void dispatchStop() {
        this.mHost.getFragmentManager().dispatchStop();
    }

    @Deprecated
    public void doLoaderDestroy() {
    }

    @Deprecated
    public void doLoaderRetain() {
    }

    @Deprecated
    public void doLoaderStart() {
    }

    @Deprecated
    public void doLoaderStop(boolean z) {
    }

    @Deprecated
    public void dumpLoaders(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
    }

    public boolean execPendingActions() {
        return this.mHost.getFragmentManager().execPendingActions(true);
    }

    @Nullable
    public Fragment findFragmentByWho(@NonNull String str) {
        return this.mHost.getFragmentManager().findFragmentByWho(str);
    }

    @NonNull
    public List<Fragment> getActiveFragments(@SuppressLint({"UnknownNullness"}) List<Fragment> list) {
        return this.mHost.getFragmentManager().getActiveFragments();
    }

    public int getActiveFragmentsCount() {
        return this.mHost.getFragmentManager().getActiveFragmentCount();
    }

    @NonNull
    public FragmentManager getSupportFragmentManager() {
        return this.mHost.getFragmentManager();
    }

    @SuppressLint({"UnknownNullness"})
    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void noteStateNotSaved() {
        this.mHost.getFragmentManager().noteStateNotSaved();
    }

    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return this.mHost.getFragmentManager().getLayoutInflaterFactory().onCreateView(view, str, context, attributeSet);
    }

    @Deprecated
    public void reportLoaderStart() {
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable parcelable, @Nullable List<Fragment> list) {
        this.mHost.getFragmentManager().restoreAllState(parcelable, new FragmentManagerNonConfig(list, (Map<String, FragmentManagerNonConfig>) null, (Map<String, ViewModelStore>) null));
    }

    @Deprecated
    public void restoreLoaderNonConfig(@SuppressLint({"UnknownNullness"}) SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
    }

    @Deprecated
    public void restoreSaveState(@Nullable Parcelable parcelable) {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback instanceof ViewModelStoreOwner) {
            fragmentHostCallback.getFragmentManager().restoreSaveState(parcelable);
            return;
        }
        throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
    }

    @Deprecated
    @Nullable
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return null;
    }

    @Deprecated
    @Nullable
    public FragmentManagerNonConfig retainNestedNonConfig() {
        return this.mHost.getFragmentManager().retainNonConfig();
    }

    @Deprecated
    @Nullable
    public List<Fragment> retainNonConfig() {
        FragmentManagerNonConfig retainNonConfig = this.mHost.getFragmentManager().retainNonConfig();
        if (retainNonConfig == null || retainNonConfig.getFragments() == null) {
            return null;
        }
        return new ArrayList(retainNonConfig.getFragments());
    }

    @Deprecated
    @Nullable
    public Parcelable saveAllState() {
        return this.mHost.getFragmentManager().saveAllState();
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable parcelable, @Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.mHost.getFragmentManager().restoreAllState(parcelable, fragmentManagerNonConfig);
    }
}
