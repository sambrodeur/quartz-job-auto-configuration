package com.koenig.example.quartz.job.auto.configuration.config;

import com.koenig.example.quartz.job.auto.configuration.config.properties.QuartzProperties;
import jakarta.annotation.PostConstruct;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzJobConfiguration {

  private static final Logger LOG = LoggerFactory.getLogger(QuartzJobConfiguration.class);

  private final QuartzProperties quartzProperties;
  private final Scheduler scheduler;

  public QuartzJobConfiguration(QuartzProperties quartzProperties, Scheduler scheduler) {
    this.quartzProperties = quartzProperties;
    this.scheduler = scheduler;
  }

  @PostConstruct
  public void scheduleJobs() {
    LOG.info("Initializing scheduler with job details and trigger");

    quartzProperties.getJobs().forEach((jobName, quartzJobProperties) -> {
      String jobClassName = quartzJobProperties.getClassName();
      String jobCron = quartzJobProperties.getCron();

      Class<? extends Job> jobClass;
      try {
        jobClass = (Class<? extends Job>) Class.forName(jobClassName);
      } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
      }

      LOG.info("Creation of job detail : {}", jobName);

      JobDetail jobDetail = JobBuilder.newJob(jobClass)
        .withIdentity(jobName)
        .storeDurably()
        .build();

      LOG.info("Creation of job trigger : {}", jobName);

      Trigger jobTrigger = TriggerBuilder.newTrigger()
        .forJob(jobDetail)
        .withIdentity(jobName + "Trigger")
        .withSchedule(CronScheduleBuilder.cronSchedule(jobCron))
        .build();

      try {
        scheduler.scheduleJob(jobDetail, jobTrigger);
      } catch (SchedulerException e) {
        throw new RuntimeException(e);
      }
    });
  }
}
