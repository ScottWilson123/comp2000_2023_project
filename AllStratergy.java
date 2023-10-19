import java.util.ArrayList;

public class AllStratergy implements InventoryStratergy {
    ArrayList<ItemInterface> stock;
    @Override
    public ArrayList<ItemInterface> searchItems(InventoryStratergy search) {
        stock = new ArrayList<>();
        String term = "All";
        ArrayList<ItemInterface> result = new ArrayList<>(stock);

        for (int i = 0; i < result.size(); i++) {
            ItemInterface curItem = result.get(i);
            if (!curItem.getName().contains(term) && !curItem.getDescription().contains(term)) {
                result.remove(i);
                i--;  // Go back to revisit current index on next run of loop
                
            }
        }
        return result;
    
    }
   
        public String toString(){

            return "All";

        }
    


}
