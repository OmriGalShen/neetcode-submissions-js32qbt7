class TimeMap {
    private Map<String, List<Val>> map = new HashMap<>();

    private record Val(String value, int timestamp) {}

    // time: O(1)
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Val(value, timestamp));
    }

    // time: O(log(N))
    public String get(String key, int timestamp) {
        List<Val> values = map.get(key);
        if (values == null) {
            return "";
        }
        int l = 0, r = values.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            Val v = values.get(m);
            if (v.timestamp() == timestamp) {
                return v.value();
            } else if (v.timestamp() < timestamp) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return (r == -1) ? "" : values.get(r).value();
    }
}
