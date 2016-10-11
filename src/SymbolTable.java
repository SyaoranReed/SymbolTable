/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * K Valor de la llave
 * V Valor de el objeto
 * @author Gabriel
 */
public interface SymbolTable<K extends Comparable<K>,V>
{
    public void put(K key, V val);
    public V get(K key);
    public void delete(K key);
    public boolean contains(K key);
    public boolean isEmpty();
    public int size();
    public K min();
    public K max();
    public K floor(K key);
    public K ceiling(K key);
    public int rank(K key);
    public K select(int k);
    public void deleteMin();
    public void deleteMax();
    public int size(K lo, K hi);
    Iterable<K> keys(K lo, K hi);
    Iterable<K> keys();
}
