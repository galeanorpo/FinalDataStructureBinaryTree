package Cls;

public class ArbolBinario {

    class Nodo {
        String info;
        Nodo derecha;
        Nodo izquierda;

        public Nodo(String info) {
            this.info = info;
            this.derecha = null;
            this.izquierda = null;
        }
    }

    public Nodo raiz;
    private int contador;

    public ArbolBinario() {
        this.raiz = null;
        this.contador = 0;
    }

    public void insertarNodo(String i) {
        Nodo nodo = new Nodo(i);
        Nodo actual = this.raiz;
        if (actual == null) {
            this.raiz = nodo;
        } else {
            while (actual != null) {
                if (nodo.info.compareTo(actual.info) < 0) {
                    actual = actual.derecha;
                    if (actual.izquierda == null) {
                        actual.izquierda = nodo;
                        break;
                    } else {
                        actual = actual.izquierda;
                    }
                } else {
                    if (actual.derecha == null) {
                        actual.derecha = nodo;
                        break;
                    } else {
                        actual = actual.derecha;
                    }
                }
            }
        }
        this.contador++;
    }

    public void insertarIzquierda(Nodo raiz, String dato) {
        Nodo n = new Nodo(dato);
        raiz.izquierda = n;
    }

    public void insertarDerecha(Nodo raiz, String dato) {
        Nodo n = new Nodo(dato);
        raiz.derecha = n;
    }

    public void buscarNodo(Nodo raiz, String referencia) {
        if (raiz != null) {
            Pila p = new Pila();
            p.push(raiz);
            while (!p.isEmpty()) {
                Nodo actual = p.pop();
                if (actual.info.equals(referencia)) {
                    System.out.println("Nodo encontrado " + actual.info);
                }
                if (actual.derecha != null) {
                    p.push(actual.derecha);
                }
                if (actual.izquierda != null) {
                    p.push(actual.izquierda);
                }
            }
        }
    }

    public void eliminarNodo(String valor) {
        raiz = eliminarNodo(raiz, valor);
        this.contador--;
    }

    private Nodo eliminarNodo(Nodo nodo, String valor) {
        if (nodo == null) {
            return nodo;
        }
        // Recorrer el árbol para encontrar el nodo con el valor deseado
        if (valor.compareTo(nodo.info) < 0) {
            nodo.izquierda = eliminarNodo(nodo.izquierda, valor);
        } else if (valor.compareTo(nodo.info) > 0) {
            nodo.derecha = eliminarNodo(nodo.derecha, valor);
        } else {
            // Caso 1: El nodo a eliminar no tiene hijos
            if (nodo.izquierda == null && nodo.derecha == null) {
                nodo = null;
            }
            // Caso 2: El nodo a eliminar tiene un hijo
            else if (nodo.izquierda == null) {
                nodo = nodo.derecha;
            } else if (nodo.derecha == null) {
                nodo = nodo.izquierda;
            }
            // Caso 3: El nodo a eliminar tiene dos hijos
            else {
                Nodo sucesor = encontrarSucesor(nodo.derecha);
                nodo.info = sucesor.info;
                nodo.derecha = eliminarNodo(nodo.derecha, sucesor.info);
            }
        }
        return nodo;
    }

    private Nodo encontrarSucesor(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.izquierda != null) {
            actual = actual.izquierda;
        }
        return actual;
    }

    public void imprimirPosorden(Nodo raiz) {
        if (raiz != null) {
            imprimirPosorden(raiz.izquierda);
            imprimirPosorden(raiz.derecha);
            System.out.println(raiz.info);
        }
        System.out.println("Cantidad de nodos en el arbol: " + conteoNodos());
    }

    public void imprimirPreorden(Nodo raiz) {
        if (raiz != null) {
            Pila p = new Pila();
            p.push(raiz);
            while (!p.isEmpty()) {
                Nodo actual = p.pop();
                System.out.println(actual.info + " ");
                if (actual.derecha != null) {
                    p.push(actual.derecha);
                }
                if (actual.izquierda != null) {
                    p.push(actual.izquierda);
                }
            }
            System.out.println();
        }
        System.out.println("Cantidad de nodos en el arbol: " + conteoNodos());
    }

    public void imprimirInorden(Nodo raiz) {
        if (raiz != null) {
            imprimirInorden(raiz.izquierda);
            System.out.println(raiz.info);
            imprimirInorden(raiz.derecha);
        }
        System.out.println("Cantidad de nodos en el arbol: " + conteoNodos());
    }

    public int conteoNodos() {
        return this.contador;
    }

    public void profundidadArbol(Nodo raiz) {
        if (raiz != null) {
            Cola cola = new Cola();
            cola.insert(raiz);
            while (!cola.isEmpty()) {
                Nodo n = cola.remove();
                System.out.println(n.info + " ");
                if (n.izquierda != null) {
                    cola.insert(n.izquierda);
                }
                if (n.derecha != null) {
                    cola.insert(n.derecha);
                }
            }
        }
        System.out.println("Cantidad de nodos en el arbol: " + conteoNodos());
    }

    public void construirArbol(String expresion) {
        this.raiz = null;
        Nodo[] pila = new Nodo[expresion.length()];
        int top = -1; // Índice del tope de la pila
        for (int i = expresion.length() - 1; i >= 0; i--) {
            String simbolo = expresion.substring(i, i + 1);
            if (esOperador(simbolo)) {
                Nodo nodo = new Nodo(simbolo);
                nodo.izquierda = pila[top--];
                nodo.derecha = pila[top--];
                pila[++top] = nodo;
            } else {
                pila[++top] = new Nodo(simbolo);
            }
        }
        this.raiz = pila[top];
    }

    private boolean esOperador(String simbolo) {
        return simbolo.equals("+") || simbolo.equals("-") ||
                simbolo.equals("*") || simbolo.equals("/") ||
                simbolo.equals("^");
    }

    public void infijo(Nodo raiz) {
        if (raiz == null) {
            return;
        }

        Pila pila = new Pila();
        Nodo actual = raiz;

        while (!pila.isEmpty() || actual != null) {
            while (actual != null) {
                if (actual.izquierda != null || actual.derecha != null) {
                    System.out.print("(");
                }
                pila.push(actual);
                actual = actual.izquierda;
            }

            actual = pila.pop();
            System.out.print(actual.info);

            actual = actual.derecha;

            if (actual != null || !pila.isEmpty()) {
                System.out.print(")");
            }
        }
    }

    public void posfijo(Nodo raiz) {
        if (raiz != null) {
            posfijo(raiz.izquierda);
            posfijo(raiz.derecha);
            System.out.print(raiz.info);
        }
    }

    public void prefijo(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.info);
            prefijo(raiz.izquierda);
            prefijo(raiz.derecha);
        }
    }
}