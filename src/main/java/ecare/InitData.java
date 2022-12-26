package ecare;

import ecare.model.Contract;
import ecare.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ecare.model.Tariff;
import ecare.service.TariffService;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    TariffService tariffService;

    @Autowired
    ContractService contractService;

    @Override
    public void run(String... args) throws Exception {


        Tariff tariffS = tariffService.saveTariff(new Tariff("S", "Super S"));
        tariffService.saveTariff(new Tariff("M", "Super M"));
        tariffService.saveTariff(new Tariff("L", "Super L"));

        Contract contract = new Contract(tariffS, "3127670");
        contractService.saveContract(contract);

        System.out.println(tariffService.getAllTariffs().stream());
    }

}


