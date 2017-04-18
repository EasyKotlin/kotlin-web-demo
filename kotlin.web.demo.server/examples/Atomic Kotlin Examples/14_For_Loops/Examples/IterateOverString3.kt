fun containsChar(s: String, ch: Char): Boolean {
  for (c in s) {
    if (c == ch) return true
  }
  return false
}

fun main(args: Array<String>) {
  println(containsChar("kotlin", 't')) // true
  println(containsChar("kotlin", 'a')) // false
}