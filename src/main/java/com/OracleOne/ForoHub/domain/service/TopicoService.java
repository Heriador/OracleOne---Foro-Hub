package com.OracleOne.ForoHub.domain.service;

import com.OracleOne.ForoHub.domain.dto.request.CrearTopico;
import com.OracleOne.ForoHub.domain.entity.Topico;
import com.OracleOne.ForoHub.domain.exceptions.TopicoAlreadyExistsException;
import com.OracleOne.ForoHub.domain.repository.ITopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TopicoService {

    @Autowired
    private ITopicoRepository topicoRepository;


    public Topico crearTopico(CrearTopico crearTopico){

        if(topicoRepository.existsByTitulo(crearTopico.getTitulo())){
            throw new TopicoAlreadyExistsException("El titulo ya existe");
        }

        Topico topico = new Topico();
        topico.setTitulo(crearTopico.getTitulo());
        topico.setMensaje(crearTopico.getMensaje());
        topico.setCurso(crearTopico.getCurso());
        topico.setStatus("ACTIVO");
        topico.setCreatedAt(LocalDateTime.now());
        return topicoRepository.save(topico);
    }


}
