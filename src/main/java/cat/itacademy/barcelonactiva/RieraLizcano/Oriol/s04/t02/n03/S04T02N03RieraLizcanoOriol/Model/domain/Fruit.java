package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s04.t02.n02.S04T02N02RieraLizcanoOriol.Model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "fruits")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "kg")
    private int kilosQuantity;

    public Fruit (){}

    public Fruit (String name, int kilosQuantity){
        this.name = name;
        this.kilosQuantity = kilosQuantity;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getKilosQuantity() {
        return this.kilosQuantity;
    }
    public void setKilosQuantity(int kilosQuantity) {
        this.kilosQuantity = kilosQuantity;
    }

    @Override
    public String toString() {
        return "Fruit{" + "id=" + id + ", name='" + name + '\'' + ", kilosQuantity=" + kilosQuantity + '}';
    }

}