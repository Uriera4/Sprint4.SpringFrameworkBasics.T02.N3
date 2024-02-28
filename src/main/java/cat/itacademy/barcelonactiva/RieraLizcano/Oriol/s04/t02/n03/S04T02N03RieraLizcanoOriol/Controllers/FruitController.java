package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s04.t02.n02.S04T02N02RieraLizcanoOriol.Controllers;

import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s04.t02.n02.S04T02N02RieraLizcanoOriol.Model.domain.Fruit;
import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s04.t02.n02.S04T02N02RieraLizcanoOriol.Model.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruita")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @PostMapping("/add")
    public ResponseEntity<Fruit> createFruit (@RequestBody Fruit fruit){
        ResponseEntity<Fruit> responseEntity;
        Fruit newFruit = fruitService.createFruit(fruit);
        if (newFruit!=null){
            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(newFruit);
        } else {
            responseEntity = ResponseEntity.internalServerError().build();
        }
        return responseEntity;
    }
    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruit (@RequestBody Fruit fruit){
        ResponseEntity<Fruit> responseEntity;
        Fruit newFruit = fruitService.update(fruit);
        if (newFruit!=null){
            responseEntity = ResponseEntity.ok(newFruit);
        } else {
            responseEntity = ResponseEntity.notFound().build();
        }
        return responseEntity;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruit (@PathVariable("id") int id){
        ResponseEntity<HttpStatus> responseEntity;
        if(fruitService.delete(id)){
            responseEntity = ResponseEntity.noContent().build();
        } else {
            responseEntity =ResponseEntity.internalServerError().build();
        }
        return responseEntity;
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getFruit (@PathVariable("id") int id){
        ResponseEntity<Fruit> responseEntity;
        Fruit newFruit = fruitService.getOne(id);
        if (newFruit!=null){
            responseEntity = ResponseEntity.ok(newFruit);
        } else {
            responseEntity = ResponseEntity.notFound().build();
        }
        return responseEntity;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getFruits (){
        ResponseEntity<List<Fruit>> responseEntity;
        List<Fruit> fruits = fruitService.getAll();
        if (fruits.isEmpty()){
            responseEntity = ResponseEntity.noContent().build();
        } else {
            if (fruits.getFirst()==null){
                responseEntity = ResponseEntity.internalServerError().build();
            } else {
                responseEntity = ResponseEntity.ok(fruits);
            }
        }
        return responseEntity;
    }

}
