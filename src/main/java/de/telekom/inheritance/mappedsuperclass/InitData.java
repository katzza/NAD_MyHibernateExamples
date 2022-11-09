package de.telekom.inheritance.mappedsuperclass;

import de.telekom.jpaassociation.model.Order;
import de.telekom.jpaassociation.model.OrderItem;
import de.telekom.jpaassociation.persistence.OrderItemRepository;
import de.telekom.jpaassociation.persistence.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class InitData implements CommandLineRunner {

    @Autowired
    CatRepository catRepo;
    @Autowired
    MouseRepository mouseRepo;

    @Autowired
    TierRepository tierRepo;


    @Override
    public void run(String... args) throws Exception {

        Cat cat = new Cat(10, "Mi", "black");
        catRepo.saveCat(cat);
        Cat cat2 = new Cat(5, "Afro", "white");
        catRepo.saveCat(cat2);

        Mouse mouse1 = new Mouse(1, "Hoho", "deco");
        mouseRepo.saveMouse(mouse1);

        Mouse mouse2 = new Mouse(1, "Hihi", "hamster");
        tierRepo.save(mouse2);


        System.out.println("Cat");
        for (Cat cats : catRepo.findAll()) {
            System.out.println(cats);
        }

        System.out.println("Mouse");
        for (Mouse mouse : mouseRepo.findAll()) {
                System.out.println(mouse);
        }
    }

}
