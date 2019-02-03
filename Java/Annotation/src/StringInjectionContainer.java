import java.lang.reflect.Field;
import java.util.Objects;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019-02-02.
 */
class StringInjectionContainer {

    private <T> void invokeAnnotation(T instance) throws IllegalAccessException {
        Field[] fields = instance.getClass().getDeclaredFields();
        for (Field field : fields) {
            StringValueInjection annotation = field.getAnnotation(StringValueInjection.class);
            if (Objects.nonNull(annotation) && field.getType().equals(String.class)) {
                field.setAccessible(true); // to access private members
                field.set(instance, annotation.value());
            }
        }
    }

    <T> T get(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T instance = clazz.newInstance();
        invokeAnnotation(instance);
        return instance;
    }
}
