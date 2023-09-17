/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_foro2w;




import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

class Equipo {
    protected String fabricante;
    protected String modelo;
    protected String microprocesador;
    protected String memoria;

    public Equipo(String fabricante, String modelo, String microprocesador, String memoria) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.microprocesador = microprocesador;
        this.memoria = memoria;
    }

    @Override
    public String toString() {
        return "Fabricante: " + fabricante + "\nModelo: " + modelo + "\nMicroprocesador: " + microprocesador
                + "\nMemoria: " + memoria;
    }
}

class Desktop extends Equipo {
    private String tarjetaGrafica;
    private String tamanoTorre;
    private String capacidadDiscoDuro;

    public Desktop(String fabricante, String modelo, String microprocesador, String memoria, String tarjetaGrafica,
            String tamanoTorre, String capacidadDiscoDuro) {
        super(fabricante, modelo, microprocesador, memoria);
        this.tarjetaGrafica = tarjetaGrafica;
        this.tamanoTorre = tamanoTorre;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTarjeta Gráfica: " + tarjetaGrafica + "\nTamaño de Torre: " + tamanoTorre
                + "\nCapacidad de Disco Duro: " + capacidadDiscoDuro;
    }
}

class Laptop extends Equipo {
    private String tamanoPantalla;
    private String capacidadDiscoDuro;

    public Laptop(String fabricante, String modelo, String microprocesador, String memoria, String tamanoPantalla,
            String capacidadDiscoDuro) {
        super(fabricante, modelo, microprocesador, memoria);
        this.tamanoPantalla = tamanoPantalla;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTamaño de Pantalla: " + tamanoPantalla + "\nCapacidad de Disco Duro: "
                + capacidadDiscoDuro;
    }
}

class Tablet extends Equipo {
    private String tamanoDiagonalPantalla;
    private String tipoPantalla;
    private String tamanoMemoriaNAND;
    private String sistemaOperativo;

    public Tablet(String fabricante, String modelo, String microprocesador, String memoria,
            String tamanoDiagonalPantalla, String tipoPantalla, String tamanoMemoriaNAND, String sistemaOperativo) {
        super(fabricante, modelo, microprocesador, memoria);
        this.tamanoDiagonalPantalla = tamanoDiagonalPantalla;
        this.tipoPantalla = tipoPantalla;
        this.tamanoMemoriaNAND = tamanoMemoriaNAND;
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTamaño Diagonal de Pantalla: " + tamanoDiagonalPantalla + "\nTipo de Pantalla: "
                + tipoPantalla + "\nTamaño de Memoria NAND: " + tamanoMemoriaNAND + "\nSistema Operativo: "
                + sistemaOperativo;
    }
}


public class POO_FORO2W {
    private static List<Desktop> desktops = new ArrayList<>();
    private static List<Laptop> laptops = new ArrayList<>();
    private static List<Tablet> tablets = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menú:\n1. Registrar equipo\n2. Ver Equipos\n3. Salir\n\nIngrese la opción:"));

            switch (opcion) {
                case 1:
                    registrarEquipo();
                    break;
                case 2:
                    verEquipos();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 3);
    }

    private static void registrarEquipo() {
        int tipoEquipo = Integer.parseInt(JOptionPane.showInputDialog(
                "Seleccione el tipo de equipo que desea registrar:\n1. Desktop\n2. Laptop\n3. Tablet"));

        String fabricante = JOptionPane.showInputDialog("Ingrese el fabricante:");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
        String microprocesador = JOptionPane.showInputDialog("Ingrese el microprocesador:");
        String memoria = JOptionPane.showInputDialog("Ingrese la memoria:");

        switch (tipoEquipo) {
            case 1:
                String tarjetaGrafica = JOptionPane.showInputDialog("Ingrese la tarjeta gráfica:");
                String tamanoTorre = JOptionPane.showInputDialog("Ingrese el tamaño de la torre:");
                String capacidadDiscoDuro = JOptionPane.showInputDialog("Ingrese la capacidad del disco duro:");
                Desktop desktop = new Desktop(fabricante, modelo, microprocesador, memoria, tarjetaGrafica, tamanoTorre,
                        capacidadDiscoDuro);
                desktops.add(desktop);
                JOptionPane.showMessageDialog(null, "Desktop registrado con éxito.");
                break;
            case 2:
                String tamanoPantalla = JOptionPane.showInputDialog("Ingrese el tamaño de la pantalla:");
                String capacidadDiscoDuroLaptop = JOptionPane.showInputDialog("Ingrese la capacidad del disco duro:");
                Laptop laptop = new Laptop(fabricante, modelo, microprocesador, memoria, tamanoPantalla,
                        capacidadDiscoDuroLaptop);
                laptops.add(laptop);
                JOptionPane.showMessageDialog(null, "Laptop registrado con éxito.");
                break;
            case 3:
                String tamanoDiagonalPantalla = JOptionPane.showInputDialog("Ingrese el tamaño diagonal de la pantalla:");
                String tipoPantalla = JOptionPane.showInputDialog("¿Capacitiva o Resistiva?");
                String tamanoMemoriaNAND = JOptionPane.showInputDialog("Ingrese el tamaño de memoria NAND:");
                String sistemaOperativo = JOptionPane.showInputDialog("Ingrese el sistema operativo:");
                Tablet tablet = new Tablet(fabricante, modelo, microprocesador, memoria, tamanoDiagonalPantalla,
                        tipoPantalla, tamanoMemoriaNAND, sistemaOperativo);
                tablets.add(tablet);
                JOptionPane.showMessageDialog(null, "Tablet registrado con éxito.");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo de equipo no válido.");
                break;
        }
    }

    private static void verEquipos() {
        int tipoEquipo = Integer.parseInt(JOptionPane.showInputDialog(
                "Seleccione el tipo de equipo que desea ver:\n1. Desktop\n2. Laptop\n3. Tablet"));

        switch (tipoEquipo) {
            case 1:
                if (desktops.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay desktops registrados.");
                } else {
                    for (Desktop desktop : desktops) {
                        JOptionPane.showMessageDialog(null, desktop.toString());
                    }
                }
                break;
            case 2:
                if (laptops.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay laptops registrados.");
                } else {
                    for (Laptop laptop : laptops) {
                        JOptionPane.showMessageDialog(null, laptop.toString());
                    }
                }
                break;
            case 3:
                if (tablets.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay tablets registrados.");
                } else {
                    for (Tablet tablet : tablets) {
                        JOptionPane.showMessageDialog(null, tablet.toString());
                    }
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo de equipo no válido.");
                break;
        }
    }
}