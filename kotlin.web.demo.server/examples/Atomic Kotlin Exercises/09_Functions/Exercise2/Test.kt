import org.junit.Assert
import org.junit.Test

class TestFunctions2 {
    @Test fun test1() {
        Assert.assertEquals("getSum(1.0, 2.1, 7.9) should return 10.0",
                10.0, getSum(1.0, 2.1, 6.9), 0.000001)
    }

    @Test fun test2() {
        Assert.assertEquals("getSum(0.0, 42.0, -42.0) should return 0.0",
                0.0, getSum(0.0, 42.0, -42.0), 0.000001)
    }
}