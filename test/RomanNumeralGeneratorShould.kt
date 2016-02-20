
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class RomanNumeralGeneratorTest(val arabic: Int, val expectedRoman: String) {
    private var generator: RomanNumeralGenerator = RomanNumeralGenerator()

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() : Collection<Array<Any>> {
            return listOf(
                    arrayOf(1, "I"),
                    arrayOf(2, "II"),
                    arrayOf(3, "III"),
                    arrayOf(4, "IV"),
                    arrayOf(5, "V"),
                    arrayOf(6, "VI"),
                    arrayOf(7, "VII"),
                    arrayOf(8, "VIII"),
                    arrayOf(9, "IX"),
                    arrayOf(10, "X"),
                    arrayOf(40, "XL"),
                    arrayOf(50, "L"),
                    arrayOf(90, "XC"),
                    arrayOf(100, "C"),
                    arrayOf(500, "D"),
                    arrayOf(400, "CD"),
                    arrayOf(1000, "M")
            )
        }
    }

    @Test
    fun shouldReturnExpectedRomanForArabic() {
        assertThat(generator.arabicToRoman(arabic), equalTo(expectedRoman));
    }
}