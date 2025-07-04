package models;

import java.util.LinkedList;
import java.util.Queue;

public class BFS <V> extends Search<V>{

    public BFS(WeightedGraph<V> graph, Vertex<V> source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<V> graph, Vertex<V> source) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        super.visited.add(source);
        super.path.put(source, null);
        queue.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> popped = queue.poll();

            for (Vertex<V> v : popped.getAdjacentVertices().keySet()) {
                if (!super.visited.contains(v)) {
                    queue.add(v);
                    super.visited.add(v);
                    super.path.put(v, popped);
                }
            }
        }
    }

}
