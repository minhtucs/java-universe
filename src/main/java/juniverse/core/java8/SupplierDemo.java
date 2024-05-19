package juniverse.core.java8;

import java.util.function.BiFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * Represents an operation that accept nothing and return something
 * 
 * It's functional interface is R Supplier<R>.get()
 * 
 * @author tunm2
 */
public class SupplierDemo {
    
    public static void main(String[] args) {
        SupplierDemo demo = new SupplierDemo();
        demo.print(demo::generateString);
        BiFunction<Integer,Integer,Integer> bf = (a, b) -> a + b;
    }
    
    static void practice() {
        Supplier<String> s = () -> new String();
    }
    
    public void print(Supplier<String> supplier) {
        System.out.println(supplier.get());
    }
    
    public String generateString() {
        return String.valueOf(System.currentTimeMillis());
    }
    
    static void builtinSuppliers() {
        IntSupplier intSupplier = () -> 1;
    }
    
    public void getCache(Supplier<TagTranslationCacheKey> keyGenerator) {
        TagTranslationCacheKey key = keyGenerator.get();
        System.err.println(key);
    }
    
    public TagTranslationCacheKey genegateKey() {
        return new TagTranslationCacheKey();
    }
    
    static class TagTranslationCacheKey {
        int tagId;
        String language;
    }
    
}
