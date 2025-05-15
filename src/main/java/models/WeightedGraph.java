package models;

import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<V> {
    private Set<Vertex<V>> set;
    private boolean directed;


    public WeightedGraph() {
        this(false);
    }

    public WeightedGraph(boolean directed) {
        set = new HashSet<>();
        this.directed = directed;
    }

    public Set<Vertex<V>> getSet() {
        return set;
    }

    public void addVertex(Vertex<V> v) {
        set.add(v);
    }

    public int size() {
        return set.size();
    }

    public void addEdge(Vertex<V> src, Vertex<V> dst, double weight)  {
        set.add(src);
        set.add(dst);
        Vertex<V> source = set.stream().filter(v -> v.equals(src)).findFirst().get();
        Vertex<V> destination = set.stream().filter(v -> v.equals(dst)).findFirst().get();
        source.addAdjacentVertex(destination, weight);

        if (!directed) {
            destination.addAdjacentVertex(source, weight);
        }
    }












}
