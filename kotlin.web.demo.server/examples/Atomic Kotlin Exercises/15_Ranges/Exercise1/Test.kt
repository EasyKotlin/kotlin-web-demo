import org.junit.Assert
import org.junit.Test

class TestAlphabet {
    @Test fun test1() {
        Assert.assertEquals("abcdefghijklmnopqrstuvwxyz", getAlphabet())
    }
}