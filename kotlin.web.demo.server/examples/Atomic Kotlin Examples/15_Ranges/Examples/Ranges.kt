fun main(args: Array<String>) {
  for (i in 0..9) {
    print("$i ")
  }
  println(".")
  // 0 1 2 3 4 5 6 7 8 9 .

  for (i in 0 until 10) {
    print("$i ")
  }
  println(".")
  // 0 1 2 3 4 5 6 7 8 9 .

  for (i in 0..20 step 2) {
    print("$i ")
  }
  println(".")
  // 0 2 4 6 8 10 12 14 16 18 20 .

  for (c in 'a'..'d') {
    print(c)
  }
  println(".")
  // abcd.
}