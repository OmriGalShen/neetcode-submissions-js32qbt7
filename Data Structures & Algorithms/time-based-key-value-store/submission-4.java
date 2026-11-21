class TimeMap {
    private Map<String, List<Val>> map = new HashMap<>();
    private record Val(String val, int timestamp) {}

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Val(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Val> values = map.get(key);
        if (values == null) {
            return "";
        }
        int l = 0, r = values.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            Val val = values.get(m);
            if (val.timestamp() <= timestamp) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return (r == -1) ? "" : values.get(r).val();
    }
}
