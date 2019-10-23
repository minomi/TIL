package medium.top_k_frequent_elements;

import medium.MaximumProductSubarray;

import java.security.KeyStore;
import java.util.*;
import java.util.stream.Collectors;

/**
 * IDE : IntelliJ IDEA
 * Created by minho on 2019/10/23.
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int n : nums) {
//            int value = map.getOrDefault(n, 0);
//            map.put(n, ++value);
//        }
//        return map.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                .limit(k)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());

        // bucket sort 를 이용한 풀
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int n : nums) {
            frequency.put(n, frequency.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (bucket[value] == null) {
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = bucket.length - 1 ; i >= 0 && res.size() < k ; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }

        return res;
    }
}
