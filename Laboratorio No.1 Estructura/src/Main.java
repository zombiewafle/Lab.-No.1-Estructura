import radio.Radio;

import java.util.Scanner;

import static radio.Radio.FAVORITE_AM;
import static radio.Radio.FAVORITE_FM;

public class Main {
    // funcion que muestra el menu
    public static String getMenu(boolean isTurnedOn) {
        if (!isTurnedOn) {
            return "Menu:\n" +
                    "\t1. Encender\n" +
                    "\t2. Salir\n";
        }

        return "Menu:\n" +
                "\t1. Apagar\n" +
                "\t2. Subir volumen\n" +
                "\t3. Bajar volumen\n" +
                "\t4. Subir estacion\n" +
                "\t5. Bajar estacion\n" +
                "\t6. Cambiar frecuencia\n" +
                "\t7. Guardar en favoritos\n"+
                "\t8. Salir\n";
    }
    // aqui inica el programa
    public static void main (String[] args) {
        boolean wantsToContinue = true;
        Radio myRadio = new Radio();

        do {
            // Mostrar el estado del radio
            System.out.println(myRadio);

            // Mostrar menu
            System.out.println(getMenu(myRadio.isTurnedOn()));

            // Leer del teclado
            System.out.print("Ingrese una opcion: ");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
// hace un accion segun lo ingresado
            if (myRadio.isTurnedOn()) {
                switch(option) {
                    case 1:
                        myRadio.turnOff();
                        break;
                    case 2:
                        myRadio.volumeUp();
                        break;
                    case 3:
                        myRadio.volumeDown();
                        break;
                    case 4:
                        myRadio.stationUp();
                        break;
                    case 5:
                        myRadio.stationDown();
                        break;
                    case 6:
                        if (myRadio.isInFM()) {
                            myRadio.changeToAM();
                        } else {
                            myRadio.changeToFM();
                        }
                        break;

                    case 7:
                        myRadio.favoriteStations(0);
                        System.out.println("-----------------------------");
                        System.out.println("La estacion ha sido guardada ");
                        System.out.println("-----------------------------");
                        for(Double estacion:FAVORITE_FM){
                            System.out.println(estacion);
                        }
                        System.out.println("------------------------------");
                        for(Double station: FAVORITE_AM){
                            System.out.println(station);
                        }
                        System.out.println("------------------------------");
                        break;

                    case 8:
                        wantsToContinue = false;
                        break;
                    default:
                        System.out.println("Esta opcion no es valida!");
                        break;
                }
            } else {
                switch(option) {
                    case 1:
                        myRadio.turnOn();
                        break;
                    case 2:
                        wantsToContinue = false;
                        break;
                    default:
                        System.out.println("Esta opcion no es valida!");
                        break;
                }
            }

        } while (wantsToContinue);

        System.out.println("Gracias por participar, GG");
    }
}