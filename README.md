# Roman Numerals Kata in Kotlin

Performing the Roman Numerals Kata in Kotlin.

## Interesting Notes

To get a parameterized JUnit4 test working in Kotlin I had to do the following:

- annotate the Kotlin test class with `@RunWith(Parameterized::class)`
- place the `@Parameterized.Parameters` function within a `companion object` in the test class
- annotate the `@Parameterized.@Parameters` function with the `@JvmStatic` annotation — as Kotlin doesn't have static functions, this allows Java code to call this Kotlin as if it were a static (https://kotlinlang.org/docs/reference/java-to-kotlin-interop.html#static-methods)
- Use Kotlin's `Any` in place of Java's `Object`

Example:

```Kotlin
@RunWith(Parameterized::class)
class KotlinTest(val paramOne: Int, val paramTwo: String) {
    
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() : Collection<Array<Any>> {
            return listOf(
                    arrayOf(1, "I"),         // First test:  (paramOne = 1, paramTwo = "I")
                    arrayOf(1999, "MCMXCIX") // Second test: (paramOne = 1999, paramTwo = "MCMXCIX")
            )
        }
    }

    @Test
    fun shouldReturnExpectedRomanForArabic() {
        assertThat(RomanNumeralGenerator().arabicToRoman(paramOne), equalTo(paramTwo));
    }
}
```

This is equivalent to the Java JUnit4 test:

```Java
@RunWith(Parameterized.class)
public class JavaTest {
    private final int paramOne;
    private final String paramTwo;

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1, "I"},         // First test:  (paramOne = 1, paramTwo = "I")
                {1999, "MCMXCIX"} // Second test: (paramOne = 1999, paramTwo = "MCMXCIX")
        });
    }

    public JavaTest(int paramOne, String paramTwo) {
        this.paramOne = paramOne;
        this.paramTwo = paramTwo;
    }

    @Test
    public void shouldReturnExpectedRomanForArabic() {
        assertThat(new RomanNumeralGenerator().arabicToRoman(paramOne), equalTo(paramTwo));
    }
}
```

_Obviously we'd use better names than `paramOne` and `paramTwo`!_
