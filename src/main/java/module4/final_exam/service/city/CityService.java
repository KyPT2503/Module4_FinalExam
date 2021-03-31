package module4.final_exam.service.city;

import module4.final_exam.model.City;
import module4.final_exam.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {
    @Autowired
    private CityRepo cityRepo;

    @Override
    public List<City> findAll() {
        return cityRepo.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepo.getOne(id);
    }

    @Override
    public void remove(City city) {
        cityRepo.delete(city);
    }

    @Override
    public City update(City city) {
        return cityRepo.save(city);
    }

    @Override
    public City add(City city) {
        return cityRepo.save(city);
    }
}
