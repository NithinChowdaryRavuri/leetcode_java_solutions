import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class Solution {
    private int size;

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        this.size = k;

        List<Integer> rowOrder = getOrder(rowConditions);
        List<Integer> colOrder = getOrder(colConditions);

        if (rowOrder == null || colOrder == null) {
            return new int[0][0];
        }

        int[][] matrix = new int[size][size];
        int[] columnMapping = new int[size + 1];

        for (int i = 0; i < size; ++i) {
            columnMapping[colOrder.get(i)] = i;
        }

        for (int i = 0; i < size; ++i) {
            matrix[i][columnMapping[rowOrder.get(i)]] = rowOrder.get(i);
        }

        return matrix;
    }

    private List<Integer> getOrder(int[][] conditions) {
        List<Integer>[] graph = new List[size + 1];

        Arrays.setAll(graph, element -> new ArrayList<>());

        int[] incomingEdges = new int[size + 1];

        for (var edge : conditions) {
            int from = edge[0], to = edge[1];
            graph[from].add(to);
            ++incomingEdges[to];
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= size; i++) {
            if (incomingEdges[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.pollFirst();
            order.add(vertex);

            for (int neighbor : graph[vertex]) {
                if (--incomingEdges[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return order.size() == size ? order : null;
    }
}