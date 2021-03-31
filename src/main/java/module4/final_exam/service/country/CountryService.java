package module4.final_exam.service.country;

import module4.final_exam.model.Country;
import module4.final_exam.repo.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService {
    @Autowired
    private CountryRepo countryRepo;

    @Override
    public List<Country> findAll() {
        return countryRepo.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepo.getOne(id);
    }

    @Override
    public void remove(Country id) {

    }

    @Override
    public Country update(Country country) {
        return null;
    }

    @Override
    public Country add(Country country) {
        return null;
    }
}
