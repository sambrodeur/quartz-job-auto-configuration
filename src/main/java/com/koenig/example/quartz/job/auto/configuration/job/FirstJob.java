package com.koenig.example.quartz.job.auto.configuration.job;

import com.koenig.example.quartz.job.auto.configuration.config.properties.QuartzProperties;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FirstJob implements Job {

  private static final Logger LOG = LoggerFactory.getLogger(FirstJob.class);

  private final QuartzProperties quartzProperties;

  public FirstJob(QuartzProperties quartzProperties) {
    this.quartzProperties = quartzProperties;
  }

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    LOG.info("First job is running");
    LOG.info("First job is completed");
  }
}
