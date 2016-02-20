
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
                    arrayOf(2, "II")
            )
        }
    }

    @Test
    fun shouldReturnExpectedRomanFortArabic() {
        assertThat(generator.arabicToRoman(arabic), equalTo(expectedRoman));
    }
}