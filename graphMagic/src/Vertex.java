import java.util.ArrayList;
import java.util.Date;

/**
 * Created by torrentglenn on 5/26/15.
 */
public class Vertex {
    public int color;
    public ArrayList<Vertex> neighbors = new ArrayList<Vertex>();
    public String id;

    public Vertex(String ID){
        id = ID;
        color = 0;
    }

    public void setId(String ID){
        id = ID;
    }
    public String getId(){
        return id;
    }


    public void setColor(int color){
        this.color = color;
    }
    public int getColor(){ return color; }

    public ArrayList<Vertex> getNeighbors(){ return neighbors; }

    public Vertex rmNeighbor(Vertex v){
        return neighbors.remove(neighbors.indexOf(v));
    }

    public void addNeighbor(Vertex v){
        if (!neighbors.contains(v) && v != this) {
            neighbors.add(v);
            v.addNeighbor(this);
        }
    }
}
