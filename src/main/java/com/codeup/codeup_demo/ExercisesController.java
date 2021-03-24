package com.codeup.codeup_demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class ExercisesController {
    @GetMapping("/roll-dice")
    public String guessForm(){
        return "roll";
    }

    @GetMapping("/roll-dice/{n}")
    public String answerForm(@PathVariable(name = "n") int guess,
                             Model viewModel){
        Random rand = new Random();
//        int cleaned;
//        cleaned = (int) guess;

        int answer = rand.nextInt(6) + 1;

//        int answer = 4;
        Boolean correct = answer == guess;

        viewModel.addAttribute("guess", guess);
        viewModel.addAttribute("answer", "The correct answer is " + answer);
        viewModel.addAttribute("correct", correct);
        return "roll-ans";
    }
}
