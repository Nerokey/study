package com.lsl.study.test;

import com.lsl.study.core.quartz.job.MyJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class TestQuartz {

    public static void main(String[] args) throws SchedulerException {
        testCronTrigger();
    }

    public static void testCronTrigger() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // 定义trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger", "group")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * * * ?"))
                .build();

        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("jobName", "jobGroup")
                .usingJobData("data", "value")
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }

    public static void testSimpleTrigger() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // 定义trigger
        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger", "group")
                .startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();

        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("jobName", "jobGroup")
                .usingJobData("data", "value")
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }


}
