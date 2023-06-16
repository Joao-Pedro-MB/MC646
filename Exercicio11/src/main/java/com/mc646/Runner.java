package com.mc646;

import com.mc646.BoundedQueueTest;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;

import java.io.IOException;

public class Runner {
  public static void main(String[] args) throws IOException {
    TestExecutor executor = new TestExecutor(
      BoundedQueueTest.class
    );

    Result result = executor.execute(true);
    System.out.println("Done: [" + result.getResults().toString(2) + "]");
  }
}
