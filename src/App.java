import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import javax.swing.JFrame;

public class App implements Iterable<ArrayList<ItemInterface>>{
    private Player player;
    private Storage storage;
    private JFrame frame;
    private PageManager manager;
    private InventoryStratergy strat;
    private InventoryStratergy stratname;
    private InventoryStratergy stratDesc;
    ArrayList<ItemInterface> inData = new ArrayList<>();
    public App(Player p, Storage s) {
        player = p;
        storage = s;

        player.setStorageView(storage.getInventory());

        manager = new PageManager(player, storage);

        // Setup of sorting
        setupSearching((InventoryPage) manager.findPage("Player Inventory"));
        setupSearching((InventoryPage) manager.findPage("Storage"));

        // Setup of craftng
        setupCrafting((ItemCraftPage) manager.findPage("Item Crafting"), player);
        setupUncrafting((ProductPage) manager.findPage("Product Page"), player);

        // Window creation
        manager.refresh();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(manager.getJPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Task 1: Defining what each button in the UI will do.
    void setupSearching(InventoryPage page) {
      this.strat = new AllStratergy();
      this.stratname = new NameStratergy();
      this.stratDesc = new DescriptionStratergy();

        page.addSearchByButton(new SearchByButton(strat.toString(), () -> {
            player.getInventory().setSearch(strat);
            player.getStorageView().setSearch(strat);
        }));

        page.addSearchByButton(new SearchByButton(stratname.toString(), () -> {
            player.getInventory().setSearch(stratname);
            player.getStorageView().setSearch(stratname);
        }));

        page.addSearchByButton(new SearchByButton(stratDesc.toString(), () -> {
            player.getInventory().setSearch(stratDesc);
            player.getStorageView().setSearch(stratDesc);
        }));
    }

    void setupCrafting(ItemCraftPage page, Player player) {
        page.setCraftAction((def) -> crafting());
    }

    void setupUncrafting(ProductPage page, Player player) {
        page.setUncraftAction((item) -> System.out.println("Uncrafting not implemented"));
    }


    public Optional<ArrayList<ItemInterface>> crafting(){
         ArrayList<ItemInterface> data = inData;
        if(inData == data){
            return Optional.of(inData);
        } else {
        return Optional.empty();
        }
    }
    @Override
    public CraftIterator iterator(){
        return new CraftIterator(inData);
    }

   
}
