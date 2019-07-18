package com.mongobee.mongobee.configuration;

import com.github.mongobee.Mongobee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MongoBeeConfig {
  @Bean
  @Autowired
  public Mongobee mongobee(Environment environment) {
    Mongobee runner = new Mongobee("mongodb://localhost:27017/mongobee");
    runner.setSpringEnvironment(environment);
    runner.setChangeLogsScanPackage(
        "com.mongobee.mongobee.changelogs"); // the package to be scanned for changesets
    return runner;
  }
}
