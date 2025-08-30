package io.reactivex;

public interface ObservableOperator<Downstream, Upstream> {
    Observer apply();
}
