package objetos;

public class ClothingNew implements Comparable<ClothingNew>

{

        private String description;
        private double price;
        private char size='s';
        private final double min_tax=1.2;
        private final int min_price=10;

        public ClothingNew(String description, double price, char size){
                this.description=description;
                this.price=price;
                this.size=size;

        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public double getPrice() {
                price = price * min_tax;
                return price;
        }

        public void setPrice(double price) {
                if(price<min_price) {
                        price = min_price;
                }
                this.price = price;
        }

        public char getSize() {
                return size;
        }

        public void setSize(char size) {
                this.size = size;
        }

        public static void main(String[] args) {

          


          
        }

        @Override
        public int compareTo(ClothingNew o) {
                return this.description.compareTo(o.description);
        }


}
