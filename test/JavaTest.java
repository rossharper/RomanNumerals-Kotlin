import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(Parameterized.class)
public class JavaTest {
    private final int arabic;
    private final String roman;

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1, "I"},
                {2, "II"},
                {3, "III"},
                {4, "IV"},
                {5, "V"},
                {6, "VI"},
                {7, "VII"},
                {8, "VIII"},
                {9, "IX"},
                {10, "X"},
                {40, "XL"},
                {50, "L"},
                {90, "XC"},
                {100, "C"},
                {500, "D"},
                {400, "CD"},
                {1000, "M"},
                {900, "CM"},
                {3948, "MMMCMXLVIII"},
                {2494, "MMCDXCIV"},
                {1369, "MCCCLXIX"},
                {2751, "MMDCCLI"},
                {80, "LXXX"},
                {1999, "MCMXCIX"}
        });
    }

    public JavaTest(int arabic, String roman) {
        this.arabic = arabic;
        this.roman = roman;
    }

    @Test
    public void shouldReturnExpectedRomanForArabic() {
        assertThat(new RomanNumeralGenerator().arabicToRoman(arabic), equalTo(roman));
    }
}
