package graphs.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by farazw808 on 6/7/15.
 */
public class ACyclicGraph<V> extends Graph {


    public ACyclicGraph(boolean directed) {

        super(directed);
    }


    boolean findIfCyclicGraph(Vertex<Integer> vertex) {

        // input is graph and vertex to start with.  It will return a true or false depend upon if there is cycle in graph.
        // trick is do DFS while mantaining a stack to  parent node as well.

        Stack<Vertex> dfsStack = new Stack<>();
        Stack<Vertex> parentStack = new Stack<>();
        Set<Vertex> visited = new HashSet();

        // put current node in visitedStack

        dfsStack.push(vertex);
        parentStack.push(null); // the parent of start node is null.


        while (!dfsStack.empty()) // as long as there is node in stack.
        {

            Vertex visiting = dfsStack.pop();
            Vertex parent = parentStack.pop();
            List<Edge> edgeList = getOutgoingEdges(visiting);

            for (Edge edge : edgeList) {

                Vertex to = edge.to;
                // if 2 is
                if (visited.contains(to) && !to.equals(parent)) return true;

                // now mark to as visited and set new parent

                visited.add(to);
                parentStack.push(visiting);
                dfsStack.push(to);


            }


        }


        return false; // if we pass through it it means we have not detected any cycle.


    }

    public static void main(String[] args) {
        ACyclicGraph<Integer> graph = new ACyclicGraph(true);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);

        System.out.println(graph.findIfCyclicGraph(new Vertex<Integer>(2)));

    }


}
