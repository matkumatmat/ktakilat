package io.reactivex;

public interface ObservableTransformer<Upstream, Downstream> {
    ObservableSource a(Observable observable);
}
