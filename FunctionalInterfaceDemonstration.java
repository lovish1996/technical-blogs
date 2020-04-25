// Source Code

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaceDemonstration {
    public static void main(String[] args) {

        // Anonymous Inner Class
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Inner Class for implementing the functionality of run method.");
            }
        };
        runnable1.run();

        // Lambdas for Anonymous Inner Classes
        Runnable runnable2 = () -> System.out.println("Lambdas for Anonymous Inner Classes");
        runnable2.run();

        // @FunctionalInterface Example
        Remainder remainder = (num1, num2) -> num1 % num2;
        System.out.println("Printing 35 % 13: " + remainder.calculateRemainder(35, 13));

        // Predicate Example 1
        Predicate<String> strContains = (string) -> string.contains("predicate");
        System.out.println("Checking predicate for strContains: " + strContains.test("This is a predicate"));

        // Predicate Example 2
        Predicate<Integer> intInRange = (integer) -> integer >= 50 && integer < 100;
        System.out.println("Checking if integer is between 50(Inclusive) and 100(exclusive): " + intInRange.test(121));

        // Consumer Example 1
        Consumer<String> lowerCase = (string) -> System.out.println(string.toLowerCase());
        lowerCase.accept("Convert This Sample String To LowerCase");

        // Consumer Example 2
        Consumer<String> printLen = (string) -> System.out.println("The given String: " + string + " has " + string.length() + " characters.");
        printLen.accept("SampleString");

        // Consumer Example 3
        Consumer<Integer> numDigits = (integer) -> System.out.println("The given integer has: " + integer.toString().length() + " digits.");
        numDigits.accept(1234567);

        // Function Example 1
        Function<String, Integer> parseString = (string) -> Integer.parseInt(string);
        Integer sampleInt = parseString.apply("1234567");
        System.out.println("Printing 1234567 mod 10: " + sampleInt % 10);

        // Function Example 2
        Function<String, Integer> parseStringMethodReference = Integer::parseInt;
        Integer sampleIntMethodReference = parseStringMethodReference.apply("7654321");
        System.out.println("Printing 7654321 div 10: " + sampleIntMethodReference / 10);

        // Function Example 3
        Function<Double, Integer> convertDoubleToInteger = Double::intValue;
        Integer intValueOfDouble = convertDoubleToInteger.apply(59.87);
        System.out.println("Integer value of 59.87 is: " + intValueOfDouble);

        // Supplier Example 1
        Supplier<String> greetingPrefix = () -> "Hi there, Welcome back!";
        System.out.println(greetingPrefix.get());

        // Supplier Example 2
        Supplier<Integer> modConstantForUnitDigit = () -> 10;
        System.out.println("Unit's digit of 1579 is: " + 1579 % modConstantForUnitDigit.get());

        // UnaryOperator Example 1
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.apply("UpperCase"));

        //UnaryOperator Example 2
        UnaryOperator<Integer> multiplyBy7 = (integer) -> integer * 7;
        System.out.println("Printing 14 * 7: " + multiplyBy7.apply(14));

        // BinaryOperator Example 1
        BinaryOperator<String> appendStrings = (string1, string2) -> string1 + string2;
        System.out.println(appendStrings.apply("Hello ", "Medium!"));

        // BinaryOperator Example 2
        BinaryOperator<Integer> calculateMod = (a, b) -> a % b;
        System.out.println("Printing 29 mod 6: " + calculateMod.apply(29, 6));

    }

    @FunctionalInterface
    interface Remainder {
        Integer calculateRemainder(Integer a, Integer b);
    }
}
