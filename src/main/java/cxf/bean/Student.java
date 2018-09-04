package cxf.bean;

public class Student {

    private int    id;
    private String name;
    private float  price;

    @Override
    public String toString() {
        return "Student [id=" + this.id + ", name=" + this.name + ", price=" + this.price + "]";
    }

    public Student(int id, String name, float price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Student() {
        super();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
