
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class RomanNumeralGeneratorTest {
    private var generator: RomanNumeralGenerator = RomanNumeralGenerator()

    @Test
    fun shouldReturnIfor1() {
        assertThat(generator.arabicToRoman(1), equalTo("I"));
    }

    @Test
    fun shouldReturnIIfor2() {
        assertThat(generator.arabicToRoman(2), equalTo("II"));
    }
}