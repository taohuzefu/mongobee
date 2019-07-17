package com.mongobee.mongobee.configuration;

import com.github.mongobee.Mongobee;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order
@Component
public class MongoBeeConfig {
  @Bean
  public Mongobee mongobee() {
    Mongobee runner = new Mongobee("mongodb://localhost:27017/mongobee");
    runner.setChangeLogsScanPackage(
        "com.mongobee.mongobee.changelogs"); // the package to be scanned for changesets

    return runner;
  }
}
