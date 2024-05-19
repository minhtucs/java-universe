package juniverse.core.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 *
 * @author kiddy
 */
public class FieldNullValidateProcessor {
    
    public static void processAnnotations(Object object) {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == FieldNullValidate.class) {
                    field.setAccessible(true);
                    try {
                        Object value = field.get(object);
                        if (value == null) {
                            throw new NullPointerException();
                        }
                    } catch (IllegalAccessException | IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
}
