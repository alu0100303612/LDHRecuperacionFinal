package app;

/**
 * Clase principal del programa
 * @author Bianney
 *
 */
public class App{
    /**
     *  Constructor privado vacio
     */
    private App(){
    }

    /**
     * Metodo principal. Crea una ventana con las distintas opciones que permite ejecutar el programa
     * @param args
     */
    public static void main(String[] args){
        Panel panel = new Panel();
        Frame frame = new Frame();
        frame.setFrame(panel, "Practica LDH");
    }
}