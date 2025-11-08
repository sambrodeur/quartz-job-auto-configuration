package com.koenig.example.quartz.job.auto.configuration.config.properties;

import java.io.Serial;
import java.io.Serializable;

public class QuartzJobProperties implements Serializable {

  @Serial
  private static final long serialVersionUID = -7955382362932394409L;

  private String className;
  private String cron;

  public QuartzJobProperties() {
    className = null;
    cron = null;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public String getCron() {
    return cron;
  }

  public void setCron(String cron) {
    this.cron = cron;
  }
}
