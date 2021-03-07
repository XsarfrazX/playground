package DS_ALGO.HashTables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstRecurringCharacter {

    public <T> T firstRecurring(T[] array) {
        T firstRecurring = null;

        Map<T,Boolean> itemTraversed = new HashMap<>();

        for(T item: array) {
            if(itemTraversed.get(item) != null) {
                firstRecurring = item;
                break;
            }
            itemTraversed.put(item, true);
        }
        return firstRecurring;
    }

    public static void main(String[] args) {
        FirstRecurringCharacter firstRecurringCharacter = new FirstRecurringCharacter();
        Integer[] test = {1,2,3,4,2,1,3,4};
        System.out.println("First recurring element in array: " + Arrays.toString(test) + " is: " + firstRecurringCharacter.firstRecurring(test));
    }
    
}
