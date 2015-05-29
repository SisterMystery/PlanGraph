import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by torrentglenn on 5/26/15.
 */
public class Graph {
    public HashMap<String, Vertex> vertexHashMap = new HashMap<String, Vertex>();

    public Graph(HashMap<String, Vertex> vhm){
        vertexHashMap = vhm;
    }

    public Graph(ArrayList<Vertex> V){
        for (Vertex v: V){
            vertexHashMap.put(v.getId(),v);
        }
    }

    public ArrayList<Vertex> getVertices(){
        ArrayList<Vertex> vlist = new ArrayList<Vertex>();
        for(Map.Entry e: vertexHashMap.entrySet()){
            vlist.add((Vertex)e .getValue());
        }
        return (ArrayList<Vertex>) vlist.clone();
    }

    public int getNumColors(){
        int i = 0;
        for(Vertex v: getVertices()){
            if (v.getColor() > i)
                i = v.getColor();
        }

        return i;
    }

    public void addVertex(Vertex v){
        vertexHashMap.put(v.getId(),v);
    }

    public void addVertex(String vID){
        Vertex v = new Vertex(vID);
        vertexHashMap.put(v.getId(),v);
    }




}
