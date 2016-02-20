class RomanNumeralGenerator {
    fun arabicToRoman(arabic: Int): String {
        var roman = "";
        for(i in arabic downTo 1) {
            roman += "I"
        }
        return roman;
    }

}
