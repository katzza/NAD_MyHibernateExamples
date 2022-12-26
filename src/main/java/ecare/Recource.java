package ecare;

import ecare.model.Contract;
import ecare.service.ContractService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ecare.model.Tariff;
import ecare.service.TariffService;

import java.util.List;
import java.util.Optional;

import static org.jboss.logging.Logger.getLogger;

@CrossOrigin
@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class Recource {

    @Autowired
    TariffService tariffService;

    @Autowired
    ContractService contractService;

    private static final Logger LOGGER = getLogger(Recource.class);

    @GetMapping("/tariffs")
    public List<Tariff> getAllTariffs() {
        LOGGER.info("GET all tariffs");
        return tariffService.getAllTariffs();
    }

    @GetMapping("{id}")
    public Optional<Tariff> getById(@PathVariable("id") Long id) {
        LOGGER.info("GET tariff by id");
        return tariffService.getById(id);
    }

    @GetMapping("/contracts")
    public List<Contract> getAllContracts() {
        LOGGER.info("GET all contracts");
        return contractService.getAllContracts();
    }


}
