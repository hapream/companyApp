package com.hapream.learn.scheduler;

/**
 * Created by zhangyanggang on 2017/9/18.
 */
public interface JobListener {
    public void beforeStatusChange(Job job, Job.Status before, Job.Status after);

    public void afterStatusChange(Job job, Job.Status before, Job.Status after);
}
