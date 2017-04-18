fun findMax(first: Int, second: Int) = 
        if (first > second) first else second

fun main(args: Array<String>) {
    val first = 17
    val second = 31
    
    val max = findMax(first, second)
    println("The maximum between $first and $second is $max.")
}
/* Expected output:
The maximum between 17 and 31 is 31.
*/