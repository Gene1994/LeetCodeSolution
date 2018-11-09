/**
 * LeetCode Problem No.819
 * @author: create by Gene1994
 * @date:2018/11/9
 */

import java.util.*;

/**
 *
 Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

 Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.



 Example:

 Input:
 paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 banned = ["hit"]
 Output: "ball"
 Explanation:
 "hit" occurs 3 times, but it is a banned word.
 "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 Note that words in the paragraph are not case sensitive,
 that punctuation is ignored (even if adjacent to words, such as "ball,"),
 and that "hit" isn't the answer even though it occurs more because it is banned.


 Note:

 1 <= paragraph.length <= 1000.
 1 <= banned.length <= 100.
 1 <= banned[i].length <= 10.
 The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 There are no hyphens or hyphenated words.
 Words only consist of letters, never apostrophes or other punctuation symbols.

 */
public class MostCommonWord {
    //My solution. Accepted, beat 24.75%.
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null)
            return "";
        //fix the paragraph
        String fixedParagraph = paragraph.replaceAll("[\\pP‘’“”]", " ").toLowerCase();
        List<String> listBanned = Arrays.asList(banned);
        String[] words = fixedParagraph.split(" ");
        //sort the words, then the common words gather together.
        Arrays.sort(words);
        int times = 1;
        int maxTime = Integer.MIN_VALUE;
        String res = null;
        //initialize the res
        for (String s : words){
            if (!s.equals("")){
                res = s;
                break;
            }
        }
        for (int i = 0; i < words.length-1; i++){
            //skip firs ""s.
            if (words[i].equals(""))
                continue;
            if (words[i].equals(words[i+1]) && !listBanned.contains(words[i])){
                times++;
                if (times > maxTime){
                    maxTime = times;
                    res = words[i];
                }
            }else {
                times = 1;
            }
        }
        if (maxTime == Integer.MIN_VALUE && !listBanned.contains(words[words.length-1]))
            res = words[words.length-1];
        return res;
    }

    //fastest
    public String mostCommonWord1(String paragraph, String[] banned) {
        HashMap<String,Integer> banMap=new HashMap<String,Integer>();
        for(String banStr:banned){
            banMap.put(banStr.toLowerCase(),1);
        }

        String paragraphArr[]=paragraph.split(" ");
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        for(String pa:paragraphArr){
            String t=removeSymbol(pa);
            if(banMap.get(t)==null){
                if(map.get(t)==null){
                    map.put(t,1);
                }
                else{
                    map.put(t,map.get(t)+1);
                }
            }
        }

        int max=0;
        String maxStr="";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue()>max){
                max=entry.getValue();
                maxStr=entry.getKey();
            }
        }
        return maxStr;

    }
    private final String removeSymbol(String str){
        char[] chars=str.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(char c:chars){
            if(Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    //Official solution
    public String mostCommonWord2(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }

    //Most popular
    public String mostCommonWord3(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = p.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
        for (String w : words) if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    //test
    public static void main(String[] args) {
        MostCommonWord mostCommonWord = new MostCommonWord();
        String paragraph = "abc abc? abcd the jeff!";
        String[] banned = {"abc","abcd","jeff"};

        System.out.println(mostCommonWord.mostCommonWord(paragraph, banned));
    }
}
