
package listas.enlazadas.po;

import javax.swing.JOptionPane;

public class Lista {

    Nodo Punta;
    Nodo Fin;
    

    public Lista() {
        this.Punta = null;
    }

    public void MostrarLista() {
        String s = "<----->";
        Nodo p = Punta;
        do {
            s = s + "[" + p.getDato() + "]<----->";
            p = p.getLR();
        } while (p != Punta);
        JOptionPane.showMessageDialog(null, s);
    }

    public void InsertarFinal(int d) {
        Nodo x = new Nodo(d);

        if (Punta == null) {
            Punta = x;
            Fin = x;
            Punta.setLR(Fin);
            Fin.setLL(Punta);
        } else {
            Fin.setLR(x);
            x.setLL(Fin);
            Fin = x;
            Punta.setLL(Fin);
            Fin.setLR(Punta);
        }
    }

    public void InsertarInicio(int d) {
        Nodo x = new Nodo(d);
        if (Punta == null) {
            Punta = x;
            Fin = x;
            Punta.setLR(Fin);
            Fin.setLL(Punta);
        } else {
            x.setLR(Punta);
            x.setLL(Fin);
            Punta.setLL(x);
            Punta = x;
            Fin.setLR(Punta);
        }
    }

    public void InsertarAscendente(int d) {
        Nodo p = Punta, /* a, */x = new Nodo(d);
        if (Punta == null) {
            Punta = x;
            Fin = x;
            Punta.setLR(Fin);
            Fin.setLL(Punta);
        } else {
            if (x.getDato() > p.getDato()) {
                do {
                    p = p.getLR();
                } while (p != Punta && x.getDato() > p.getDato());
                if (p != Punta) {
                    x.setLR(p);
                    x.setLL(p.getLL());
                    p.getLL().setLR(x);
                    p.setLL(x);
                } else {
                    InsertarFinal(d);
                }
            } else {
                InsertarInicio(d);
            }
        }
    }

    public void InsertarDescendente(int d) {
        Nodo p = Punta, /* a, */x = new Nodo(d);
        if (Punta == null) {
            Punta = x;
            Fin = x;
            Punta.setLR(Fin);
            Fin.setLL(Punta);
        } else {
            if (x.getDato() < p.getDato()) {
                do {
                    p = p.getLR();
                } while (p != Punta && x.getDato() < p.getDato());
                if (p != Punta) {
                    x.setLR(p);
                    x.setLL(p.getLL());
                    p.getLL().setLR(x);
                    p.setLL(x);
                } else {
                    InsertarFinal(d);
                }
            } else {
                InsertarInicio(d);
            }
        }
    }

    public void OrdenarDescendente() {
        Nodo p = Punta, q;
        int aux;
        do {
            q = Punta;
            do {
                if (q.getDato() < p.getDato()) {
                    aux = q.getDato();
                    q.setDato(p.getDato());
                    p.setDato(aux);
                }
                q = q.getLR();
            } while (q != Punta);
            p = p.getLR();
        } while (p != Punta);
    }

    public void OrdenarAscendente() {
        Nodo p = Punta, q;
        int aux;
        do {
            q = Punta;
            do {
                if (q.getDato() > p.getDato()) {
                    aux = q.getDato();
                    q.setDato(p.getDato());
                    p.setDato(aux);
                }
                q = q.getLR();
            } while (p != Punta);
            p = p.getLR();
        } while (p != Punta);
    }

    public Boolean buscardato(int d, boolean aux) {
        Nodo p = Punta;
        if (p.getDato() != d) {
            do {
                p = p.getLR();
            } while (p.getDato() != d && p != Punta);
        }
        if (p.getDato() == d)
            aux = true;
        return aux;
    }

