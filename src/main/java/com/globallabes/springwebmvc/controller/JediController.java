package com.globallabes.springwebmvc.controller;

import com.globallabes.springwebmvc.model.Jedi;
import com.globallabes.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class JediController {

    @Autowired
    public JediRepository jediRepository;

    @GetMapping("/jedi")
    public ModelAndView jedi() {

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");

        modelAndView.addObject("allJedi", jediRepository.getAllJedi());

        return modelAndView;
    }

    /*@GetMapping("/new-jedi")
    public ModelAndView newJedi(){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new-jedi");

        modelAndView.addObject("jedi", new Jedi());

        return modelAndView;
    }*/

    @GetMapping("/new-jedi")
    public String createJedi(Model model) {

        model.addAttribute("jedi", new Jedi());

        return "new-jedi";
    }

    @PostMapping("/jedi")
    public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirectAttributes) {

        if(result.hasErrors()) {
            return "/new-jedi";
        }

        jediRepository.add(jedi);

        redirectAttributes.addFlashAttribute("message", "Jedi successfully registered!");

        return "redirect:jedi";
    }
}
