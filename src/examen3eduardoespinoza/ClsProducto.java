
package examen3eduardoespinoza;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Edu
 */
public class ClsProducto {
static ArrayList<Integer> CodigoP=new ArrayList<>();
static ArrayList<Integer> CantidadP=new ArrayList<>();
static ArrayList<String> DescP=new ArrayList<>();
static ArrayList<Integer>PrecioP=new ArrayList<>();
static ArrayList<Boolean> Disponible  = new ArrayList<>();

    public ClsProducto() {
    }

public static void BuscarPorCodigo(Integer Codigo){
        
        Boolean encontrado = false;
        String Producto="No existe el producto";

        for (int i = 0; i < ClsProducto.CodigoP.size(); i++) 
        {
            
            if (ClsProducto.CodigoP.get(i).equals(Codigo)) 
            {
                encontrado = true;
                if ( ClsProducto.Disponible.get(i)) {
                    Producto="Si existe el producto";
                }
                
               JOptionPane.showMessageDialog(null, ClsProducto.CodigoP.get(i)+"\n"+ClsProducto.CantidadP.get(i)+"\n"+ ClsProducto.DescP.get(i)+"\n"+ ClsProducto.PrecioP.get(i));
               break;
            }
           
        }
                 if (!encontrado) JOptionPane.showMessageDialog(null, "NO existe");
    }

 

    public static ArrayList<Integer> getCodigoP() {
        return CodigoP;
    }

    public static void setCodigoP(Integer codigoP) {
        ClsProducto.CodigoP.add(codigoP);
    }

    public static ArrayList<Integer> getCantidadP() {
        return CantidadP;
    }

    public static void setCantidadP(Integer cantidadP) {
        ClsProducto.CantidadP.add (cantidadP);
    }

    public static ArrayList<String> getDescP() {
        return DescP;
    }

    public static void setDescP(String descP) {
        ClsProducto.DescP.add(descP);
    }

    public static ArrayList<Integer> getPrecioP() {
        return PrecioP;
    }

    public static void setPrecioP(Integer precioP) {
        ClsProducto.PrecioP.add(precioP);
    }
//public static void SetGuardar_Datos(String nomDisco, String nomProductor, String nomCantante, Integer fechaD,Integer precioD,boolean disponible)
public static void SetGuardar_Datos(Integer codigoP,Integer cantidadP,String descP,Integer precioP,boolean disponible){
CodigoP.add(codigoP);
CantidadP.add(cantidadP);
DescP.add(descP);
PrecioP.add(precioP);
Disponible.add(disponible);
}

}
