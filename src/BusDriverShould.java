import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class BusDriverShould {

    BusDriver driverA;

    @Before
    public void Initialize()
    {
         driverA = new BusDriver('A', 3, 2, 1);
    }

    @Test
    public void GiveMeId0()
    {
        int id_expected = driverA.NextStop();
        Assert.assertThat(id_expected, is(3));
    }
}
