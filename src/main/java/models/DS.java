package models;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DS<V> extends Search<V> {
    public DS(WeightedGraph<V> graph, Vertex<V> source) {
        super(source);
        ds(graph, source);
    }

    public void ds(WeightedGraph<V> graph, Vertex<V> source) {
        PriorityQueue<Edge<V>> minQueue = new PriorityQueue<>(Comparator.comparingDouble(e -> e.weight));
        minQueue.add(new Edge<>(source, 0.0));
        Map<Vertex<V>, Double> distances = new HashMap<>();

        for (Vertex<V> v : graph.getSet()) {
            distances.put(v, Double.MAX_VALUE);
        }

        distances.put(source, 0.0);

        while (!minQueue.isEmpty()) {
            Edge<V> popped = minQueue.poll();

            if (super.visited.contains(popped.vertex)) {
                continue;
            }

            super.visited.add(popped.vertex);

            for (Map.Entry<Vertex<V>, Double> entry : popped.vertex.getAdjacentVertices().entrySet()) {
                double newWeight = popped.weight + entry.getValue();

                if (newWeight < distances.get(entry.getKey())) {
                    distances.put(entry.getKey(), newWeight);
                    super.path.put(entry.getKey(), popped.vertex);
                    minQueue.add(new Edge<>(entry.getKey(), newWeight));
                }
            }
        }
    }

    private class Edge<V> {
        private Vertex<V> vertex;
        private double weight;

        public Edge(Vertex<V> vertex, double weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}

