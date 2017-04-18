import org.junit.Assert
import org.junit.Test

class TestNumberTypes4 {
    @Test fun test1() {
        Assert.assertEquals("One hour and a half is 5_400_000 milliseconds",
                5_400_000, convertTime(1, 30, 0))
    }

    @Test fun test2() {
        Assert.assertEquals("One billion hours is 3_600_000_000_000_000 milliseconds " +
                "(note that only Long variable can store this value)",
                3_600_000_000_000_000, convertTime(1_000_000_000, 0, 0))
    }
}