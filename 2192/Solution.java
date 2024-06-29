import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class Solution {
    private int numVertices;
    private List<Integer>[] graph;
    private List<List<Integer>> ancestors;

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        numVertices = n;
        graph = new List[n];
        Arrays.setAll(graph, i -> new ArrayList<>());

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        ancestors = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            ancestors.add(new ArrayList<>());
        }

        for (int i = 0; i < n; ++i) {
            bfs(i);
        }
        return ancestors;
    }

    private void bfs(int index) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(index);
        boolean[] visited = new boolean[numVertices];
        visited[index] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int adjacentNode : graph[node]) {
                if (!visited[adjacentNode]) {
                    visited[adjacentNode] = true;
                    queue.offer(adjacentNode);
                    ancestors.get(adjacentNode).add(index);
                }
            }
        }
    }

}