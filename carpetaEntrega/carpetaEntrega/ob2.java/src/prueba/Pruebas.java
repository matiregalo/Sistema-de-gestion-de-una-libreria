 //Matias Regalo 308940 | Juan Constantin 335718
package prueba;
//ultimo
import dominio.Sistema;
import interfaz.Menu;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;

public class Pruebas {

    public static void main(String[] args) {
        Sistema unSistema;
        int respuesta = JOptionPane.showConfirmDialog(null, 
                "Desea cargar los datos guardados en la ultima ejecucion?", 
                "Confirmación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            try {
                FileInputStream ff = new FileInputStream("ArchivoOb.ser");
                ObjectInputStream in = new ObjectInputStream(ff);
                unSistema = (Sistema) in.readObject();
                in.close();
            } catch (IOException | ClassNotFoundException f) {
                JOptionPane.showMessageDialog(null, "Error de serializacion, se cargará el programa sin datos preguardados", "Error", JOptionPane.ERROR_MESSAGE);
                unSistema = new Sistema();
            }

        } else {
            unSistema = new Sistema();
        }
        Menu prueba = new Menu(unSistema);
        prueba.setVisible(true);
        
    }
}
