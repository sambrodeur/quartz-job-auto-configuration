package com.koenig.example.quartz.job.auto.configuration.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

@ConfigurationProperties(prefix = "quartz")
public class QuartzProperties implements Serializable {

  @Serial
  private static final long serialVersionUID = 922187592893828803L;

  private Map<String, QuartzJobProperties> jobs;

  public QuartzProperties() {
    jobs = null;
  }

  public Map<String, QuartzJobProperties> getJobs() {
    return jobs;
  }

  public void setJobs(Map<String, QuartzJobProperties> jobs) {
    this.jobs = jobs;
  }
}
