package ecare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ecare.dto.TariffDto;
import ecare.model.Tariff;
import ecare.repository.TariffRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TariffService {

    @Autowired
    TariffRepository tariffRepository;

    public List<Tariff> getAllTariffs() {
        return tariffRepository.findAll();
    }

    public List<Tariff> getByDescription(String description) {
        return tariffRepository.findByTariffDescription(description);
    }

    public Optional<Tariff> getById(Long id) {
        return tariffRepository.findById(id);
    }

    public Tariff addTodo(TariffDto tariffDto) {
        Tariff newTariff = new Tariff(tariffDto.tariffName, tariffDto.tariffDescription);
        return tariffRepository.save(newTariff);
    }

    public Tariff saveTariff(Tariff tariff) {
        return tariffRepository.save(tariff);
    }

    public void deleteById(Long id) {
        tariffRepository.deleteById(id);
    }
}
