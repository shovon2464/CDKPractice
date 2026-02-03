package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Map;
import java.util.HashMap;

public class AppApp {
  public static void main(final String[] args) {
    App app = new App();

    Environment environment = Environment.builder()
        .account("905418355387") // ensure 12 digits
        .region("us-east-1")
        .build();

    Map<String, String> infraTags = new HashMap<>();
    infraTags.put("team", "FirstCloudJourney");
    infraTags.put("cost", "ECommerceInfra");

    StackProps props = StackProps.builder()
        .env(environment)
        .tags(infraTags)
        .build();

    VpcStack vpcStack = new VpcStack(app, "Vpc", props);

    app.synth();
  }
}
