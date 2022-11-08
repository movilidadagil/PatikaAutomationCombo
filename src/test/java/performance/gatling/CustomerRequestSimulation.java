package performance.gatling;

import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static io.gatling.javaapi.core.CoreDsl.StringBody;
import static io.gatling.javaapi.http.HttpDsl.*;

public class CustomerRequestSimulation extends Simulation {


  Iterator<Map<String, Object>> feeder =
    Stream.generate((Supplier<Map<String, Object>>) ()
      -> Collections.singletonMap("username", UUID.randomUUID().toString())
    ).iterator();

  // Scenario
  ScenarioBuilder scn = CoreDsl.scenario("Load Test Creating Customers")
    .feed(feeder)
    .exec(http("create-customer-request")
      .post("/api/customers")
      .header("Content-Type", "application/json")
      .body(StringBody("{ \"username\": \"${username}\" }"))
      .check(status().is(201))
      .check(header("Location").saveAs("location"))
    )
    .exec(http("get-customer-request")
      .get(session -> session.getString("location"))
      .check(status().is(200))
    );

}