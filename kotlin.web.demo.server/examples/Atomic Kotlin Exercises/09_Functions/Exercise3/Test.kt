import org.junit.Assert
import org.junit.Test

class TestFunctions3 {
    @Test fun test1() {
        Assert.assertEquals("""duplicate("abc") should return "abcabc"""",
                duplicate("abc"), "abcabc")
    }
}