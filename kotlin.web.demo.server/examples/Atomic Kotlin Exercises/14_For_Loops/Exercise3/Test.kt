import org.junit.Assert
import org.junit.Test

class TestSumOfEven {
    @Test fun test1() {
        Assert.assertEquals("sumOfEven(1) should be 0",
                0, sumOfEven(1))
    }

    @Test fun test3() {
        Assert.assertEquals("sumOfEven(2) should be 2",
                2, sumOfEven(2))
    }

    @Test fun test10() {
        Assert.assertEquals("sumOfEven(4) should be 6",
                6, sumOfEven(4))
    }

    @Test fun test20() {
        Assert.assertEquals("sumOfEven(20) should be 110",
                110, sumOfEven(20))
    }

    @Test fun test21() {
        Assert.assertEquals("sumOfEven(21) should be 110",
                110, sumOfEven(21))
    }
}