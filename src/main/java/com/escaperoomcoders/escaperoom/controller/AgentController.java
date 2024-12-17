package com.escaperoomcoders.escaperoom.controller;

import com.escaperoomcoders.escaperoom.model.Agent;
import com.escaperoomcoders.escaperoom.service.AgentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    // Crear un nuevo agente
    @PostMapping
    public ResponseEntity<Agent> createAgente(@RequestBody Agent agent) {
        Agent newAgent = agentService.saveAgent(agent);
        return ResponseEntity.ok(newAgent);
    }

    // Obtener todos los agentes
    @GetMapping
    public ResponseEntity<List<Agent>> getAllAgentes() {
        List<Agent> agent = agentService.getAllAgents();
        return ResponseEntity.ok(agent);
    }

    // Obtener un agente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Agent> getAgenteById(@PathVariable Long id) {
        Agent agent = agentService.getAgentById(id);
        return ResponseEntity.ok(agent);
    }

    // Editar un agente por ID
    @PutMapping("/{id}")
    public ResponseEntity<Agent> updateAgente(@PathVariable Long id, @RequestBody Agent updatedAgent) {
        Agent existingAgent = agentService.updateAgent(id, updatedAgent);
        return ResponseEntity.ok(existingAgent);
    }

    // Eliminar un agente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgente(@PathVariable Long id) {
        agentService.deleteAgent(id);
        return ResponseEntity.noContent().build();
    }
}
