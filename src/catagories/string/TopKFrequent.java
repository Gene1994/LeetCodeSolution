package string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author quzhe
 * @date 2020/3/12 17:32
 * @description 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 */
public class TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = Arrays.asList(words);
        Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Long, List<String>> finalMap = new LinkedHashMap<>();
        //分组, 计数和排序
        collect.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEachOrdered(e -> {
                List<String> list1 = finalMap.computeIfAbsent(e.getValue(), s -> new ArrayList<>());
                list1.add(e.getKey());
                list1.sort(Comparator.comparing(s -> s));
            } );
        List<String> res = new ArrayList<>();
        for (Map.Entry<Long, List<String>> entry : finalMap.entrySet()) {
            if (k >= entry.getValue().size()) {
                res.addAll(entry.getValue());
                k -= entry.getValue().size();
            } else {
                for (int i = 0; i < k; i++) {
                    res.add(entry.getValue().get(i));
                }
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequent t = new TopKFrequent();
        String[] s = new String[] {"a","aa","aaa"};
        t.topKFrequent(s, 2);
    }

}
