package screen.Interface.controler;

import Cart.Cart;
import Store.store;
import exception.PlayerException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import media.Media;
import media.Playable;
import screen.StoreScreen;

import javax.swing.*;
import java.awt.*;

public class CartScreenController{
    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaID;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private MenuItem btnViewStore;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label costTotal;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TextField tfFilter;

    private Cart cart;
    private store store;
    public CartScreenController(store store, Cart cart){
        this.cart = cart;
        this.store = store;
    }

    @FXML
    private void initialize(){
        colMediaID.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        if (cart.getItemsOrdered()!= null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }

        if(cart.totalCost() == 0) costTotal.setText("0$");
        else costTotal.setText(cart.totalCost() + "$");

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>(){
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue){
                        if(newValue != null){
                            updateButtonBar(newValue);
                        }
                    }
                }
        );

        tfFilter.textProperty().addListener(
                new ChangeListener<String>(){
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                        showFilteredMedia(newValue);
                    }
                }
        );
    }

    void updateButtonBar(Media media){
        btnRemove.setVisible(true);
        if(media instanceof Playable){
            btnPlay.setVisible(true);
        } else{
            btnPlay.setVisible(false);
        }
    }

    void showFilteredMedia(String filter) {
        String filterType;
        if (radioBtnFilterTitle.isSelected()) {
            filterType = "title";
        } else {
            filterType = "id";
        }

        FilteredList<Media> list = new FilteredList<>(cart.getItemsOrdered(), null);
        list.setPredicate(media -> media.filterProperty(filter, filterType));

        if (cart.getItemsOrdered()!= null) {
            tblMedia.setItems(list);
        }
    }

    @FXML
    void viewStorePressed(ActionEvent event) {
        java.awt.Window win[] = java.awt.Window.getWindows();
        for(int i=0; i<win.length; i++){
            win[i].setVisible(false);
        }
        new StoreScreen(store, cart);
    }

    @FXML
    void btnPlayPressed(ActionEvent event) throws HeadlessException, PlayerException{
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        JOptionPane.showMessageDialog(null,(((Playable)media).play()));
    }

    @FXML
    void btnRemovePressed(ActionEvent event){
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        costTotal.setText(cart.totalCost() + "$");
    }

    @FXML
    void placeOrderPressed(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Order completed" + "\n" + "Total: " + cart.totalCost() + "$");
        cart.getItemsOrdered().clear();
        costTotal.setText("0$");
    }
}