    public void Eliminar(int d) {
        if (Punta != null) {
            Nodo p = Punta;
            do {
                if (p.getDato() == d) {
                    if (p == Punta) {
                        Punta = p.getLR();
                        p.getLR().setLL(p.getLL());
                        p.getLL().setLR(p.getLR());
                        p.setLR(null);
                        p.setLL(null);
                        if (Punta.getLR() == null) {
                            Punta = null;
                            Fin = null;
                        }
                        Eliminar(d);
                    } else if (p == Fin) {
                        Fin = p.getLL();
                        p.getLR().setLL(p.getLL());
                        p.getLL().setLR(p.getLR());
                        p.setLR(null);
                        p.setLL(null);
                        Eliminar(d);
                    } else {
                        p.getLR().setLL(p.getLL());
                        p.getLL().setLR(p.getLR());
                        Nodo a = p.getLL();
                        p.setLR(null);
                        p.setLL(null);
                        p = a;
                    }
                }
                p = p.getLR();
            } while (p != Punta && p != null);

        }

    }

    public void Reemplazar(int d) {
        Nodo p = Punta;
        do {
            if (p.getDato() == d)
                p.setDato(Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor:")));
            p = p.getLR();
        } while (p != Punta);

    }

    public void Suma(Lista L) {
        Lista Resultado = new Lista();
        Nodo p = Punta, q = L.Punta;
        if (p != null && q != null) {
            Resultado.InsertarFinal(p.getDato() + q.getDato());
            p = p.getLR();
            q = q.getLR();
        } else if (p != null && q == null) {
            Resultado.InsertarFinal(p.getDato());
            p = p.getLR();
        } else {
            Resultado.InsertarFinal(q.getDato());
            q = q.getLR();
        }
        do {
            if (p != Punta && q != L.Punta) {
                Resultado.InsertarFinal(p.getDato() + q.getDato());
            } else if (p != Punta && q == L.Punta) {
                Resultado.InsertarFinal(p.getDato());
            } else if (p == Punta && q != L.Punta) {
                Resultado.InsertarFinal(q.getDato());
            }
            if (p != Punta) {
                p = p.getLR();
            }
            if (q != L.Punta) {
                q = q.getLR();
            }
        } while (p != Punta || q != L.Punta);
        JOptionPane.showMessageDialog(null, "El resultado es:");
        Resultado.MostrarLista();
    }

    public void Resta(Lista L) {
        Lista Resultado = new Lista();
        Nodo p = Punta, q = L.Punta;
        if (p != null && q != null) {
            Resultado.InsertarFinal(p.getDato() - q.getDato());
            p = p.getLR();
            q = q.getLR();
        } else if (p != null && q == null) {
            Resultado.InsertarFinal(p.getDato());
            p = p.getLR();
        } else {
            Resultado.InsertarFinal(-q.getDato());
            q = q.getLR();
        }
        do {
            if (p != Punta && q != L.Punta) {
                Resultado.InsertarFinal(p.getDato() - q.getDato());
            } else if (p != Punta && q == L.Punta) {
                Resultado.InsertarFinal(p.getDato());
            } else if (p == Punta && q != L.Punta) {
                Resultado.InsertarFinal(-q.getDato());
            }
            if (p != Punta) {
                p = p.getLR();
            }
            if (q != L.Punta) {
                q = q.getLR();
            }
        } while (p != Punta || q != L.Punta);
        JOptionPane.showMessageDialog(null, "El resultado es:");
        Resultado.MostrarLista();
    }

    public void Multiplicacion(Lista L) {
        Lista Resultado = new Lista();
        Nodo p = Punta, q = L.Punta;
        if (p != null && q != null) {
            Resultado.InsertarFinal(p.getDato() * q.getDato());
            p = p.getLR();
            q = q.getLR();
        } else if (p != null && q == null) {
            Resultado.InsertarFinal(p.getDato());
            p = p.getLR();
        } else {
            Resultado.InsertarFinal(q.getDato());
            q = q.getLR();
        }
        do {
            if (p != Punta && q != L.Punta) {
                Resultado.InsertarFinal(p.getDato() * q.getDato());
            } else if (p != Punta && q == L.Punta) {
                Resultado.InsertarFinal(p.getDato());
            } else if (p == Punta && q != L.Punta) {
                Resultado.InsertarFinal(q.getDato());
            }
            if (p != Punta) {
                p = p.getLR();
            }
            if (q != L.Punta) {
                q = q.getLR();
            }
        } while (p != Punta || q != L.Punta);
        JOptionPane.showMessageDialog(null, "El resultado es:");
        Resultado.MostrarLista();
    }

    public void Division(Lista L) {
        Lista Resultado = new Lista();
        Nodo p = Punta, q = L.Punta;
        if (p != null && q != null) {
            if (q.getDato() != 0)
                Resultado.InsertarFinal(p.getDato() / q.getDato());
            else
                Resultado.InsertarFinal(q.getDato());
            p = p.getLR();
            q = q.getLR();
        } else if (p != null && q == null) {
            Resultado.InsertarFinal(p.getDato());
            p = p.getLR();
        } else {
            Resultado.InsertarFinal(0);
            q = q.getLR();
        }
        do {
            if (p != Punta && q != L.Punta) {
                if (q.getDato() != 0)
                    Resultado.InsertarFinal(p.getDato() / q.getDato());
                else
                    Resultado.InsertarFinal(q.getDato());
            } else if (p != Punta && q == L.Punta) {
                Resultado.InsertarFinal(p.getDato());
            } else if (p == Punta && q != L.Punta) {
                Resultado.InsertarFinal(0);
            }
            if (p != Punta) {
                p = p.getLR();
            }
            if (q != L.Punta) {
                q = q.getLR();
            }
        } while (p != Punta || q != L.Punta);
        JOptionPane.showMessageDialog(null, "El resultado es:");
        Resultado.MostrarLista();
    }

    public void LlenarLista2() {
        int p;
        if (Punta == null) {
            p = Integer
                    .parseInt(JOptionPane
                            .showInputDialog(
                                    "La lista 2 esta vacia, ¿quieres llenarla?\n" + "1. Si\n" + "2. No\n\n\n"));
            switch (p) {
                case 1:
                    int i = 1;
                    do {
                        InsertarFinal(
                                Integer.parseInt(JOptionPane.showInputDialog("ingrese el valor del nodo " + i + " :")));
                        i++;
                        p = Integer
                                .parseInt(JOptionPane
                                        .showInputDialog("¿Quieres ingresar otro nodo?\n" + "1. Si\n" + "2. No\n\n\n"));
                    } while (p != 2);
                    break;
                case 2:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                    break;
            }
        } else {
            do {
                p = Integer
                        .parseInt(JOptionPane
                                .showInputDialog("La lista 2 ya tiene valores, ¿Quieres ingresarle mas nodo?\n"
                                        + "1. Si\n" + "2. No\n\n\n"));
                switch (p) {
                    case 1:
                        int d;
                        do {
                            InsertarFinal(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del nodo :")));
                            d = Integer
                                    .parseInt(JOptionPane
                                            .showInputDialog(
                                                    "¿Quieres ingresar otro nodo?\n" + "1. Si\n" + "2. No\n\n\n"));
                        } while (d != 2);
                        break;
                    case 2:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                        break;
                }
            } while (p != 1 && p != 2);
        }
    }

    public void operaciones(Lista L2,Boolean b) {
        int opc3;
        if(b)L2.LlenarLista2();
        if (Punta != null || L2.Punta != null) {
            do {
                opc3 = submenu4();
                switch (opc3) {
                    case 1:
                        Suma(L2);
                        break;
                    case 2:
                        Resta(L2);
                        break;
                    case 3:
                        Multiplicacion(L2);
                        break;
                    case 4:
                        Division(L2);
                        break;
                    case 5:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion incorrecta");
                        break;
                }
            } while (opc3 != 1 && opc3 != 2 && opc3 != 3 && opc3 != 4 && opc3 != 5);
        } else {
            JOptionPane.showMessageDialog(null, "Almenos una lista no debe estar vaica");
        }
    }
    public static int submenu4() {
        int opc2 = Integer
                .parseInt(JOptionPane.showInputDialog("¿Que operacion quieres realizar?\n" +
                        "1. Suma\n"
                        + "2. Resta\n"
                        + "3. Multiplicacion\n"
                        + "4. division\n"
                        + "5. Salir\n\n\n"
                        + "Ingrese la opcion:"));
        return opc2;
    }
}