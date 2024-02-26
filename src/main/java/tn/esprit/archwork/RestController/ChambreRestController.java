package tn.esprit.archwork.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.archwork.Services.IChambreService;
import tn.esprit.archwork.entities.Chambre;
import tn.esprit.archwork.entities.TypeChambre;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {
    IChambreService iChambreService;

    @GetMapping("/affichertout")
    List<Chambre> retrieveAllChambres() {
        return iChambreService.retrieveAllChambres();
    }
    @PostMapping("/ajouterchambre")
    Chambre addChambre(@RequestBody Chambre c) {
        return iChambreService.addChambre(c);
    }
    @PutMapping("/upadtechambre")
    Chambre updateChambre(@RequestBody Chambre c) {
        return iChambreService.updateChambre(c);
    }

    @DeleteMapping("/deletechambre")
    List<Chambre> deleteChambre(@RequestBody Chambre c) {return iChambreService.deleteChambre(c); }
    @GetMapping("/afficherchambre/{idchambre}")
    Chambre retrieveChambre(@PathVariable("idchambre") long idChambre) {

        return iChambreService.retrieveChambre(idChambre);

    }

    @GetMapping("/get/{nom}")
    public List<Chambre> getChambreByNomBloc(@PathVariable("nom") String nom) {

        return iChambreService.getChambrebyByNomBloc("nom");
    }

    @GetMapping("/count-by-type-and-bloc")
    public ResponseEntity<Long> nbChambreParTypeEtBloc(
            @RequestParam("type") TypeChambre type,
            @RequestParam("idBloc") long idBloc
    ) {
        long count = iChambreService.nbChambreParTypeEtBloc(type, idBloc);

        return ResponseEntity.ok(count);
    }

    @GetMapping("/chambres-non-reservees")
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(
            @RequestParam("nomUniversite") String nomUniversite,
            @RequestParam("type") TypeChambre type
    ) {
        return iChambreService.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, type);
    }


}