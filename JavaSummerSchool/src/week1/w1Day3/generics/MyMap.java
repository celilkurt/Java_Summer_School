package week1.w1Day3.generics;

import java.util.ArrayList;
import java.util.List;

public class MyMap  <K,V>{

    private List<K> keys;
    private List<V> values;

    public MyMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    public MyMap(List<K> keys, List<V> values) {
        this.keys = keys;
        this.values = values;
    }

    public V get(K key){
        if(keys.contains(key))
            return values.get(keys.indexOf(key));
        else
            return null;

    }

    public void add(K key,V value){
        if(!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        }else{
            values.set(keys.indexOf(key),value);
        }
    }

    public boolean hasKey(K key){
        return keys.contains(key);
    }

    public boolean hasValue(V value){
        return values.contains(value);
    }

    public List<K> keySet(){
        return keys;
    }

    public List<V> values(){
        return values;
    }


}