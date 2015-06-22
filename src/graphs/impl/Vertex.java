package graphs.impl;

/**
 * Created by farazw808 on 6/6/15.
 */
public class Vertex<V extends Comparable<V>> {

    public V data;
   boolean isVisited;


    public Vertex(V data){
        this.data=data;
    }

    public int hashCode(){

        return data.hashCode();
    }

    public boolean equals(Object other){


        if( ((Vertex)other).data.equals(data))
            return true;
        else
            return false;

    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
}
