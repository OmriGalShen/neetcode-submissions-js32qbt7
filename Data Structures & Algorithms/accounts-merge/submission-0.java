class Solution {
    private static class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // time: O(alpha(V)) ~ O(1)
        public int find(int v) {
            if (parent[v] != v) { // path comprassion
                return find(parent[v]);
            }
            return parent[v];
        }

        // time: O(alpha(V)) ~ O(1)
        public boolean union(int v, int u) {
            int rootV = find(v);
            int rootU = find(u);
            if (rootV == rootU) {
                return false;
            }
            if (size[rootV] < size[rootU]) {
                parent[rootV] = rootU;
                size[rootU] += size[rootV];
            } else {
                parent[rootU] = rootV;
                size[rootV] += size[rootU];
            }
            return true;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        // map email -> account id
        // if email already in map perfome union
        Map<String, Integer> emailToAccountId = new HashMap<>();
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToAccountId.containsKey(email)) {
                    int prexisitngAccountId = emailToAccountId.get(email);
                    uf.union(i, prexisitngAccountId);
                } else {
                    emailToAccountId.put(email, i);
                }
            }
        }

        // iterate over account -> create a map between root account id to list of emails
        Map<Integer, List<String>> accountIdToEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToAccountId.entrySet()) {
            int accountId = entry.getValue();
            String email = entry.getKey();
            int rootAccountId = uf.find(accountId);
            accountIdToEmails.computeIfAbsent(rootAccountId, k -> new ArrayList<>()).add(email);
        }

        // create response format
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : accountIdToEmails.entrySet()) {
            int accountId = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            String name = accounts.get(accountId).get(0);
            List<String> accountList = new ArrayList<>();
            accountList.add(name);
            accountList.addAll(emails);
            result.add(accountList);
        }

        return result;
    }
}