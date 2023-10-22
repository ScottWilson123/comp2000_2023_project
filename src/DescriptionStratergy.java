import java.util.ArrayList;

public class DescriptionStratergy implements InventoryStratergy{

    ArrayList<ItemInterface> stock;

    @Override
    public ArrayList<ItemInterface> searchStrat(InventoryStratergy search, String searchTerm) {
        stock = new ArrayList<>();
        String term = searchTerm;
        ArrayList<ItemInterface> result = new ArrayList<>(stock);

        for (int i = 0; i < result.size(); i++) {
            ItemInterface curItem = result.get(i);
            if (!curItem.getDescription().contains(term)) {
                result.remove(i);
                i--;  // Go back to revisit current index on next run of loop
            }
        }
       
        return result;
    }
   
    public String toString(){

        return "Description";

    }
}
