package battleship1;
import java.util.ArrayList;

public class Battleship1 {

    private BarcoController helper = new BarcoController();
    private ArrayList<Barco> barcos = new ArrayList<>();
    private int numOfGuesses = 0;
    private String[][] tablero = new String[7][7];
    private void setUpGame() {
        System.out.println("Bienvenido a Battleship!");
        System.out.println("El objetivo es hundir los tres barcos:");
        System.out.println("La niña, La pinta y La Santa Maria");
        System.out.println("Ingresa coordenadas como: a0, b3, c6");

        Barco one = new Barco();
        one.setName("La niña");

        Barco two = new Barco();
        two.setName("La pinta");

        Barco three = new Barco();
        three.setName("La Santa Maria");

        barcos.add(one);
        barcos.add(two);
        barcos.add(three);

        for (Barco barco : barcos) {
            ArrayList<String> newLocation = helper.placeStartup(3);
            barco.setLocationCells(newLocation);
        }
        
        for (int i = 0; i < 7; i++) {
    for (int j = 0; j < 7; j++) {
        tablero[i][j] = ".";
    }
}
    }

    private void startPlaying() {
        while (!barcos.isEmpty()) {
          String userGuess = helper.getUserInput("Ingresa tu intento");

if (!entradaValida(userGuess)) {
    System.out.println("Tu intento no es valido. Usa formato como a0 - g6");
    continue; 
        }
 checkUserGuess(userGuess);
    }
                finishGame();

    }

   private void checkUserGuess(String userGuess) {
    numOfGuesses++;
    String result = "fallaste";

    for (int i = 0; i < barcos.size(); i++) {
        Barco barco = barcos.get(i);

        result = barco.checkYourself(userGuess);

        if (result.equals("hit")) {
            break;
        }

        if (result.equals("BARCO HUNDIDOOOO")) {
            barcos.remove(i);
            break;
        }
    }

    char letra = userGuess.charAt(0);
    int columna = "abcdefg".indexOf(letra);
    int fila = Integer.parseInt(userGuess.substring(1));

    if (result.equals("hit") || result.equals("BARCO HUNDIDOOOO")) {
        tablero[fila][columna] = "X";
    } else {
        tablero[fila][columna] = "O";
    }

    System.out.println(result);
    imprimirTablero();
}

    private void finishGame() {
        System.out.println(" Todos los barcos han sido hundidos!");

        if (numOfGuesses <= 18) {
            System.out.println("Increible! Solo te tomo " + numOfGuesses + " intentos");
        } else {
            System.out.println(" Muy lento, te tomo " + numOfGuesses + " intentos");
        }
    }

    private void imprimirTablero() {
    System.out.println("\n  a b c d e f g");

    for (int i = 0; i < 7; i++) {
        System.out.print(i + " ");
        for (int j = 0; j < 7; j++) {
            System.out.print(tablero[i][j] + " ");
        }
        System.out.println();
    }
}
    private boolean entradaValida(String input) {
    if (input == null || input.length() < 2) return false;

    input = input.toLowerCase();

    char letra = input.charAt(0);

    if ("abcdefg".indexOf(letra) == -1) return false;

    try {
        int numero = Integer.parseInt(input.substring(1));
        if (numero < 0 || numero > 6) return false;
    } catch (Exception e) {
        return false;
    }

    return true;
}

    
    public static void main(String[] args) {
        Battleship1 game = new Battleship1();
        game.setUpGame();
        game.startPlaying();
  
    }
}