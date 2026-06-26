class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);

            String key = new String(ch);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(strs[i]);
        }

        List<List<String>> ans = new ArrayList<>();

        for (List<String> list : map.values()) {
            ans.add(list);
        }

        return ans;
    }
}