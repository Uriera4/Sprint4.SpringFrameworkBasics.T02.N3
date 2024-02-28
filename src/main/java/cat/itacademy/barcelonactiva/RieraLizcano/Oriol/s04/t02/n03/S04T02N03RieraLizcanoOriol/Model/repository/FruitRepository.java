package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s04.t02.n02.S04T02N02RieraLizcanoOriol.Model.repository;

import cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s04.t02.n02.S04T02N02RieraLizcanoOriol.Model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Integer> {

}
