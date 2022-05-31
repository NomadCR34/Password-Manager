package ir.aminr.passwordmanager.util

class PasswordGenerator {

    enum class Generator(val generatorList: List<Char>) {
        WORD_ONLY(('a'..'z') + ('A'..'Z')),
        WORD_WITH_NUMBER(('a'..'z') + ('A'..'Z') + ('0'..'9')),
        COMPLETE(('a'..'z') + ('A'..'Z') + ('0'..'9') + listOf('!', '@', '#', '$', '%', '&'))
    }

    fun getPassword(length: Int, generator: Generator): String = List(length) {
        (generator.generatorList).random()
    }.joinToString("")

}