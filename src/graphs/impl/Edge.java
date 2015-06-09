package graphs.impl;

/**
 * Created by farazw808 on 6/6/15.
 */
public class Edge {

    Vertex to;
    double weight = 1.0; //
    Vertex from;

    public Edge( Vertex from, Vertex to) {
        this.to = to;
        this.from = from;

    }

    public Edge( Vertex from, Vertex to, double weight) {
        this.to = to;
        this.from = from;
        this.weight = weight;
    }

    @Override

    public String toString() {
        return "Edge{" +

                ", to=" + to +
                " , from= "+ from+
                ", weight=" + weight +
                '}';
    }
}
