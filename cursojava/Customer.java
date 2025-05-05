package personas;

public class Customer {

    private String nombreCompleto;
    
    private String size;

    public Cliente() {
        this.nombreCompleto = "Carlos";
        this.size = "M";
        private ArrayList <prenda> ropa = new ArrayList<>();
    

    public Cliente(String nombreCompleto, int measurement){
        this.nombreCompleto = nombreCompleto;
        setSize(measurement);
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }


    public String getNombreCompleto(){
        return nombreCompleto;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    public ArrayList <prenda> returnArray(){
        return ropa;
    }

    public void setSize(int measurement){
        switch (measurement){
            case 1,2,3 :
                size= "S"
                break;
            case 4,5,6 :
                size= "M"
                break;
            case 7,8,9 :
                size= "L"
                break;
            default:
                size= "x"
                break;
        }
    }
    public void addItems(ArrayList <prenda> prendas){
        this.ropa = prendas;
    }
    public double getTotalPrenda(){
        double total = 0;
        for (Prenda prenda : ropa){
            if (size.equals(prenda.getSize())){
                total += prenda.getPrice();
                System.out.println(prenda.getDescription() + ", " + prenda.getSize() + ", " + prenda.getPrice());
            }
            if (total > 15.0){break;}
        }
        return total;
    }
    public static void main(String[] args) {
        
    }
}
