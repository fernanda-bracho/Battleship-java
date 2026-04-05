package battleship1;
import java.util.ArrayList;

public class Barco {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) {
        String result = "fallaste";
        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "BARCO HUNDIDOOOO";
                System.out.println("Ouch! Hundiste al " + name + " :(");
            } else {
                result = "hit";
            }
        }
        return result;
    }
}
