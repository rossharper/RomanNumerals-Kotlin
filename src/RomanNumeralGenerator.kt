class RomanNumeralGenerator {

    val arabicToRomanMapping : Map<Int, String> = mapOf(
            Pair(100, "C"),
            Pair(90, "XC"),
            Pair(50, "L"),
            Pair(40, "XL"),
            Pair(10, "X"),
            Pair(9, "IX"),
            Pair(5, "V"),
            Pair(4, "IV"),
            Pair(1, "I")
    )

    fun arabicToRoman(arabicToConvert: Int): String {
        var arabicRemainder = arabicToConvert
        var romanOutput = ""
        arabicToRomanMapping.forEach {
            val (arabic, roman) = it
            while(arabicRemainder >= arabic) {
                romanOutput += roman
                arabicRemainder -= arabic
            }
        }
        return romanOutput
    }
}
