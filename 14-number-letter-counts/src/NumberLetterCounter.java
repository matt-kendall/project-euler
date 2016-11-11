import exception.NotThreeDigitsException;
import number.NumberDecomposer;
import number.ThreeDigitNumber;

/**
 * Determines the number of letters in a given number or range of numbers.
 */
public final class NumberLetterCounter {

    private final NumberDecomposer numberDecomposer;
    private static final String letters = "[^a-z^A-Z]";

    /**
     * Constructs a NumberLetterCounter given a NumberDecomposer.
     * @param numberDecomposer numberDecomposer to use
     */
    public NumberLetterCounter(NumberDecomposer numberDecomposer) {
        this.numberDecomposer = numberDecomposer;
    }

    /**
     * Identify the number of letters in a given number's textual representation.
     * This will only count letters, so hyphens and spaces will be ignored.
     * @param number number to count for
     * @return the number of letters in the numbers text form
     * @throws NotThreeDigitsException if the number is not three digits long
     */
    public int count(int number) throws NotThreeDigitsException {
        ThreeDigitNumber threeDigitNumber = numberDecomposer.decompose(number);
        String numberAsText = threeDigitNumber.asText();
        return getCount(numberAsText);
    }

    /**
     * Count the number of letters in the textual representation of a range of numbers.
     * This will only count letters, so hyphens and spaces will be ignored.
     * This is inclusive of the start and end numbers.
     * @param numberStart first number to count from
     * @param numberEnd last number to count
     * @return the sum of number of letters in text form of all numbers in range
     * @throws NotThreeDigitsException if any of the numbers are not three digits long
     */
    public int countRange(int numberStart, int numberEnd) throws NotThreeDigitsException {
        int totalCount = 0;
        for (int number = numberStart; number <= numberEnd; number++) {
            totalCount += count(number);
        }
        return totalCount;
    }

    private int getCount(String numberAsText) {
        // Remove any characters that are not letters
        String numbersWithLettersOnly = numberAsText.replaceAll(letters, "");

        return numbersWithLettersOnly.length();
    }
}
