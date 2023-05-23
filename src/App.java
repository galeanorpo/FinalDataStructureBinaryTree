import java.util.Scanner;

import Cls.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();
        int opc = 0, opc1 = 0;
        do {
            System.out.println("Ingrese a que parte del trabajo desea ingresar: ");
            System.out.println("1. Gestion de arbol binario");
            System.out.println("2. expresión matemática escrita en notación prefijo");
            System.out.println("3. Salir");
            opc1 = Integer.parseInt(in.nextLine());
            switch (opc1) {
                case 1:
                    do {
                        System.out.println("Bienvenido al sistema... \nIngrese una opcion: ");
                        System.out.println("1. Insertar un nodo");
                        System.out.println("2. Buscar un nodo");
                        System.out.println("3. Eliminar un nodo");
                        System.out.println("4. Imprimir el arbol");
                        System.out.println("5. Salir");
                        opc = Integer.parseInt(in.nextLine());
                        switch (opc) {
                            case 1:
                                System.out.println("Ingrese la cadena que desea ingresar al arbol: ");
                                String cadena = in.nextLine();
                                arbol.insertarNodo(cadena);
                                break;
                            case 2:
                                System.out.println("Ingrese la cadena del nodo que desea buscar: ");
                                String referencia = in.nextLine();
                                arbol.buscarNodo(arbol.raiz, referencia);
                                break;
                            case 3:
                                System.out.println("Ingrese la cadena del nodo que desea eliminar: ");
                                String referenciaEli = in.nextLine();
                                arbol.eliminarNodo(referenciaEli);
                                break;
                            case 4:
                                int opc2 = 0;
                                do {
                                    System.out.println("Como desea imprimir el arbol: ");
                                    System.out.println("1. Imprimir el árbol en posorden");
                                    System.out.println("2. Imprimir el árbol en preorden");
                                    System.out.println("3. Imprimir el árbol en inorden");
                                    System.out.println("4. Imprimir el arbol en amplitud");
                                    System.out.println("5. Salir");
                                    opc2 = Integer.parseInt(in.nextLine());
                                    switch (opc2) {
                                        case 1:
                                            arbol.imprimirPosorden(arbol.raiz);
                                            break;
                                        case 2:
                                            arbol.imprimirPreorden(arbol.raiz);
                                            //arbol.imprimirPreordenRecursivo(arbol.raiz);
                                            break;
                                        case 3:
                                            arbol.imprimirInorden(arbol.raiz);
                                            break;
                                        case 4:
                                            arbol.profundidadArbol(arbol.raiz);
                                            break;
                                    }
                                } while (opc2 != 5);
                                break;
                        }
                    } while (opc != 5);
                    break;
                case 2:
                    int opEx = 0;
                    do {
                        System.out.println("Ingrese la expresion matematica en notacion prefijo: ");
                        String expresion = in.nextLine().replace(" ", "");
                        arbol.construirArbol(expresion);
                        System.out.println("Recorrido Infijo: ");
                        arbol.infijo(arbol.raiz);
                        System.out.println();
                        System.out.println("Recorrido Posfijo:");
                        arbol.posfijo(arbol.raiz);
                        System.out.println();
                        System.out.println("Recorrido Prefijo:");
                        arbol.prefijo(arbol.raiz);
                        System.out.println();
                        System.out.println("Desea ingresar otra expresion matematica en notacion prefijo? 1. Si / 2. No");
                        opEx = Integer.parseInt(in.nextLine());
                    } while (opEx != 2);
                    break;
            }
        } while (opc1 != 3);
    }
}
