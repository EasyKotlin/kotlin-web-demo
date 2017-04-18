fun sumOfEven(n: Int): Int {
    var result = 0
    for (i in 0..n step 2) {
        result += i
    }
    return result
}