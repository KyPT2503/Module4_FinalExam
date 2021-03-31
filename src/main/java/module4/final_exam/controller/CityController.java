package module4.final_exam.controller;

import module4.final_exam.model.City;
import module4.final_exam.model.Country;
import module4.final_exam.service.city.ICityService;
import module4.final_exam.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private ICityService cityService;
    @Autowired
    private ICountryService countryService;

    @ModelAttribute("countries")
    public List<Country> getAllCountry() {
        return countryService.findAll();
    }

    @GetMapping("")
    public ModelAndView showAllCity() {
        return new ModelAndView("index", "cities", cityService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        return new ModelAndView("create", "city", new City());
    }

    @PostMapping("/create-city")
    public ModelAndView create(@Validated @ModelAttribute("city") City city, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("create", "city", city);
        }
        cityService.add(city);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("cities", cityService.findAll());
        modelAndView.addObject("message", "Success create(update) new city.");
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updatePage(@PathVariable("id") City city) {
        return new ModelAndView("create", "city", city);
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable("id") City city) {
        return new ModelAndView("detail", "city", city);
    }

    @GetMapping("/remove/{id}")
    public ModelAndView showRemovePage(@PathVariable("id") City city) {
        return new ModelAndView("delete", "city", city);
    }

    @PostMapping("/remove")
    public ModelAndView remove(@ModelAttribute("city") City city) {
        cityService.remove(city);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("cities", cityService.findAll());
        modelAndView.addObject("message", "Success remove city.");
        return modelAndView;
    }
}
