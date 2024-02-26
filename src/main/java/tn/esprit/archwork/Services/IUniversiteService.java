package tn.esprit.archwork.Services;

import tn.esprit.archwork.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite(Universite b);
    Universite updateUniversite (Universite b);
    Universite retrieveUniversite (long idUniversite);



    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);

    Universite desaffecterFoyerAUniversite(long idFoyer, long idUniversite);
}
