import javax.swing.JFrame;

public class App {
    private Player player;
    private Storage storage;
    private JFrame frame;
    private PageManager manager;
    private InventoryStratergy strat;
    private InventoryStratergy stratname;
    private InventoryStratergy stratDesc;
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
      
        page.addSearchByButton(new SearchByButton(strat, () -> {
            player.getInventory().setSearch(strat);
            player.getStorageView().setSearch(strat);
        }));

        page.addSearchByButton(new SearchByButton(stratname, () -> {
            player.getInventory().setSearch(stratname);
            player.getStorageView().setSearch(stratname);
        }));

        page.addSearchByButton(new SearchByButton(stratDesc, () -> {
            player.getInventory().setSearch(stratDesc);
            player.getStorageView().setSearch(stratDesc);
        }));
    }

    void setupCrafting(ItemCraftPage page, Player player) {
        page.setCraftAction((def) -> System.out.println("Crafting not implemented"));
    }

    void setupUncrafting(ProductPage page, Player player) {
        page.setUncraftAction((item) -> System.out.println("Uncrafting not implemented"));
    }
}
