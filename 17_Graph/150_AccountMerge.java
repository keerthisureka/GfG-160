// Approach: (DSU -> Union-Find Algorithm)
// TC: O(N+E) + O(E*4ɑ) + O(N*(ElogE + E)) -> where N = no. of indices or nodes and E = no. of emails. The first term is for visiting all the emails. The second term is for merging the accounts. And the third term is for sorting the emails and storing them in the answer array.
// SC: O(N) + O(N) + O(2N) ~ O(N) -> where N = no. of nodes/indices. The first and second space is for the ‘mergedMails’ and the ‘ans’ array. The last term is for the parent and size array used inside the Disjoint set data structure.
class DSU {
    int[] parent;
    int[] size;
    DSU(int n) {
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int findParent(int x) {
        if(x == parent[x])
            return x;
        return parent[x] = findParent(parent[x]);
    }
    
    public void unionBySize(int u, int v) {
        int parent_u = findParent(u);
        int parent_v = findParent(v);
        
        if(parent_u == parent_v)
            return;
        if(size[parent_u] < size[parent_v]) {
            parent[parent_u] = parent_v;
            size[parent_v] += size[parent_u];
        }
        else {
            parent[parent_v] = parent_u;
            size[parent_u] += size[parent_v];
        }
    }
}

class Solution {
    static ArrayList<ArrayList<String>> accountsMerge(ArrayList<ArrayList<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        // Store the node to which each email belongs, if the email already exists in the map, perform union between those nodes
        HashMap<String, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++) {
            ArrayList<String> temp = accounts.get(i);
            for(int j = 1; j < temp.size(); j++) {
                if(mp.containsKey(temp.get(j))) {
                    dsu.unionBySize(i, mp.get(temp.get(j)));
                }
                else {
                    mp.put(temp.get(j), i);
                }
            }
        }
        // Merging the emails
        ArrayList<String>[] mergedMails = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            mergedMails[i] = new ArrayList<>();
        }
        for(Map.Entry<String, Integer> m : mp.entrySet()) {
            String key = m.getKey();
            int value = dsu.findParent(m.getValue());
            mergedMails[value].add(key);
        }
        // Sorting the emails and storing the name with the emails
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(mergedMails[i].size() == 0) continue;
            Collections.sort(mergedMails[i]);
            
            ArrayList<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String mail : mergedMails[i])
                temp.add(mail);
            ans.add(temp);
        }
        return ans;
    }
}