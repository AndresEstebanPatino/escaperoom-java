package com.escaperoomcoders.escaperoom.controller;

import com.escaperoomcoders.escaperoom.model.Agent;
import com.escaperoomcoders.escaperoom.model.Mision;
import com.escaperoomcoders.escaperoom.service.EscapeRoomMailService;
import com.escaperoomcoders.escaperoom.service.MisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/misions")
public class MisionController {

    private final MisionService misionService;
    private final EscapeRoomMailService escapeRoomMailService;


    public MisionController(MisionService misionService, EscapeRoomMailService escapeRoomMailService) {
        this.misionService = misionService;
        this.escapeRoomMailService = escapeRoomMailService;

    }

    // Crear una nueva misión
    @PostMapping
    public ResponseEntity<Mision> createMision(@RequestBody Mision mision) {
        Mision nuevaMision = misionService.saveMision(mision);
        return ResponseEntity.ok(nuevaMision);
    }

    // Obtener todas las misiones
    @GetMapping
    public ResponseEntity<List<Mision>> getAllMisiones() {
        List<Mision> misiones = misionService.getAllMisiones();
        return ResponseEntity.ok(misiones);
    }

    // Obtener una misión por ID
    @GetMapping("/{id}")
    public ResponseEntity<Mision> getMisionById(@PathVariable Long id) {
        Mision mision = misionService.getMisionById(id);
        return ResponseEntity.ok(mision);
    }

    // Editar una misión por ID
    @PutMapping("/{id}")
    public ResponseEntity<Mision> updateMision(@PathVariable Long id, @RequestBody Mision updatedMision) {
        Mision misionActualizada = misionService.updateMision(id, updatedMision);
        return ResponseEntity.ok(misionActualizada);
    }

    // Eliminar una misión por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMision(@PathVariable Long id) {
        misionService.deleteMision(id);
        return ResponseEntity.noContent().build();
    }

    // Asignar un agente a una misión
    @PutMapping("/{misionId}/assign-agent/{agentId}")
    public ResponseEntity<Mision> assignAgentToMission(
            @PathVariable Long misionId,
            @PathVariable Long agentId) {

        Mision updatedMision = misionService.assignAgentToMission(misionId, agentId);


        return ResponseEntity.ok(updatedMision);
    }

}
