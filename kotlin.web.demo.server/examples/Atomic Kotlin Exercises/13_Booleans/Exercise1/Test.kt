import org.junit.Assert
import org.junit.Test

class TestBooleans1 {
    @Test fun testA() {
        Assert.assertFalse(a)
    }

    @Test fun testB() {
        Assert.assertTrue(b)
    }

    @Test fun testC() {
        Assert.assertTrue(c)
    }
}