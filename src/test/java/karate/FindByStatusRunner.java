package karate;

import com.intuit.karate.junit5.Karate;

public class FindByStatusRunner {
    @Karate.Test
    Karate testFindByStatus() {
        return Karate.run("findbystatus").relativeTo(getClass());
    }
}
