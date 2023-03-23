
package listas.enlazadas.po;

import javax.swing.JOptionPane;

/**
 *
 * @author David Antolinez
 */
public class ListasEnlazadasPO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc = 0, d;
        Lista L1 = new Lista();
        Lista L2 = new Lista();

        do {
            opc = Menu();
            switch (opc) {
                case 1:// insertar inicio

                    d = Integer.parseInt(JOptionPane.showInputDialog("ingrese un valor:"));

                    L1.InsertarInicio(d);
                    break;
                case 2:// insertar final
                    d = Integer.parseInt(JOptionPane.showInputDialog("ingrese un valor:"));
                    L1.InsertarFinal(d);
                    break;
                case 3:// insertar ordenado ascendente descendente
                    int opc2;
                    do {
                        opc2 = submenu1();
                        switch (opc2) {
                            case 1:
                                L1.InsertarAscendente(
                                        Integer.parseInt(JOptionPane.showInputDialog("ingrese un valor:")));
                                break;
                            case 2:
                                L1.InsertarDescendente(
                                        Integer.parseInt(JOptionPane.showInputDialog("ingrese un valor:")));
                                break;
                            case 3:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                                break;
                        }
                    } while (opc2 != 3);
                    break;
                case 4:// ordenar ascendente, descendente
                    if (L1.Punta != null) {
                        do {
                            opc2 = submenu1();
                            switch (opc2) {
                                case 1:
                                    L1.OrdenarAscendente();
                                    break;
                                case 2:
                                    L1.OrdenarDescendente();
                                    break;
                                case 3:

                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                                    break;
                            }

                        } while (opc2 != 3);
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista esta vacia");
                    }
                    break;
                case 5:// buscar dato mostrar,reemplazaar,eliminar
                    if (L1.Punta != null) {
                        Boolean aux = false;
                        d = Integer.parseInt(JOptionPane.showInputDialog("valor a buscar:"));
                        aux = L1.buscardato(d, aux);
                        if (aux) {
                            do {
                                opc2 = submenu2();
                                switch (opc2) {
                                    case 1:
                                        L1.Reemplazar(d);
                                        JOptionPane.showMessageDialog(null, "El valor se a reemplazado exitosamente");
                                        break;
                                    case 2:
                                        L1.Eliminar(d);
                                        JOptionPane.showMessageDialog(null, "El valor se a eliminado exitosamente");
                                        break;
                                    case 3:

                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                                        break;
                                }

                            } while (opc2 != 3 && opc2 != 2 && opc2 != 1);
                        } else {
                            JOptionPane.showMessageDialog(null, "El dato a buscar no se encontro");
                        }
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista esta vacia");
                    }
                case 6:// mostrar lista
                    if (L1.Punta != null)
                        L1.MostrarLista();
                    else
                        JOptionPane.showMessageDialog(null, "La lista esta vaica");
                    break;
                case 7:// operaciones + - * /
                    do {
                        opc2 = submenu3();
                        switch (opc2) {
                            case 1:
                                L1.operaciones(L1, false);
                                break;
                            case 2:
                                L1.operaciones(L2, true);
                                break;
                            case 3:
                                L2.operaciones(L1, true);
                                break;
                            case 4:
                                L2.operaciones(L2, true);
                                break;
                            case 5:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                                break;
                        }
                    } while (opc2 != 1 && opc2 != 2 && opc2 != 3 && opc2 != 4 && opc2 != 5);
                    break;
                case 8:// salir
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                    break;
            }
        } while (opc != 8);

    }

    public static int Menu() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("*** Menu Principal ***\n\n"
                + "1. Insertar Inicio\n"// hecho
                + "2. Insertar Final\n"// hecho
                + "3. Insertar Ordenado\n"// hecho
                + "4. Ordenar lista\n"// hecho
                + "5. Buscar Dato\n"// mostrar dato, reemplazar, eliminar
                + "6. Mostrar Lista\n"// bugueado
                + "7. Operacion de dos Listas\n"// + - * /
                + "8. Salir\n\n\n"
                + "Ingrese la opcion:"));
        return opc;
    }

    public static int submenu1() {
        int opc2 = Integer.parseInt(JOptionPane.showInputDialog(
                "1. Ascendente\n"
                        + "2. Descendente\n"
                        + "3. Salir\n\n\n"
                        + "Ingrese la opcion:"));
        return opc2;
    }

    public static int submenu2() {
        int opc2 = Integer
                .parseInt(JOptionPane.showInputDialog("El dato se ha encontrado, ¿que quieres hacer con el?\n" +
                        "1. Remplazarlo\n"
                        + "2. Eliminarlo\n"
                        + "3. Dejarlo quieto y salir\n\n\n"
                        + "Ingrese la opcion:"));
        return opc2;
    }

    public static int submenu3() {
        int opc2 = Integer
                .parseInt(JOptionPane.showInputDialog("¿Contra que lista quieres operar?\n" +
                        "1. La lista principal contra si misma\n"
                        + "2. La lista principal contra otra\n"
                        + "3. Otra lista contra la Lista principal\n"
                        + "4. Otra lista contra si misma\n"
                        + "5. Salir\n\n\n"
                        + "Ingrese la opcion:"));
        return opc2;
    }
    
}