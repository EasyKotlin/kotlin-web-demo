fun main(args: Array<String>) {
  val hour = 6
  val opens = 9
  val closes = 20
  println("Operating hours: $opens - $closes")
  val isOpen = hour >= opens && hour <= closes
  println(isOpen)
}
/* Output:
Operating hours: 9 - 20
false
*/