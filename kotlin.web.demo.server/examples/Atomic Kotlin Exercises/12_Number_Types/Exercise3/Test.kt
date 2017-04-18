import org.junit.Assert
import org.junit.Test

class TestNumberTypes3 {
    @Test fun testMain() {
        main(arrayOf())
    }

    @Test fun testFahrenheitToCelsius1() {
        Assert.assertEquals("5 F should be -15 C",
                -15.0, convertFahrenheitToCelsius(5), 0.0001)
    }

    @Test fun testFahrenheitToCelsius2() {
        Assert.assertEquals("100 F should be 37.7778 C",
                37.7778, convertFahrenheitToCelsius(100), 0.0001)
    }

    @Test fun testCelsiusToFahrenheit1() {
        Assert.assertEquals("-15 C should be 5 F",
                5.0, convertCelsiusToFahrenheit(-15), 0.0001)
    }

    @Test fun testCelsiusToFahrenheit2() {
        Assert.assertEquals("20 C should be 68 F",
                68.0, convertCelsiusToFahrenheit(20), 0.0001)
    }
}