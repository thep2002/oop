package screen.Interface.controler;

import Cart.Cart;
import Store.store;

import java.io.IOException;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
    private Cart cart;
    private store store;

    public CartScreen(store store, Cart cart){
        this.cart = cart;
        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Cart");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run(){
                try{
                    FXMLLoader loader = new FXMLLoader(getClass()
                            .getResource("/hust/soict/dsai/aims/screen/Interface/view/cart.fxml"));
                    loader.setController(new CartScreenController(store, cart));
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}