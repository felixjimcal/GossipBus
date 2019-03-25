import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;

@RunWith(JUnitParamsRunner.class)
public class BusDriverShould {

    BusDriver driverA;

    @Before
    public void Initialize()
    {
        driverA = new BusDriver('A', 3, 4, 99, 1);
    }

    @Test
    @Parameters({
            "0,3",
            "1,4",
            "2,99",
            "3,1"})
    public void CheckIfNextStopIsWhatTheStopWeWant(int index, int val)
    {
        for(int i = 0; i < index; i++)
        {
            driverA.NextStop();
        }

        Integer expected_stop = driverA.ActualStop();
        Assert.assertThat(expected_stop, is(val));
    }
}
