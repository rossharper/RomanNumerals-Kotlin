
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class RomanNumeralGeneratorTest {
    private var generator: RomanNumeralGenerator = RomanNumeralGenerator()

    @Test
    fun testRomanNumeralGeneratorReturnsIFor1() {
        assertThat(generator.arabicToRoman(1), equalTo("I"));
    }
}