import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class BusDriverShould {


    @Test
    public void CheckIfNextStopIsWhatTheStopWeWant(int num_expected, int result) throws Exception
    {
        BusDriver driver = new BusDriver('A', 5,1,4,3);
        Integer expected_station = driver.NextStop();
        Assert.assertThat(num_expected, is(1));
    }
}
