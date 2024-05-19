package juniverse.algorithm.balance;

/**
 * @author tunm2
 */
public class ClassicProblems {
    
    public static void main(String[] args) {
        System.out.println(atoi("034560"));
        System.out.println(Integer.SIZE);
    }
    
    static int atoi(String str) throws NumberFormatException {
        if (str == null || str.isEmpty())
            throw new NumberFormatException();
        
        int len = str.length();
        int number = 0;
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch < '0' || ch > '9')
                throw new NumberFormatException();
            int ch2int = ch - '0';
            number += ch2int * (Math.pow(10, (len-i-1)));
        }
        
        if (number > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (number < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        
        return number;
    }
}
