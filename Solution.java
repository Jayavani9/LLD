
//Single Responsibility Principle

class Marker {
    String name;
    String color;
    int year;
    int price;

    public Marker(String name, String color, int year, int price) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.price = price;
    }
}

class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calcTot() {

        int price = marker.price * quantity;
        return price;
    }

}

class Solution {
    public static void main(String[] args) {
        Marker obj = new Marker("M1", "Yellow", 1999, 9);
        Invoice obj1 = new Invoice(obj, 8);
        int res = obj1.calcTot();
        System.out.println(res);
    }
}