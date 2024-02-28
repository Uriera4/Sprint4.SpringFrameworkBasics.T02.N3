package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s04.t02.n02.S04T02N02RieraLizcanoOriol.Model.services;

import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s04.t02.n02.S04T02N02RieraLizcanoOriol.Model.domain.Fruit;
import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s04.t02.n02.S04T02N02RieraLizcanoOriol.Model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public Fruit createFruit (Fruit fruit){
        Fruit newFruit;
        try{
            newFruit = fruitRepository.save(new Fruit(fruit.getName(), fruit.getKilosQuantity()));
        } catch (Exception e){
            newFruit = null;
        }
        return newFruit;
    }
    public Fruit update (Fruit fruit){
        Optional<Fruit> optionalFruit = fruitRepository.findById(fruit.getId());
        Fruit newFruit;
        if (optionalFruit.isPresent()){
            newFruit = optionalFruit.get();
            newFruit.setName(fruit.getName());
            newFruit.setKilosQuantity(fruit.getKilosQuantity());
            fruitRepository.save(newFruit);
        } else {
            newFruit = null;
        }
        return fruit;
    }
    public boolean delete (int id){
        boolean deleted;
        try {
            fruitRepository.deleteById(id);
            deleted = true;
        } catch (Exception e){
            deleted = false;
        }
        return deleted;
    }
    public Fruit getOne (int id){
        return fruitRepository.findById(id).orElse(null);
    }
    public List<Fruit> getAll (){
        List<Fruit> fruits = new ArrayList<>();
        try{
            fruits.addAll(fruitRepository.findAll());
        } catch (Exception e){
            fruits.add(null);
        }
        return fruits;
    }

}
