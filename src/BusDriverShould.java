import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;

@RunWith(JUnitParamsRunner.class)
public class BusDriverShould {

    private BusDriver driver;

    @Before
    public void Initialize()
    {
         driver = new BusDriver('A', 5,1,4,3);
    }

    @Test
    @Parameters({
            "5",
            "1",
            "4",
            "3"})
    public void CheckIfNextStopIsWhatTheStopWeWant(int val)
    {
        Integer expected_station = driver.NextStop();
        Assert.assertThat(expected_station, is(val));
    }
}
