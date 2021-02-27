/**
 * Simple implementation of a dynamic array
 */
class MyArray<T> {
    private Integer currentIndex;
    private Integer capacity;
    private T data[];

    public MyArray() {
        this.capacity = 1; // initial value
        this.currentIndex = 0;
        data = new T[this.capacity]; // fix this

    }

    public void push(T item) {
        if( currentIndex == capacity) {
            T tempCopy[] = data;
            capacity *=2; // double capacity;
            data = new T[this.capacity]; // fix this
        }
        data[currentIndex++] = item;
    }

    public T pop() {
        return data[currentIndex--];
    }

    public T get(Integer index) {
        if(index < 0 || index >= currentIndex)
            return null;

        return data[index];
    }

    public Integer length() {
        return currentIndex;
    }


}
public class CustomArray {
    public static void main(String args[]) {

        MyArray<Integer> myArray = new MyArray<Integer>();
        myArray.push(2);
        myArray.push(4);
        myArray.push(6);
        System.out.println("Array Length is: " + myArray.length());
        System.out.println("Array[2] = " + myArray.get(2));
        myArray.pop();
        System.out.println("Length after poping is: " + myArray.length());
        
    }
}