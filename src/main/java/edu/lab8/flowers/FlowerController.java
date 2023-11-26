package edu.lab8.flowers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

// import edu.lab8.flowers.Flower;
// import edu.lab8.flowers.FlowerService;

@RestController
@RequestMapping(path = "api/v1/flower")
public class FlowerController {
    
    public final FlowerService flowerService;

    @Autowired
    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping
    public List<Flower> getFlowers() {
        return flowerService.findAll();
    }

    @PostMapping
    public void addFlower(@RequestBody Flower flower) {
        flowerService.addFlower(flower);
    }

    @DeleteMapping(path = "{flowerId}")
    public void deleteFlower(@PathVariable("flowerId") Integer id) {
        flowerService.deleteFlower(id);
    }
}
