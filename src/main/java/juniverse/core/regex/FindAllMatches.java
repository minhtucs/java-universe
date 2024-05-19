package juniverse.core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tunm2
 */
public class FindAllMatches {
    
    public static void main(String[] args) {
        String regex = null;
        CharSequence input = null;
//        matcherFindMatches();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
//            matcher.
            // inquiry matcher for texts found
        }
    }
    
    // compile the regex first to match many times
    static void matcherFindMatches() {
        String regex = "caud\\([0-9]*\\)";
        String input = "tag(10280) and caud(11) and caud(22)";
        
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        
        // find matched strings
        int nMatches = 0;
        while (matcher.find()) {
            nMatches++;
            String matchedPart = input.substring(matcher.start(), matcher.end());
//            String matchedPart = matcher.group(0);
            System.err.println("found " + nMatches + ": " + matchedPart);
        }
    }
    
}
