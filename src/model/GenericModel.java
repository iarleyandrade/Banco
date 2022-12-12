package model;

public class GenericModel {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(long id) {
        this.id = (int) id;
    }

    @Override
    public String toString() {
        return "GenericModel{" +
                "id=" + id +
                '}';
    }
}
