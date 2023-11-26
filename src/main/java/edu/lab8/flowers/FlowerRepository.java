package edu.lab8.flowers;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Integer>{
    
    @Query("SELECT s FROM Flower s WHERE s.id = ?1")
    Optional<Flower> findFlowerById(Integer integer);
}
