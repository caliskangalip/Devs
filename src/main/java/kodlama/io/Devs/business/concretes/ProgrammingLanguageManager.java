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
        if (name=="" || name==null){
            throw new RuntimeException("Dil adı boş geçilemez");
        }
        isLanguageExists(name);
        languageRepository.add(name);
    }

    @Override
    public void delete(int id) {
        languageRepository.delete(id);
    }

    @Override
    public void update(int id, String name) {
        isLanguageExists(name);
        languageRepository.update(id,name);
    }
    public void isLanguageExists(String name){
        if (languageRepository.getAll().stream().anyMatch(x -> x.getName().equals(name))){
            throw new RuntimeException(name+" isminde bir kayıt zaten mevcut");
        }
    }
}
