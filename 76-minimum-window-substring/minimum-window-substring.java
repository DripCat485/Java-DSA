class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length())
            return "";

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int count = t.length();
        int start = 0;
        int min = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                if (map.get(ch) > 0)
                    count--;

                map.put(ch, map.get(ch) - 1);
            }

            while (count == 0) {

                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }

                char c = s.charAt(left);

                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);

                    if (map.get(c) > 0)
                        count++;
                }

                left++;
            }
        }

        if (min == Integer.MAX_VALUE)
            return "";

        return s.substring(start, start + min);
    }
}