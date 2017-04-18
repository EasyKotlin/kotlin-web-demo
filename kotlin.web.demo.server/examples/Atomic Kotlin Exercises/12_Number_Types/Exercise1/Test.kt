import org.junit.Assert
import org.junit.Test

class TestNumberTypes1 {
    @Test fun testA() {
        Assert.assertEquals(3, a)
    }

    @Test fun testB() {
        Assert.assertEquals(2, b)
    }

    @Test fun testC() {
        Assert.assertEquals(11, c)
    }

    @Test fun testD() {
        Assert.assertEquals(1.2, d, 0.0001)
    }
}