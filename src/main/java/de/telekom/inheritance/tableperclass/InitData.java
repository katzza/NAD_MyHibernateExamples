package de.telekom.inheritance.tableperclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class InitData implements CommandLineRunner {

    @Autowired
    TierRepository tierRepo;


    @Override
    public void run(String... args) throws Exception {

        Cat cat = new Cat(1, "Mao", "black");
        tierRepo.save(cat);
        Cat cat2 = new Cat(2, "Alla", "white");
        tierRepo.save(cat2);
        Cat cat3 = new Cat(12, "Hihi", "white");
        tierRepo.save(cat3);

        Mouse mouse1 = new Mouse(1, "Hoho", "deco");
        tierRepo.save(mouse1);

        Mouse mouse2 = new Mouse(1, "Hihi", "hamster");
        tierRepo.save(mouse2);


        System.out.println("Cat");
        for (Tier whoAreYou : tierRepo.findAll()) {
            System.out.println(whoAreYou);
        }

        tierRepo.findByName("Hihi").forEach(System.out::println);

        tierRepo.findByAge(1).forEach(System.out::println);

        tierRepo.findByNativeQuery().forEach(System.out::println);
    }

}
