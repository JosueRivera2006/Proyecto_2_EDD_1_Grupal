
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
    public String direccionNodo(char valor, Nodo lista, String direccion) {
        if(lista.getCaracter() == valor) {
            return direccion;
        }
        if(lista.getHijos().size() == 0) {
            return "";
        }
        String segundoHijo = direccionNodo(valor, lista.getUnHijo(1), direccion + 1);
        if(!segundoHijo.isEmpty()) {
            return segundoHijo;
        }
        return direccionNodo(valor, lista.getUnHijo(0), direccion + 0);
    }
    public String decodificacion(String textDecoded, String originalText, Nodo comienzo, int contador) {
        if(comienzo.getHijos().size() == 0) {
            return decodificacion(textDecoded + comienzo.getCaracter(), originalText, this.raiz, contador++);
        }
        if(originalText.length() - 1 < contador) {
            return textDecoded;
        }
        if (originalText.charAt(contador) == '0') {
            return decodificacion(textDecoded, originalText, comienzo.getUnHijo(0), contador + 1);
        } else {
            return decodificacion(textDecoded, originalText, comienzo.getUnHijo(1), contador + 1);
        }
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
    public ArrayList<Nodo> retornarSoloLeafs(ArrayList<Nodo> hojas, Nodo nodo) {
        if(nodo.getHijos().size() == 0) {
            hojas.add(nodo);
        } else {
            for (int i = 0; i < nodo.getHijos().size(); i++) {
                retornarSoloLeafs(hojas, nodo.getUnHijo(i));
            }
        }
        return hojas;
    }
}
