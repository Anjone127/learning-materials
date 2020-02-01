package anjone;


import anjone.enums.FruitEnums;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author gjy
 * @since 2019/11/26
 */
public class Size {

    public static void main(String[] args){

        System.out.println(VM.current().details());
        String a = "abc";
        System.out.println(ClassLayout.parseClass(FruitEnums.class).toPrintable());
        System.out.println(ClassLayout.parseClass(FruitEnums.class).toPrintable());
    }
}
