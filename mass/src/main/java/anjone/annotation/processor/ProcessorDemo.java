package anjone.annotation.processor;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import java.util.*;

// run javac
// javac anjone/annotation/processor/ProcessorDemo.java
// javac anjone/annotation/processor/SimpleTest.java -processor anjone.annotation.processor.ProcessorDemo

@SupportedAnnotationTypes("anjone.annotation.processor.Simple")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ProcessorDemo extends AbstractProcessor {
    @Override
    public boolean process(
            Set<? extends TypeElement> annotations,
            RoundEnvironment env) {

        for (TypeElement t : annotations) {
            System.out.println(t);
        }
        for (Element el :
                env.getElementsAnnotatedWith(Simple.class)) {
            display(el);
        }
        return false;
    }

    private void display(Element el) {
        System.out.println("==== " + el + " ====");
        System.out.println(el.getKind() +
                " : " + el.getModifiers() +
                " : " + el.getSimpleName() +
                " : " + el.asType());
        if (el.getKind().equals(ElementKind.CLASS)) {
            TypeElement te = (TypeElement) el;
            System.out.println(te.getQualifiedName());
            System.out.println(te.getSuperclass());
            System.out.println(te.getEnclosedElements());
        }
        if (el.getKind().equals(ElementKind.METHOD)) {
            ExecutableElement ex = (ExecutableElement) el;
            System.out.print(ex.getReturnType() + " ");
            System.out.print(ex.getSimpleName() + "(");
            System.out.println(ex.getParameters() + ")");
        }
    }
}

