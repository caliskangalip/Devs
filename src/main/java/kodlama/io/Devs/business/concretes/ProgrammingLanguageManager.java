package kodlama.io.Devs.business.concretes;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.dataAccess.concretes.InMemoryProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProgrammingLanguageManager implements LanguageService {
    private InMemoryProgrammingLanguageRepository languageRepository;

    @Autowired
    public ProgrammingLanguageManager(InMemoryProgrammingLanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public void add(String name) {
        if (name==""){
            System.out.println("Programlama ismi boş geçilemez!");
            return;
        }
        for (ProgrammingLanguage lang:languageRepository.getAll()){
            if (lang.getName()==name){
                System.out.println("Bu programlama dili zaten mevcut!");
                return;
            }
        }
        languageRepository.add(name);
    }

    @Override
    public void delete(int id) {
        languageRepository.delete(id);
    }

    @Override
    public void update(int id, String name) {
        languageRepository.update(id,name);
    }
}
