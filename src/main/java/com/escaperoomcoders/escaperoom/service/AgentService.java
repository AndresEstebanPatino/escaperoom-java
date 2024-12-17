package com.escaperoomcoders.escaperoom.service;

import com.escaperoomcoders.escaperoom.model.Agent;
import com.escaperoomcoders.escaperoom.repository.AgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {

    private  final AgentRepository agentRepository;
    private  final EscapeRoomMailService escapeRoomMailService;

    public AgentService(AgentRepository agentRepository, EscapeRoomMailService escapeRoomMailService) {
        this.agentRepository = agentRepository;
        this.escapeRoomMailService = escapeRoomMailService;
    }

    public Agent saveAgent(Agent agent){
        return agentRepository.save(agent);
    }
    public List<Agent> getAllAgents(){
        return agentRepository.findAll();
    }
    public Agent getAgentById(Long id){
        return agentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encuentra el usuario con ID: " + id));
    }
    public Agent updateAgent(Long id, Agent updateAgent){
        Agent existingAgent = agentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encuentra el usuario con ID: " + id));

        existingAgent.setName(updateAgent.getName());
        existingAgent.setName((updateAgent.getSpecialty()));

        return agentRepository.save(existingAgent);
    }
    public void deleteAgent(Long id){
        if(!agentRepository.existsById(id)){
            throw new RuntimeException("No se encuentra el usuario con ID: " + id);
        }
        escapeRoomMailService.sendMailForChallenge("reto4");
        agentRepository.deleteById(id);

    }
}
