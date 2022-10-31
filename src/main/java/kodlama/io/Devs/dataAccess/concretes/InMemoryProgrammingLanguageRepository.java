package kodlama.io.Devs.dataAccess.concretes;

import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryProgrammingLanguageRepository implements LanguageRepository {
    List<ProgrammingLanguage> languages;

    public InMemoryProgrammingLanguageRepository() {
        languages=new ArrayList<ProgrammingLanguage>();
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return languages;
    }

    @Override
    public void add(String name) {
        int id=languages.size();
        ProgrammingLanguage programmingLanguage=new ProgrammingLanguage(id,name);
        languages.add(programmingLanguage);
        System.out.println(name+" dili kayıt edildi.");
    }

    @Override
    public void delete(int id) {
        for (ProgrammingLanguage programmingLanguage:languages){
            if (programmingLanguage.getId()==id){
                System.out.println(programmingLanguage.getName()+" dili kayıttan silindi.");
                languages.remove(programmingLanguage);
            }
        }
    }

    @Override
    public void update(int id, String name) {
        for (ProgrammingLanguage programmingLanguage:languages){
            if (programmingLanguage.getId()==id){
                System.out.println(programmingLanguage.getName()+" dilinin ismi "+name+" şeklinde değiştirildi.");
                programmingLanguage.setName(name);
            }
        }
    }
}
