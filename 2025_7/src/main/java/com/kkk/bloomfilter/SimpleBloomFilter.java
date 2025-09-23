package com.kkk.bloomfilter;

import java.util.BitSet;
import java.util.function.Function;

public class SimpleBloomFilter<T> {
    private final BitSet bitSet;
    private final int size;
    private final Function<T, Integer>[] hashFunctions;

    @SafeVarargs
    public SimpleBloomFilter(int size, Function<T, Integer>... hashFunctions) {
        this.size = size;
        this.bitSet = new BitSet(size);
        this.hashFunctions = hashFunctions;
    }

    public void add(T item) {
        for (Function<T, Integer> hashFunction : hashFunctions) {
            int position = Math.abs(hashFunction.apply(item)) % size;
            bitSet.set(position, true);
        }
    }

    public boolean mightContain(T item) {
        for (Function<T, Integer> hashFunction : hashFunctions) {
            int position = Math.abs(hashFunction.apply(item)) % size;
            if (!bitSet.get(position)) {
                return false; // 肯定不存在
            }
        }
        return true; // 可能存在
    }

    // 使用示例
    public static void main(String[] args) {
        // 创建3个简单的哈希函数
        Function<String, Integer> hash1 = String::hashCode;
        Function<String, Integer> hash2 = s -> s.hashCode() * 31;
        Function<String, Integer> hash3 = s -> s.hashCode() * 17;

        SimpleBloomFilter<String> filter = new SimpleBloomFilter<>(100, hash1, hash2, hash3);

        // 添加元素
        filter.add("apple");
        filter.add("banana");
        filter.add("orange");

        // 查询元素
        System.out.println(filter.mightContain("apple"));    // true
        System.out.println(filter.mightContain("banana"));   // true
        System.out.println(filter.mightContain("grape"));    // false (可能误判)
    }
}
