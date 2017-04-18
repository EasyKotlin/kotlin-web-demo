fun checkSign(number: Int) = 
        if (number > 0)
            "positive"
        else if (number == 0)
            "zero"
        else
            "negative"

fun main(args: Array<String>) {
    val n = 17
    println("The number $n is ${checkSign(n)}.")
}
/* Expected output:
The number 17 is positive.
*/