package tn.esprit.archwork.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.archwork.Respositories.BlocRepo;
import tn.esprit.archwork.Respositories.ChambreRepo;
import tn.esprit.archwork.Respositories.FoyerRepo;
import tn.esprit.archwork.Respositories.UniversiteRepo;
import tn.esprit.archwork.entities.*;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    ChambreRepo chambreRepo;
    BlocRepo blocRepo;
    FoyerRepo foyerRepo;
    UniversiteRepo universiteRepo;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepo.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepo.findById(idChambre).orElse( null);  //or .get pour forcer
    }

    @Override
    public List<Chambre> deleteChambre(Chambre c) {
        chambreRepo.delete(c);
        return chambreRepo.findAll();
    }

    @Override
    public List<Chambre> getChambrebyByNomBloc(String nom) {
        return chambreRepo.findChambresByBloc_NomBloc(nom);
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        // Step 1: Retrieve the Bloc entity by its id
        Bloc bloc = blocRepo.findById(idBloc).orElse(null);

        if (bloc != null) {
            // Step 2: Query the database to count rooms of the specified TypeChambre in the given Bloc
            long count = chambreRepo.countByTypeAndBloc(type, bloc);

            // Step 3: Return the count as a long value
            return count;
        }

        // If the Bloc is not found, you can return -1 or handle the error appropriately
        return -1;
    }



    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        return null;
    }
/*
    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        // Assuming you have a method to find a Foyer by its name
        Foyer foyer = foyerRepo.findFoyerByNomFoyer(nomUniversite);

        if (foyer != null) {
            // Assuming you have a method in your repository to find non-reserved rooms by type and foyer
            return chambreRepo.findChambresNonReserveByTypeAndFoyer(type, foyer);
        } else {
            throw new RuntimeException("Foyer not found with name: " + nomUniversite);
        }
    }*/

    @Scheduled(cron = "*/5 * * * * *")
    void testSchedular() throws InterruptedException {

        log.info("test fixedDelay : ");
    }
}
