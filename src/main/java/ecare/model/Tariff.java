package ecare.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tariff")
public class Tariff {

    @Id
    @Column(name = "tariff_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tariffId;

    @Column(name = "tariff_name", nullable = false, unique = true)
    private String tariffName;

    @Column(name = "tariff_description")
    private String tariffDescription;

    public Tariff() {
    }

    public Tariff(String name,
                  String description) {
        this.tariffName = name;
        this.tariffDescription = description;
    }

    public Long getTariffId() {
        return tariffId;
    }

    public void setTariffId(Long tariffId) {
        this.tariffId = tariffId;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public String getTariffDescription() {
        return tariffDescription;
    }

    public void setTariffDescription(String tariffDescription) {
        this.tariffDescription = tariffDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return tariffId == tariff.tariffId && Objects.equals(tariffName, tariff.tariffName) && Objects.equals(tariffDescription, tariff.tariffDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tariffId, tariffName, tariffDescription);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "tariff", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Contract> contracts = new ArrayList<>();

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

}
