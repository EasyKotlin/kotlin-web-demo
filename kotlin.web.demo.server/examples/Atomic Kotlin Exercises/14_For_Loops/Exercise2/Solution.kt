fun factorial(n: Long): Long {
    // copy the implementation of 'factorial' here
    var result = 1L
    for (i in 1..n) {
        result *= i
    }
    return result
}

fun sumOfFactorials(n: Long): Long {
    var result = 0L
    for (i in 1..n) {
        result += factorial(i)
    }
    return result
}