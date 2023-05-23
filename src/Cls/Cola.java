package Cls;

public class Cola {

    ListaSimple l1;

    public Cola() {
        this.l1 = new ListaSimple();
    }

    public void insert(ArbolBinario.Nodo a) {
        this.l1.insertarAlFinal(a);
    }

    public ArbolBinario.Nodo remove() {
        return l1.eliminarPrimerNodo();
    }

    public boolean isEmpty() {
        return this.l1.cabeza == null;
    }

    public void showQ() {
        this.l1.mostrarLista();
    }

}
