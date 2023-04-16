package a_qg.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Test implements CommandLineRunner {
    @Autowired
    EmployeeRepo repo;

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee("Larson", "worker", 5000);
        Employee manager = new Employee("Friedrickson", "manager", 5000);
        repo.save(manager);
        employee.setManager(manager.getId());
        repo.save(employee);
        System.out.println(repo.findAll());
        System.out.println(repo.findById(manager.getId()));
    }

}

