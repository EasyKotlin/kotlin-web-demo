fun main(args: Array<String>) {
  val hour = 6
  val opens = 9
  val closes = 20
  println("Operating hours: $opens - $closes")
  val isClosed = hour < opens || hour > closes
  println(isClosed)
}
/* Output:
Operating hours: 9 - 20
true
*/