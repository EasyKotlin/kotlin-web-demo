import org.junit.Assert
import org.junit.Test

class TestBooleans2 {
    @Test fun testMain() {
        main(arrayOf())
    }

    @Test fun testAnd() {
        Assert.assertEquals("and(true, true) should be true", true && true, and(true, true))
        Assert.assertEquals("and(true, false) should be false", true && false, and(true, false))
        Assert.assertEquals("and(false, true) should be false", false && true, and(false, true))
        Assert.assertEquals("and(false, false) should be false", false && false, and(false, false))
    }

    @Test fun testOr() {
        Assert.assertEquals("or(true, true) should be true", true || true, or(true, true))
        Assert.assertEquals("or(true, false) should be true", true || false, or(true, false))
        Assert.assertEquals("or(false, true) should be true", false || true, or(false, true))
        Assert.assertEquals("or(false, false) should be false", false || false, or(false, false))
    }
}