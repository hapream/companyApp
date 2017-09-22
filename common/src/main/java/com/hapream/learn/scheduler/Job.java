package com.hapream.learn.scheduler;

import java.util.Date;

/**
 * Created by zhangyanggang on 2017/9/18.
 */
public abstract class Job {
    static enum Status{
        READY, PENDING, RUNNING, FINISHED, ERROR, ABORT;
    }

    private String jobName;
    private String id;
    Date dataCreated;
    Date dateStarted;
    Date dateFinished;
    Status status;

    private String errorMessage;
    private transient Throwable throwable;
    private transient JobListener listener;


    public void setStatus(Status status){
        if (this.status == status) {
            return;
        }
        Status before = this.status;
        Status after = status;
        if (listener != null) {
            listener.beforeStatusChange(this, before, after);
        }
        this.status = status;
        if (listener != null) {
            listener.afterStatusChange(this, before, after);
        }
    }
}
