import org.junit.Assert
import org.junit.Test

class TestFunctions1 {
    @Test fun test1() {
        Assert.assertEquals("getSquare(5) should return 25",
                25, getSquare(5))
    }

    @Test fun test2() {
        Assert.assertEquals("getSquare(-3) should return 9",
                9, getSquare(-3))
    }
}