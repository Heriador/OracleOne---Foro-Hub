package com.OracleOne.ForoHub.domain.service;

import com.OracleOne.ForoHub.domain.dto.request.ActualizarRespuesta;
import com.OracleOne.ForoHub.domain.dto.request.CrearRespuesta;
import com.OracleOne.ForoHub.domain.entity.Respuesta;
import com.OracleOne.ForoHub.domain.entity.Topico;
import com.OracleOne.ForoHub.domain.exceptions.RespuestaNotFoundException;
import com.OracleOne.ForoHub.domain.repository.IRespuestaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RespuestaService {

    @Autowired
    private IRespuestaRepository respuestaRepository;

    public void crearRespuesta(CrearRespuesta crearRespuesta) {
        Respuesta respuesta = new Respuesta();
        respuesta.setMensaje(crearRespuesta.getMensaje());
        Topico topico = new Topico();
        topico.setId(crearRespuesta.getTopicoId());
        respuesta.setTopico(topico);
        respuesta.setCreatedAt(LocalDateTime.now());
        respuestaRepository.save(respuesta);
    }

    public List<Respuesta> mostrarRespuestas() {
        return respuestaRepository.findAll();
    }

    public Respuesta mostrarRespuesta(Long id) {
        return respuestaRepository.findById(id).orElseThrow(()->new RespuestaNotFoundException("Respuesta no encontrada"));
    }

    public void borrarRespuesta(Long id) {
        Respuesta respuesta = respuestaRepository.findById(id).orElseThrow(()->new RespuestaNotFoundException("Respuesta no encontrada"));
        respuestaRepository.delete(respuesta);
    }

    public Respuesta actualizarRespuesta(Long id, @Valid ActualizarRespuesta actualizarRespuesta) {
        Respuesta respuesta = respuestaRepository.findById(id).orElseThrow(()->new RespuestaNotFoundException("Respuesta no encontrada"));
        respuesta.setMensaje(actualizarRespuesta.getMensaje());
        respuestaRepository.save(respuesta);
        return respuesta;
    }
}
