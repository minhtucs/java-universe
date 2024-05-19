package juniverse.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tunm2
 */
public class RegexSamples {
    
    public static void main(String[] args) {
//        validateNumber();
//        replaceAllNonDigits();
//        extractNumbersFromText("12adsf345d09");
//        extractIdOfHtmlElement("<input id='123' name='email' />");
        matchDigit("hello 123");
//        matchNonDigit("hello xyzabc");
    }
    
    static void extractIdOfHtmlElement(String element) {
        Pattern pattern = Pattern.compile("id='([0-9]+)'");
        Matcher matcher = pattern.matcher(element);
        while (matcher.find()) {
            System.err.println(matcher.group(1));
        }
    }
    
    static void extractNumbersFromText(String input) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.err.println(matcher.group());
        }
    }
    
    static void isAlphabet() {
        String regex = "[a-zA-Z0-9]*";
    }
    
    static void replaceAllNonDigits() {
        String regex = "[^0-9]";
        String input = "123xl.- uy456";
        String replaced = input.replaceAll(regex, "");
        System.err.println("output " + replaced);
    }
    
    static void validateNumber() {
        String regex = "[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        
        String input = "123";
        Matcher matcher = pattern.matcher(input);
        System.err.println("matched " + input + ": " + matcher.matches());
        
        input = "123dd1";
        matcher = pattern.matcher(input);
        System.err.println("matched " + input + ": " + matcher.matches());
    }
    
    static void containSpecifiedText() {
        String regex = ".*caud.*";
        String input = "tag(10280) and caud(11)";
        boolean matched = Pattern.matches(regex, input);
        System.err.println("matched: " + matched);
    }
    
    static void matchDigit(String input) {
        String regex = "hello \\d*";
//        String regex = "hello [0-9]*";
        boolean matched = Pattern.matches(regex, input);
        System.err.println(input + ": " + matched);
    }
    
    static void matchNonDigit(String input) {
        String regex = "hello \\D*";
        boolean matched = Pattern.matches(regex, input);
        System.err.println(input + ": " + matched);
    }
}
