import java.util.ArrayList;
import java.util.Iterator;

public class CraftIterator implements Iterator<ArrayList<ItemInterface>> {

    ArrayList<ItemInterface> data;
    double weight;
    boolean runOut;
    int i=0;
    public CraftIterator(ArrayList<ItemInterface> inData){
     data = inData;
    
     runOut = false;
        
    }

    @Override
    public boolean hasNext() {
       return !runOut;
    }

    @Override
    public ArrayList<ItemInterface> next() {
        ArrayList<ItemInterface> ret = data;
        
        if(ret.size() == 1){
            weight += weight;
            i++;
                }
        if(i == ret.size())
        runOut = true;
        return ret;
    }
    
}
