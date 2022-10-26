import javax.swing.JOptionPane;
public class ChosingOption{
    public static void main(String[] args){
        int option = JOptionPane.showConfirmDialog(null, args, "dfdjfnj", 0);
        JOptionPane.showMessageDialog(null,"You 've chosen: "+ (option==JOptionPane.YES_OPTION?"Yes":"NO"));
    System.exit(0);
    }
}