package DS_ALGO.Arrays;

public class StringsInJava {
    
    public void Strings() {

        String str= "String"; // immutable; created in JVM string-pool
        str = new String("MyString"); // new created in heap
        System.out.println(str);
        System.out.println(str);




    }

    public void StringBufferAndBuilder() {

        StringBuffer stringBuffer = new StringBuffer("StringBuffer"); // thread-safe synchorinzed slow
        stringBuffer.insert(0, "s");
        System.out.println(stringBuffer);
        stringBuffer.replace(0, 1, "");
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.substring(0, 6));

        StringBuilder stringBuilder = new StringBuilder("StringBuilder"); // not thread-safe, fast
        stringBuilder.append("!");
        System.out.println(stringBuilder);
        stringBuilder.delete(0, 6);
        System.out.println(stringBuilder);

        

    }

    public static void main(String args[]) {
        StringsInJava obj = new StringsInJava();
        obj.StringBufferAndBuilder();
        obj.Strings();

    }
}
