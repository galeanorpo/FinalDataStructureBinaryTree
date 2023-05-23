package Cls;

public class Pila {

    ListaSimple l1;

    public Pila() {
        this.l1 = new ListaSimple();
    }

    public void push(ArbolBinario.Nodo n) {
        this.l1.insertarAlPrincipio(n);
    }

    public ArbolBinario.Nodo pop() {
        return l1.eliminarPrimerNodo();
    }

    public boolean isEmpty() {
        return this.l1.cabeza == null;
    }
}
