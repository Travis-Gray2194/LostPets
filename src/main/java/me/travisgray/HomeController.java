package me.travisgray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by ${TravisGray} on 11/9/2017.
 */
@Controller
public class HomeController {


    @Autowired
    LostPetsRepository lostPetsRepository;


    @RequestMapping("/")
    public String listPets(Model model){
        model.addAttribute("pets",lostPetsRepository.findAll());
        return "petslist";
    }

    @GetMapping("/add")
    public String petsForm(Model model){
        model.addAttribute("pet",new PetDetails());
        return "petform";
    }

    @PostMapping("/process")
    public String processpetsForm(@Valid PetDetails petDetails, BindingResult result){
        System.out.println(petDetails.toString());
        System.out.println(result.toString());
        if (result.hasErrors()){
            return "petform";
        }

        lostPetsRepository.save(petDetails);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showPets(@PathVariable("id") long id, Model model){
    model.addAttribute("pet",lostPetsRepository.findOne(id));
    return "showpets";
    }

    @RequestMapping("/update/{id}")
    public String updatePets(@PathVariable("id")long id, Model model ){
        model.addAttribute("pet",lostPetsRepository.findOne(id));
        return "petform";
    }

    @RequestMapping("/delete/{id}")
    public String delPets(@PathVariable("id")long id){
        lostPetsRepository.delete(id);
        return "redirect:/";
    }
}
