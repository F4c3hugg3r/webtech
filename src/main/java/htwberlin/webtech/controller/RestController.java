package htwberlin.webtech.controller;

import htwberlin.webtech.model.Stat;
import htwberlin.webtech.model.StatId;
import htwberlin.webtech.persistence.StatRepository;
import htwberlin.webtech.service.StatsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
@RequestMapping("/stats")
public class RestController {

    private final StatsService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Stat>> getStats() {
        return ResponseEntity.ok(service.getStats());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Stat> updateStat(@Valid @RequestBody Stat body) {
//        if(!StatsService.checkExistence(body.getId(), body.getRating())) {
//            StatsService.addStat(body);
//        }
//        else {
            StatId statId = new StatId(body.getId().getQuestionId(), body.getId().getRating());
            service.saveStats(statId, body.getAnzahl());
//        }
        return new ResponseEntity<>(new Stat(statId, body.getAnzahl()), HttpStatus.CREATED);
    }


}
