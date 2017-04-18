import org.junit.Test

class TestVariables1 {
    @Test fun test1() {
        main(arrayOf())
        println("error: val cannot be reassigned")
    }
}