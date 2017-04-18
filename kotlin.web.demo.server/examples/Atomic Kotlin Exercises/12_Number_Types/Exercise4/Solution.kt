fun convertTime(hours: Int, minutes: Int, seconds: Int): Long =
        (((hours * 60L + minutes) * 60) + seconds) * 1000

fun main(args: Array<String>) {
    println(convertTime(1, 30, 0))
}