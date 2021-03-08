package DS_ALGO;

public class ValueRef {

    public static void main(String[] args) {

        ValueRef obj = new ValueRef();
        StringBuffer myString = new StringBuffer("Cool string");
        System.out.println(myString);
        obj.getNewStringBuffer(myString);
        System.out.println(myString);

        String str = "Cool";
        System.out.println(str);
        obj.getNewString(str);
        System.out.println(str);

        System.out.println(obj.reverseStringBuffer(new StringBuffer("Cool")));



    }

    StringBuffer getNewStringBuffer(StringBuffer str) {
        str.append(" buffer");
        return str;
    }
    String getNewString(String str) {
        str+=" string";
        return str;
    }

    StringBuffer reverseStringBuffer(StringBuffer str) {
        int start=0, end=str.length() -1;
        while(start < end) {
            str.setCharAt(start, (char)(str.charAt(start) ^ str.charAt(end)));
            str.setCharAt(end, (char)(str.charAt(start) ^ str.charAt(end)));
            str.setCharAt(start, (char)(str.charAt(start) ^ str.charAt(end)));
            start++;
            end--;

        }
        return str;
    }
    
}
