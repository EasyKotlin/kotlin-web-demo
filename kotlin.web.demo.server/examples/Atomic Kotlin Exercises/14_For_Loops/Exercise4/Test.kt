import org.junit.Assert
import org.junit.Test

class TestForLoops3 {
    @Test fun testLowerCaseC() {
        Assert.assertTrue("'c' is a lower case letter", isLowerCase('c'))
    }

    @Test fun testLowerCaseA() {
        Assert.assertTrue("'a' is a lower case letter", isLowerCase('a'))
    }

    @Test fun testLowerCaseZ() {
        Assert.assertTrue("'z' is a lower case letter", isLowerCase('z'))
    }

    @Test fun testUpperCase() {
        Assert.assertFalse("'A' is an upper case letter", isLowerCase('A'))
    }

    @Test fun testDigit() {
        Assert.assertFalse("'1' is not a lower case letter", isLowerCase('1'))
    }
}