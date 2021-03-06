package DS_ALGO.HashTables;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
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

    List<MapData<K,V>> mapData = new ArrayList<>();

    void set(K key, V value) {
        mapData.add(new MapData<K,V>(key, value));
    }

    V get(K key) {
        MapData<K,V> data = mapData.stream().filter( item -> item.key == key).limit(1).collect(Collectors.toList()).get(0);
        return data.value;
    }



}
public class CustomMap {

    public static void main(String [] args) {

        MyMap<String, String> myMap = new MyMap<>();
        myMap.set("Sarfraz", "Engineer SW");
        myMap.set("Siddiqui", "Doctor");
        System.out.println(myMap.get("Sarfraz"));

    }

    
}

