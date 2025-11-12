package javainter.solid.singleresponsability.good;

public class Employe {

    private int id;
    private String name;

    public Employe(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
