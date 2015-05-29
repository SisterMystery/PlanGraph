/**
 * Created by torrentglenn on 5/28/15.
 */
import java.util.*;

public class Permutation
{
    public static ArrayList<ArrayList<Vertex>> permutations(ArrayList<Vertex> list)
    {
        return permutations(null, list, null);
    }

    public static ArrayList<ArrayList<Vertex>> permutations(ArrayList<Vertex> prefix, ArrayList<Vertex> suffix, ArrayList<ArrayList<Vertex>> output)
    {
        if(prefix == null)
            prefix = new ArrayList<Vertex>();
        if(output == null)
            output = new ArrayList<ArrayList<Vertex>>();

        if(suffix.size() == 1)
        {
            ArrayList<Vertex> newElement = new ArrayList<Vertex>(prefix);
            newElement.addAll(suffix);
            output.add(newElement);
            return output;
        }

        for(int i = 0; i < suffix.size(); i++)
        {
            ArrayList<Vertex> newPrefix = new ArrayList<Vertex>(prefix);
            newPrefix.add(suffix.get(i));
            ArrayList<Vertex> newSuffix = new ArrayList<Vertex>(suffix);
            newSuffix.remove(i);
            permutations(newPrefix,newSuffix,output);
        }

        return output;
    }
}