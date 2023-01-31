package pl.edu.wszib.prime.numbers.PrimeNumbersApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.prime.numbers.PrimeNumbersApp.model.TargetNumber;
import pl.edu.wszib.prime.numbers.PrimeNumbersApp.service.IMainService;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private IMainService mainService;

    List<Integer> primeNumbers;

    @GetMapping(value = "/")
    public String landingPage() {

        return "redirect:/home";
    }

    @GetMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("targetNumber", new TargetNumber());
        model.addAttribute("primeNumbers", primeNumbers);

        return "/home";
    }

    @PostMapping(value = "/home")
    public String calculatePrimeNumbers(@ModelAttribute TargetNumber targetNumber) {
        primeNumbers = mainService.calculatePrimeNumbers(targetNumber.getTargetNumber());

        return "redirect:/home";
    }

}
