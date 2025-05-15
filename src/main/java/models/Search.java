package models;

import java.util.*;

public abstract class Search<V> {
    protected Set<Vertex<V>> visited;
    protected Map<Vertex<V>, Vertex<V>> path;
    protected final Vertex<V> source;

    public Search(Vertex<V> source) {
        this.source = source;
        visited = new HashSet<>();
        path = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<V> vertex) {
        return visited.contains(vertex);
    }

    public Iterable<Vertex<V>> pathTo(Vertex<V> v) {
        if (!hasPathTo(v)) return null;

        LinkedList<Vertex<V>> ls = new LinkedList<>();

        while (v != source) {
            ls.push(v);
            v = path.get(v);
        }
        ls.push(source);

        return ls;
    }
}
