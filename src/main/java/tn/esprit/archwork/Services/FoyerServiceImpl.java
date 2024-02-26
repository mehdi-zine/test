package tn.esprit.archwork.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.archwork.Respositories.BlocRepo;
import tn.esprit.archwork.Respositories.FoyerRepo;
import tn.esprit.archwork.Respositories.UniversiteRepo;
import tn.esprit.archwork.entities.Bloc;
import tn.esprit.archwork.entities.Foyer;
import tn.esprit.archwork.entities.Universite;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {

    private BlocRepo blocRepo;


    private UniversiteRepo universiteRepo;
    FoyerRepo foyerRepo ;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepo.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer b) {
        return foyerRepo.save(b);
    }

    @Override
    public Foyer updateFoyer(Foyer b) {
        return foyerRepo.save(b);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepo.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {

    }




}




