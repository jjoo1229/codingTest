import java.io.*;
import java.util.*;
 
public class Solution {
    public static int t, k;
    public static StringBuilder sb = new StringBuilder();
 
    public static class TrieNode {
        Map<Character, TrieNode> childNode = new TreeMap<>();
 
        public TrieNode() {}
 
        public void insert(String word) {
            TrieNode trieNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
 
                // childNode에 c 없으면 추가
                trieNode.childNode.putIfAbsent(c, new TrieNode());
                trieNode = trieNode.childNode.get(c);
            }
        }
 
        public List<String> getWordsAlphabetical() {
            List<String> result = new ArrayList<>();
            // 빈 문자열부터 시작해서 모든 단어를 찾아 나간다
            traverse(this, "", result);
            return result;
        }
 
        private void traverse(TrieNode node, String currentWord, List<String> result) {
            // 1. 현재 노드 리스트에 추가
            result.add(currentWord);
 
            // 2. 자식 노드들 가져오기
            List<Character> keys = new ArrayList<>(node.childNode.keySet());
 
            // 3. 정렬된 순서대로 다음 노드 방문 (재귀)
            for (char c : keys) {
                traverse(node.childNode.get(c), currentWord + c, result);
            }
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            k = Integer.parseInt(br.readLine());
            String line = br.readLine();
 
            TrieNode root = new TrieNode();
            for (int i = 0; i < line.length(); i++) {
                root.insert(line.substring(i));
            }
 
            List<String> sortedWords = root.getWordsAlphabetical();
//          System.out.println(sortedWords.size());
            String answer = (sortedWords.size() < k + 1) ? "none" : sortedWords.get(k);
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }
}