fun isLowerCase(ch: Char): Boolean = ch >= 'a' && ch <= 'z'

fun isUpperCase(ch: Char): Boolean = ch >= 'A' && ch <= 'Z'

fun isLetterOrUnderscore(ch: Char): Boolean = ch == '_' || isLowerCase(ch) || isUpperCase(ch)

fun isDigit(ch: Char): Boolean = ch >= '0' && ch <= '9'

fun isValidIdentifier(s: String): Boolean {
    if (s.isEmpty() || !isLetterOrUnderscore(s[0])) return false
    for (ch in s) {
        if (!isLetterOrUnderscore(ch) && !isDigit(ch)) return false
    }
    return true
}