package math;

import java.util.*;

/**
 * @author quzhe
 * @date 2020/3/13 16:41
 * @description math
 */
public class WatchedVideosByFriends {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Set<Integer> curF = new HashSet<>();
        Set<Integer> f = new HashSet<>();
        boolean first = true;
        while (level > 0) {
            if (first) {
                int[] friend1 = friends[id];
                for (int i : friend1) {
                    curF.add(i);
                    f.add(i);
                }
                first = false;
            } else {
                f = new HashSet<>();
                for (int i : curF) {
                    for (int j : friends[i]) {
                        if (j != 0) {
                            f.add(j);
                        }

                    }
                }
                curF.clear();
                curF.addAll(f);
            }
            level--;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i : curF) {
            List<String> videos = watchedVideos.get(i);
            for (String s : videos) {
                Integer orDefault = map.getOrDefault(s, 0);
                map.put(s, orDefault + 1);
            }
        }
        List<String> res =new ArrayList<>(map.keySet());
        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1).equals(map.get(o2))) {
                    return map.get(o1) - map.get(o2);
                }
                return o1.compareTo(o2);
            }
        });
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> watchedVideos = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("A");
        l1.add("B");
        List<String> l2 = new ArrayList<>();
        l2.add("C");
        List<String> l3 = new ArrayList<>();
        l3.add("B");
        l3.add("C");
        List<String> l4 = new ArrayList<>();
        l4.add("D");
        watchedVideos.add(l1);watchedVideos.add(l2);watchedVideos.add(l3);watchedVideos.add(l4);

        int[] i1 = new int[]{1,2};
        int[] i2 = new int[]{0,3};
        int[] i3 = new int[]{0,3};
        int[] i4 = new int[]{1,2};
        int[][] friends = new int[][] {i1,i2,i3,i4};

        WatchedVideosByFriends w = new WatchedVideosByFriends();
        w.watchedVideosByFriends(watchedVideos, friends,0, 3);

    }
}
