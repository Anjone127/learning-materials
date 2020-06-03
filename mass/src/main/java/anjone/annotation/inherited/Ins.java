package anjone.annotation.inherited;

import java.lang.annotation.*;

@Inherited
@Target({ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@interface Ins {
    In[] value();
}
