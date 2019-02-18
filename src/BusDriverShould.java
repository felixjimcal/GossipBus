import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class BusDriverShould {

    @Before
    public void Initialize()
    {

    }

    @Test
    public void CheckIfNextStopIsWhatTheStopWeWant()
    {
        BusDriver driver = new BusDriver('A', 5,1,4,3);
        Integer expected_station = driver.NextStop();
        Assert.assertThat(expected_station, is(5));
    }
}
