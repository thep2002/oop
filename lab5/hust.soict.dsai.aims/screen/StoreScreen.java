package screen;

import Cart.Cart;
import Store.store;
import media.CompactDisc;
import media.DigitalVideoDisc;
import media.Media;
import screen.Interface.controler.CartScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreScreen extends JFrame{
    private store store;
    public static Cart cart;

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookMenu = new JMenuItem("Add Book");
        addBookMenu.addActionListener(new btnMenuListener());
        JMenuItem addDvdMenu = new JMenuItem("Add DVD");
        addDvdMenu.addActionListener(new btnMenuListener());
        JMenuItem addCdMenu = new JMenuItem("Add CD");
        addCdMenu.addActionListener(new btnMenuListener());

        smUpdateStore.add(addBookMenu);
        smUpdateStore.add(addDvdMenu);
        smUpdateStore.add(addCdMenu);
        menu.add(smUpdateStore);

        menu.add(new JMenuItem("View store"));

        JMenuItem cart = new JMenuItem("View cart");
        cart.addActionListener(new btnViewCart());
        menu.add(cart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());

        return header;
    }

    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for(int i=0; i<mediaInStore.size(); i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    private class btnMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if (command.equals("Add DVD")) {
                new AddDigitalVideoDiscToStoreScreen(store, cart);
            } else if (command.equals("Add Book")) {
                new AddBookToStoreScreen(store, cart);
            } else if (command.equals("Add CD")) {
                new AddCompactDiscToStoreScreen(store, cart);
            } else if (command.equals("View Store")) {
                new StoreScreen(store, cart);
            }
            dispose();
        }
    }

    private class btnViewCart implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            setVisible(false);
            new CartScreen(store, cart);
        }
    }

    public StoreScreen(store store, Cart cart){
        StoreScreen.cart = cart;
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public static void main(String[] args) {
        store store = new store();
        Cart cart = new Cart();
        DigitalVideoDisc dvd_1 = new DigitalVideoDisc("The Lion King", "Animation",
                19.95f, 87, "Roger Allers");
        store.add(dvd_1);
        DigitalVideoDisc dvd_2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
                19.95f, 87, "George Lucas");
        store.add(dvd_2);
        CompactDisc cd_1 = new CompactDisc("Famous Friends", "Music",
                14.97f, 90, null, "Chris");
        store.add(cd_1);


        new StoreScreen(store, cart);
    }
}