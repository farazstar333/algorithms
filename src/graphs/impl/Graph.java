package graphs.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Created by farazw808 on 6/6/15.
 */
public class Graph<V extends Comparable<V>> {

    Map<Vertex<V>, List<Edge>> graphMap = new HashMap();
    boolean isDirected = false;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }


    public Vertex<V> addVertex(V data) {

        Vertex<V> vertex = null;

        vertex = new Vertex<>(data);
        graphMap.put(vertex, new ArrayList<Edge>());


        return vertex;

    }

    public Vertex<V> addVertex(Vertex vertex) {


        graphMap.put(vertex, new ArrayList<Edge>());


        return vertex;

    }

    public int indegree(V vertex) {

        int inCounter = 0;
        // Iterate through all vertexes in system and for any edge for which v exist as "to" edge increase the counter
        for (Vertex aVertex : graphMap.keySet()) {

            List<Edge> edgeList = graphMap.get(vertex);
            for (Edge edge : edgeList) {

                if (edge.to.equals(vertex)) inCounter++;
            }

        }

        return inCounter;
    }

    public int outdegree(V vertex) {
        return graphMap.get(vertex) != null ? graphMap.get(new Vertex<V>(vertex)).size() : 0;
    }



    public List<Edge> getOutgoingEdges(Vertex from) {
        return graphMap.get(from);
    }


    public Edge addEdge(Vertex<V> from, Vertex<V> to) {

        if (!graphMap.containsKey(to)) {
            to = addVertex(to.data);
        }

        if (!graphMap.containsKey(from)) {
            from = addVertex(from.data);
        }
        //try record the edge in the graph
        // if key is the form vertex, edge will be in the data
        Edge newEdge = new Edge(from, to);
        graphMap.get(from).add(newEdge);

        if (!this.isDirected) {
            graphMap.get(to).add(new Edge(to, from));
        }

        return newEdge;
    }


    public Edge addEdge( V from, V to) {

        Vertex<V> fromV = new Vertex(from);
        Vertex<V>  toV = new Vertex<>(to);
        if (!graphMap.containsKey(to)) {
             addVertex(toV);
        }

        if (!graphMap.containsKey(from)) {
            addVertex(fromV);
        }
        //try record the edge in the graph
        // if key is the form vertex, edge will be in the data
        Edge newEdge = new Edge(fromV, toV);
        graphMap.get(from).add(newEdge);

        if (!this.isDirected) {
            graphMap.get(to).add(new Edge(toV, fromV));
        }

        return newEdge;
    }

    /**
     * Trick is to use a stack and keep track of visisted nodes
     */
    public void dfs(Vertex startNode) {

        Set<Vertex> visitedSet = new HashSet<>();
        Stack<Vertex> vertexStack = new Stack<>();
        vertexStack.add(startNode);  // push first node
        // start from startNode
        while (!vertexStack.empty()) {

            Vertex vertex = vertexStack.pop();

            if (!visitedSet.contains(vertex)) {  // if it not visited print it and add to visited set

                System.out.println("the value of node " + vertex.data);
                visitedSet.add(vertex);

            }

            // now get outdegree of this node and add them back to stock.

            for (Edge edge : this.getOutgoingEdges(vertex)) {

                Vertex to = edge.to;
                if (!visitedSet.contains(to)) {
                    vertexStack.add(to);
                }
            }


        }


    }

    /**
     * Trick is to use a queue and keep track of visisted nodes
     */
    public void bfs(Vertex startNode) {

        Set<Vertex> visitedSet = new HashSet<>();
        Queue<Vertex> vertexQueue = new ArrayDeque<>();
        vertexQueue.add(startNode);  // push first node
        // start from startNode
        while (!vertexQueue.isEmpty()) {

            Vertex vertex = vertexQueue.poll();

            if (!visitedSet.contains(vertex)) {  // if it not visited print it and add to visited set

                System.out.println("the value of node " + vertex.data);
                visitedSet.add(vertex);

            }

            // now get outdegree of this node and add them back to stock.

            for (Edge edge : this.getOutgoingEdges(vertex)) {

                Vertex to = edge.to;
                if (!visitedSet.contains(to)) {
                    vertexQueue.add(to);
                }
            }


        }


    }

    public static void main(String[] args) {

        Graph graph = new Graph(true); // it is directed graph

        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v1 = new Vertex(1);


        graph.addEdge(v2, v4);
        graph.addEdge(v2, v3);
        graph.addEdge(v1, v4);
        graph.addEdge(v4, v3);

        graph.bfs(new Vertex(2));


    }


}
