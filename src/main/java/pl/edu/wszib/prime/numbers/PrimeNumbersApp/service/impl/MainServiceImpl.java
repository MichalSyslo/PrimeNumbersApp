package pl.edu.wszib.prime.numbers.PrimeNumbersApp.service.impl;

import org.springframework.stereotype.Service;
import pl.edu.wszib.prime.numbers.PrimeNumbersApp.service.IMainService;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

@Service
public class MainServiceImpl implements IMainService {

    public List<Integer> calculatePrimeNumbers(int userNumber) {
        List<Integer> primeNumbers = new ArrayList<>();

        for(int i = 1; i<=userNumber; i++) {
            if(isPrime(i)) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        } else if (num <= 3) {
            return true;
        } else if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i <= sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
