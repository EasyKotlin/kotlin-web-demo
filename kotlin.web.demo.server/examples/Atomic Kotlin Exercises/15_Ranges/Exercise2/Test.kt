import org.junit.Assert
import org.junit.Test

class TestValidIdentifier {
    @Test fun testSimple() {
        Assert.assertTrue("'name' is a valid identifier", isValidIdentifier("name"))
    }

    @Test fun testStartsWithUnderscore() {
        Assert.assertTrue("'_name' is a valid identifier", isValidIdentifier("_name"))
    }

    @Test fun testUnderscore() {
        Assert.assertTrue("'_' is a valid identifier", isValidIdentifier("_"))
    }

    @Test fun testContainsDigits() {
        Assert.assertTrue("'n01' is a valid identifier", isValidIdentifier("n01"))
    }

    @Test fun testUpperCase() {
        Assert.assertTrue("'NNN' is a valid identifier", isValidIdentifier("NNN"))
    }

    @Test fun testValid() {
        Assert.assertTrue("'_N01' is a valid identifier", isValidIdentifier("_N01"))
    }

    @Test fun testStartsWithDigit() {
        Assert.assertFalse("'1_' is not a valid identifier", isValidIdentifier("1_"))
    }

    @Test fun testContainsIllegalCharacters() {
        Assert.assertFalse("'&%$' is not a valid identifier", isValidIdentifier("&%$"))
    }
}