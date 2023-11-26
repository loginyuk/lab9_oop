package ua.edu.ucu.apps.flowerstore.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.*;

@Entity
@NoArgsConstructor
@Table
@Getter
@Setter
public class AppUser {
    @Id @GeneratedValue
    private int id;
    @Column(unique = true)
    private String email;
    private LocalDate dob;
    @Transient
    private int age;

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
