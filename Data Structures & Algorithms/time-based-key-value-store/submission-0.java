class TimeMap {
    record Val(String val, int timestamp) {
    }

    private final Map<String, List<Val>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Val(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Val> list = map.get(key);
        int l = 0, r = list.size() - 1;
        String res = "";
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (list.get(m).timestamp() <= timestamp) {
                res = list.get(m).val();
                l = m + 1;
            } else {
                r = m - 1;
            }

        }
        return res;
    }
}
