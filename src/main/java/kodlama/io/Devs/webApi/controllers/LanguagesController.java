package kodlama.io.Devs.webApi.controllers;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/languages")
public class LanguagesController {
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }
    @GetMapping("/getAll")
    public List<ProgrammingLanguage> getAll(){
        return languageService.getAll();
    }
    //add, delete, update
    @GetMapping("/add")
    public void add(String name){
        languageService.add(name.toUpperCase());
    }
    @GetMapping("/delete")
    public void delete(int id){
        languageService.delete(id);
    }
    @GetMapping("/update")
    public void update(int id, String name){
        languageService.update(id, name.toUpperCase());
    }
}
