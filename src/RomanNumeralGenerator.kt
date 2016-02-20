class RomanNumeralGenerator {
    fun arabicToRoman(arabic: Int): String {
        var roman = "";
        var arabicRemaining = arabic

        if(arabicRemaining == 4) {
            roman += "IV"
            arabicRemaining -= 4
        }

        for(i in arabicRemaining downTo 1) {
            roman += "I"
        }

        return roman;
    }
}
