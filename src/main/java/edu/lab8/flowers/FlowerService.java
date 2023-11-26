package edu.lab8.flowers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class FlowerService {
    private final FlowerRepository flowerRepository;

    @Autowired
    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<Flower> findAll() {
        return flowerRepository.findAll();
    }

    public void addFlower(Flower flower) {
        Optional<Flower> flowerOptional = flowerRepository.findFlowerById(flower.getId());
        if (flowerOptional.isPresent()) {
            throw new IllegalStateException("Flower already exists");
        }
        flowerRepository.save(flower);
        System.out.println("Flower added: " + flower);
    }

    @DeleteMapping(path = "{flowerId}")
    public void deleteFlower(@PathVariable("flowerId") Integer id) {
        boolean exists = flowerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Flower with id " + id + " does not exist");
        }
        flowerRepository.deleteById(id);
        System.out.println("Flower deleted: " + id);
    }
}
