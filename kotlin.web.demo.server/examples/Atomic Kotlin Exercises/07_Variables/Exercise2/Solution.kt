fun main(args: Array<String>) {
    var x = 1
    var y = 2
    
    var tmp = x
    x = y
    y = tmp
    println(x)
    println(y)
}
/* Expected output:
2
1
*/