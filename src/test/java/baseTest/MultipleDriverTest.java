package baseTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME) // Make the annotation available at runtime
@Target(ElementType.METHOD)     // Specify that this annotation can be applied to methods
public @interface MultipleDriverTest {

}
