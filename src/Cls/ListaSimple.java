package Cls;

class Nodo {
    ArbolBinario.Nodo informacion;
    Nodo siguiente;

    public Nodo(ArbolBinario.Nodo informacion) {
        this.informacion = informacion;
        this.siguiente = null;
    }
}

public class ListaSimple {
    Nodo cabeza;
    Nodo cola;

    public ListaSimple() {
        this.cabeza = null;
        this.cola = null;
    }

    public void insertarAlPrincipio(ArbolBinario.Nodo i) {
        Nodo nodo = new Nodo(i);
        if (this.cabeza == null && this.cola == null) {
            this.cola = nodo;
        } else {
            nodo.siguiente = this.cabeza;
        }
        this.cabeza = nodo;
    }

    public void insertarAlFinal(ArbolBinario.Nodo i) {
        Nodo nodo = new Nodo(i);
        if (this.cabeza == null && this.cola == null) {
            this.cabeza = nodo;
        } else {
            this.cola.siguiente = nodo;
        }
        this.cola = nodo;
    }

    public ArbolBinario.Nodo eliminarPrimerNodo() {
        ArbolBinario.Nodo r = null;
        if (this.cabeza != null && this.cola != null) {
            Nodo duplicado = this.cabeza;
            r = duplicado.informacion;
            if (this.cabeza == this.cola) {
                this.cabeza = null;
                this.cola = null;
            } else {
                this.cabeza = cabeza.siguiente;
            }
            duplicado.siguiente = null;
            duplicado = null;
        }
        return r;
    }

    public void mostrarLista() {
        Nodo actual = this.cabeza;
        if (this.cabeza != null && this.cola != null) {
            while (actual != null) {
                System.out.println(actual.informacion);
                actual = actual.siguiente;
            }
        }
    }
}
