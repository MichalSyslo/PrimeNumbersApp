package pl.edu.wszib.prime.numbers.PrimeNumbersApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.prime.numbers.PrimeNumbersApp.model.UserNumber;
import pl.edu.wszib.prime.numbers.PrimeNumbersApp.service.IMainService;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private IMainService mainService;

    private List<Integer> primeNumbers;

    @GetMapping(value = "/")
    public String landingPage() {

        return "redirect:/index";
    }

    @GetMapping(value = "/index")
    public String home(Model model) {
        model.addAttribute("userNumber", new UserNumber());
        model.addAttribute("primeNumbers", primeNumbers);

        return "/index";
    }

    @PostMapping(value = "/index")
    public String calculatePrimeNumbers(@ModelAttribute UserNumber userNumber) {
        primeNumbers = mainService.calculatePrimeNumbers(userNumber.getUserNumber());

        return "redirect:/index";
    }
}
