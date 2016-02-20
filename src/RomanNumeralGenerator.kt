class RomanNumeralGenerator {
    fun arabicToRoman(arabic: Int): String {
        var roman = "";
        var arabicRemaining = arabic

        while(arabicRemaining >= 10) {
            roman += "X"
            arabicRemaining -= 10
        }

        if(arabicRemaining == 9) {
            roman += "IX"
            arabicRemaining -= 9
        }

        if(arabicRemaining >= 5) {
            roman += "V"
            arabicRemaining -= 5
        }

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
