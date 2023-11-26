package edu.lab8.flowers;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "flower")
public class Flower {
    @Id

    private Integer id;
    private double length;
    private FlowerColor color;
    private double price;

    public Flower() {
    }

    // Keep only one of the constructors
    public Flower(double length, FlowerColor color, double price) {
        this.color = color;
        this.price = price;
        this.length = length;
    }
}
