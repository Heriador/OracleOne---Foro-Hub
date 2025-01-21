package com.OracleOne.ForoHub.domain.service;

import com.OracleOne.ForoHub.domain.dto.request.CrearRespuesta;
import com.OracleOne.ForoHub.domain.entity.Respuesta;
import com.OracleOne.ForoHub.domain.entity.Topico;
import com.OracleOne.ForoHub.domain.repository.IRespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        respuestaRepository.save(respuesta);
    }
}
