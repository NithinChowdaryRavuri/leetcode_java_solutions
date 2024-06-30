class UnionFind {
    private int[] parent;
    private int[] size;
    public int count;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        count = n;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int a, int b) {
        int rootA = find(a - 1), rootB = find(b - 1);
        if (rootA == rootB)
            return false;
        if (size[rootA] > size[rootB]) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        } else {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        }
        --count;
        return true;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind aliceSet = new UnionFind(n);
        UnionFind bobSet = new UnionFind(n);
        int numEdgesToRemove = 0;

        for (int[] edge : edges) {
            int type = edge[0], u = edge[1], v = edge[2];
            if (type == 3) {
                if (!aliceSet.union(u, v)) {
                    numEdgesToRemove++;
                } else {
                    bobSet.union(u, v);
                }
            }
        }

        for (int[] edge : edges) {
            int type = edge[0], u = edge[1], v = edge[2];
            if (type == 1 && !aliceSet.union(u, v)) {
                numEdgesToRemove++;
            }
            if (type == 2 && !bobSet.union(u, v)) {
                numEdgesToRemove++;
            }
        }

        return (aliceSet.count == 1 && bobSet.count == 1) ? numEdgesToRemove : -1;
    }
}