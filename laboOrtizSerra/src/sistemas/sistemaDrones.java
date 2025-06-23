package sistemas;

import vehiculo.Dron;

import java.util.ArrayList;

public class sistemaDrones {
    private ArrayList<Dron> drones;

    public sistemaDrones(ArrayList<Dron> drones) {
        this.drones = drones;
    }

    public ArrayList<Dron> getDrones() {
        return drones;
    }

    public void setDrones(ArrayList<Dron> drones) {
        this.drones = drones;
    }

}
