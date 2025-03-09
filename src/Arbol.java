
import java.util.ArrayList;


public class Arbol {
    private Nodo raiz;
    public Arbol() {
        this.raiz = null;
    }
    public void insertarEnOrden(ArrayList<Nodo> list, Nodo nuevo) {
        int contador = 0;
        if(list.size() > 0) {
            while(contador < list.size() && nuevo.getFrecuencia() > list.get(contador).getFrecuencia()) {
                contador++;
            }
            list.add(contador, nuevo);
        } else {
            list.add(nuevo);
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    public void construyendoArbol(ArrayList<Nodo> lista) {
        if(lista.size() == 1) {
            raiz = lista.get(0);
        }
        if(lista.size() >= 2) {
            Nodo temp1 = lista.get(0);
            Nodo temp2 = lista.get(1);
            Nodo padre = new Nodo();
            padre.setFrecuencia(temp1.getFrecuencia()+temp2.getFrecuencia());
            padre.agregarHijos(temp1);
            padre.agregarHijos(temp2);
            temp1.setPadre(padre);
            temp2.setPadre(padre);
            lista.remove(0);
            lista.remove(0);
            insertarEnOrden(lista, padre);
            construyendoArbol(lista);
        }
    }
    public void imprimiendoArbol(Nodo v) {
        if(v != null) {
            System.out.println(v);
            for (int i = 0; i < v.getHijos().size(); i++) {
                imprimiendoArbol(v.getUnHijo(i));
            }
        }
    }
}
