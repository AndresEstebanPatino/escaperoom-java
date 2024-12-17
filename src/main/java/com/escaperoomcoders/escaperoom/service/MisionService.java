package com.escaperoomcoders.escaperoom.service;

import com.escaperoomcoders.escaperoom.model.Agent;
import com.escaperoomcoders.escaperoom.model.Mision;
import com.escaperoomcoders.escaperoom.repository.AgentRepository;
import com.escaperoomcoders.escaperoom.repository.MisionRespository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MisionService {

    private final MisionRespository misionrepository;
    private final AgentRepository agentRepository;
    private final EscapeRoomMailService escapeRoomMailService;

    public MisionService(MisionRespository misionrepository, AgentRepository agentRepository, EscapeRoomMailService escapeRoomMailService) {
        this.misionrepository = misionrepository;
        this.agentRepository = agentRepository;
        this.escapeRoomMailService =  escapeRoomMailService;
    }

    // Crear una misión
    public Mision saveMision(Mision mision) {
        return misionrepository.save(mision);
    }

    // Obtener todas las misiones
    public List<Mision> getAllMisiones() {
        return misionrepository.findAll();
    }

    // Obtener una misión por ID
    public Mision getMisionById(Long id) {
        return misionrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Misión no encontrada con ID: " + id));
    }

    // Editar una misión
    public Mision updateMision(Long id, Mision updatedMision) {
        Mision existingMision = misionrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Misión no encontrada con ID: " + id));

        // Actualizar los campos de la misión
        existingMision.setName(updatedMision.getName());
        existingMision.setDescription(updatedMision.getDescription());

        return misionrepository.save(existingMision);
    }

    // Eliminar una misión
    public void deleteMision(Long id) {
        if (!misionrepository.existsById(id)) {
            throw new RuntimeException("Misión no encontrada con ID: " + id);
        }
        misionrepository.deleteById(id);
        escapeRoomMailService.sendMailForChallenge("reto5");
    }

    @Transactional
    public Mision assignAgentToMission(Long missionId, Long agentId) {
        // Buscar misión por ID
        Mision mission = misionrepository.findById(missionId)
                .orElseThrow(() -> new RuntimeException("Mission not found with ID: " + missionId));

        // Buscar agente por ID
        Agent agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found with ID: " + agentId));

        // Verificar si el agente ya está asignado
        if (!mission.getAgents().contains(agent)) {
            mission.getAgents().add(agent);
            agent.getMissions().add(mission); // Actualizar la relación bidireccional
        }

        escapeRoomMailService.sendMailForChallenge("reto6");

        return misionrepository.save(mission);
    }


}

