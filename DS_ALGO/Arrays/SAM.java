package DS_ALGO.Arrays;

interface FunctionalInterface {
    void singleAbstractMethod(String msg);
}
public class SAM {


    
    public static void main(String args[]) {
        FunctionalInterface impl = new FunctionalInterface(){
            public void singleAbstractMethod(String msg) {
                System.out.println(msg);
            }
        };

        impl.singleAbstractMethod("Hello");

        FunctionalInterface lambdaImpl = x->System.out.println(x);
        lambdaImpl.singleAbstractMethod("World");

        FunctionalInterface lambdaImpl2 = (x) -> {
            String msg = x + " Hello!";
            System.out.println(msg);
        };

        lambdaImpl2.singleAbstractMethod("World");


    }

    
}
