package com.google.android.gms.location;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzv implements Continuation {
    private final TaskCompletionSource zza;
    private final Task zzb;

    public zzv(TaskCompletionSource taskCompletionSource, Task task) {
        this.zza = taskCompletionSource;
        this.zzb = task;
    }

    public final Object then(Task task) {
        TaskCompletionSource taskCompletionSource = this.zza;
        Task task2 = this.zzb;
        if (!task.isSuccessful()) {
            if (task.getException() != null) {
                taskCompletionSource.setException(task2.getException());
            } else {
                taskCompletionSource.trySetResult(null);
            }
        }
        return taskCompletionSource.getTask();
    }
}
