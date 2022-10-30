package kodlama.io.Devs.dataAccess.abstracts;

import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface LanguageRepository {
    List<ProgrammingLanguage> getAll();
    public  void add(String name);
    public  void delete(int id);
    public void update(int id, String name);
}
