class UnionFind {
    int[] parents;
    
    public UnionFind(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parents[rootY] = rootX;
        }
    }
}
class Solution {   
    UnionFind unionFind;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        unionFind = new UnionFind(accounts.size());
        // Use UnionFind to merge each account records in "accounts"
        Map<String, Integer> mailMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) { 
            List<String> mails = accounts.get(i);
            String name = mails.get(0);
            for (int j = 1; j < mails.size(); j++) {
                String mail = mails.get(j);
                if (!mailMap.containsKey(mail)) {
                    mailMap.put(mail, i);
                } else {
                    unionFind.union(i, mailMap.get(mail));
                }
            }
        }
        // merging mails into parent id
        Map<Integer, List<String>> mergedMailMap = new HashMap<>();
        for (Map.Entry<String, Integer> e : mailMap.entrySet()) { 
            String mail = e.getKey();
            int id = e.getValue();
            int parent = unionFind.find(id);
            List<String> mailList = mergedMailMap.get(parent);
            if (mailList == null)
                mailList = new ArrayList<>();
            mailList.add(mail);
            mergedMailMap.put(parent, mailList);
        }
        // get all mail list and sort them
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> e : mergedMailMap.entrySet()) {
            int id = e.getKey();
            List<String> mailList = e.getValue();
            Collections.sort(mailList);
            String name = accounts.get(id).get(0);
            mailList.add(0, name);
            res.add(mailList);
        }
        return res;
    }
}