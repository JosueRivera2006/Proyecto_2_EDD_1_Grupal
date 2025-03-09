
import java.util.ArrayList;


public class Nodo {
    private Nodo padre;
    private ArrayList<Nodo> hijos;
    private int frecuencia;
    private char caracter;
    public Nodo() {
        this.padre = null;
        this.hijos = new ArrayList<Nodo>();
        this.caracter = '\0';
        this.frecuencia = 0;
    }

    public Nodo getPadre() {
        return padre;
    }
    
    public Nodo getUnHijo(int posicion) {
        return hijos.get(posicion);
    }
    
    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public void agregarHijos(Nodo nuevo) {
        this.hijos.add(nuevo);
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    @Override
    public String toString() {
        if(this.padre == null) {
            return  "Caracter: " + caracter +", Frecuencia: " + frecuencia;
        }
        return  "Caracter: " + caracter +", Frecuencia: " + frecuencia + ", La frecuencia de mi padre es: " + this.padre.getFrecuencia();
    }
    
}
