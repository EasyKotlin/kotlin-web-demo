fun main(args: Array<String>) {
  val sunny = true
  val hoursSleep = 6
  val exercise = false
  val temp = 55

            // [1]:
  val happy1 = sunny && temp > 50 ||
      exercise && hoursSleep > 7
  println(happy1) // true

            // [2]:
  val sameHappy1 = (sunny && temp > 50) ||
      (exercise && hoursSleep > 7)
  println(sameHappy1) // true

            // [3]:
  val notSame =
      (sunny && temp > 50 || exercise) &&
          hoursSleep > 7
  println(notSame) // false
}