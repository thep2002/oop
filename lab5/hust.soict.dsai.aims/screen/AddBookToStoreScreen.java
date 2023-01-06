package screen;

import Cart.Cart;
import Store.store;
import media.book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(store store, Cart cart) {
        super(store, cart);

        JPanel length = super.createSubPanel("Length");
        super.centerPanel.add(length, BorderLayout.CENTER);

        btnAdd.addActionListener(new btnAddingListener());
        super.setTitle("Add Book");
    }

    private class btnAddingListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = null, category = null;
            float cost = 0;
            int length = 0;

            for(JTextField tf: tfs){
                if(tf.getName().equals("Title")){
                    title = tf.getText();
                } else if(tf.getName().equals("Category")){
                    category = tf.getText();
                } else if(tf.getName().equals("Cost")){
                    cost = Float.parseFloat(tf.getText());
                }
            }

            book book = new book(title, category, cost);
            store.add(book);
            JOptionPane.showMessageDialog(null, "Adding successful");
        }
    }
}