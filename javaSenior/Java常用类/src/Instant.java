import org.junit.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Instant {
    @Test
    public void testInstant(){
        //Instant类的使用，类似于Date类
        java.time.Instant instant= java.time.Instant.now();
        System.out.println(instant);
        OffsetDateTime offsetDateTime=instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
    }
}
