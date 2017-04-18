import org.junit.Assert
import org.junit.Test

class TestIfExpressions1 {
    @Test fun testPositive() {
        Assert.assertEquals("""checkSign(10) should return "positive"""",
                "positive", checkSign(10))
    }

    @Test fun testZero() {
        Assert.assertEquals("""checkSign(0) should return "zero"""",
                "zero", checkSign(0))
    }

    @Test fun testNegative() {
        Assert.assertEquals("""checkSign(-10) should return "negative"""",
                "negative", checkSign(-10))
    }
}