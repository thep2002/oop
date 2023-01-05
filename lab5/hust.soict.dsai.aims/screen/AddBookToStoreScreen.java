package screen;

import Cart.Cart;
import Store.store;

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
                } else if(tf.getName().equals("Length")){
                    length = Integer.parseInt(tf.getText());
                } else if(tf.getName().equals("Cost")){
                    cost = Float.parseFloat(tf.getText());
                }
            }

            JOptionPane.showMessageDialog(null, "Adding successful");
        }
    }
}