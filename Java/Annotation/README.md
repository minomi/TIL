## Java Annotation

* Java 5 부터 지원
* Class, Field, Method 에 사용할 수 있다.
* Annotation 의 Retention 시기를 조절하여 다양하게 사용가능
``` Java
public enum RetentionPolicy {
    /**
     * Annotations are to be discarded by the compiler.
     */
    SOURCE,

    /**
     * Annotations are to be recorded in the class file by the compiler
     * but need not be retained by the VM at run time.  This is the default
     * behavior.
     */
    CLASS,

    /**
     * Annotations are to be recorded in the class file by the compiler and
     * retained by the VM at run time, so they may be read reflectively.
     *
     * @see java.lang.reflect.AnnotatedElement
     */
    RUNTIME
}
```
* 개발자가 비즈니스 로직에 집중하고, 부가적인 작업 (Aspect) 들을 Annotation 을 사용하여 처리할 수 있음.
 