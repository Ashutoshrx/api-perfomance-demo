package com.jarvis.api_performance._demo.utility;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Delayer {
  public static void addDelay() {
    try {
      //Adding delay for downgrading performance.
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
