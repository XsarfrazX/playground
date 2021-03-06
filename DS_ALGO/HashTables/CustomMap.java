package DS_ALGO.HashTables;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class MapData<K, V> {

    K key;
    V value;

    MapData(K key, V value) {
        this.key = key;
        this.value = value;
    }

}

class MyMap<K,V> {

    List<List<MapData<K,V>>> mapData = new ArrayList<>();
    int capacity;

    MyMap(int capacity) {
        this.capacity = capacity;
        mapData = new ArrayList<>(this.capacity);
        for(int i=0;i<capacity;i++)
            mapData.add(i, null);

    }

    void set(K key, V value) {

        int address = hashFunction(key); // get address

        if(mapData.get(address) == null) { // if inserting for 1st time, initialze new arrayList
            mapData.add(address, new ArrayList<>());

        }
        mapData.get(address).add(new MapData<K,V>(key, value)); // add items to the address (separating chaining)
    }

    V get(K key) {
        int address = hashFunction(key);
        List<MapData<K,V>> retrievedData = mapData.get(address);
        MapData<K,V> data = retrievedData.stream().filter( item -> item.key == key).limit(1).collect(Collectors.toList()).get(0);
        return data.value;
    }

    private int hashFunction(K key) {
        return (key.hashCode() & Integer.MAX_VALUE) % capacity; // mock return address within capacity
    }



}
public class CustomMap {

    public static void main(String [] args) {

        MyMap<String, String> myMap = new MyMap<>(5);
        myMap.set("Sarfraz", "Engineer SW");
        myMap.set("Siddiqui", "Doctor");
        System.out.println(myMap.get("Sarfraz"));
        System.out.println(myMap.get("Siddiqui"));

    }

    
}

