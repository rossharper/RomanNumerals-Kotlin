# Roman Numerals Kata in Kotlin

Performing the Roman Numerals Kata in Kotlin.

## Interesting Notes

To get a parameterized JUnit4 test working in Kotlin I had to do the following:

- annotate the Kotlin test class with `@RunWith(Parameterized::class)`
- place the `@Parameterized.Parameters` function within a `companion object` in the test class
- annotate the `@Parameterized.@Parameters` function with the `@JvmStatic` annotation — as Kotlin doesn't have static functions, annotation that allows Java code to call this Kotlin as if it were a static (https://kotlinlang.org/docs/reference/java-to-kotlin-interop.html#static-methods)
- Use Kotlin's `Any` in place of Java's `Object`

Example:

```Kotlin
@RunWith(Parameterized::class)
class MyTest(val paramOne: Int, val paramTwo: String) {
    
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
```
