import models.*;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);

        graph.addEdge(a, b, 10);
        graph.addEdge(a, c, 1);
        graph.addEdge(c, d, 1);
        graph.addEdge(d, b, 1);

        Search<String> djk = new DS<>(graph, a);

        for (Vertex<String> v : djk.pathTo(b)) {
            System.out.println(v);
        }
    }
}

