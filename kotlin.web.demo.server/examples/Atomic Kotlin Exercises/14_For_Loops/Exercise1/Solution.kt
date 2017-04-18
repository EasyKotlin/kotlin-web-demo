fun factorial(n: Long): Long {
    var result = 1L
    for (i in 1..n) {
        result *= i
    }
    return result
}