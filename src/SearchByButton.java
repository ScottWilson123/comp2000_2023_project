import javax.swing.JRadioButton;

public class SearchByButton extends JRadioButton {

    public SearchByButton(InventoryStratergy name, Runnable onSelection) {
        //super(name);
        addActionListener((e) -> onSelection.run());
    }
}
