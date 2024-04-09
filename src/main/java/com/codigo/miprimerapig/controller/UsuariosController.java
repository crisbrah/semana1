package com.codigo.miprimerapig.controller;

import com.codigo.miprimerapig.entity.UsuariosEntity;
import com.codigo.miprimerapig.service.IUsuariosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@RequestMapping("/api/v1/g4")
@AllArgsConstructor

public class UsuariosController {

    private final IUsuariosService usuariosService;
    @PostMapping("/save")
    public ResponseEntity<UsuariosEntity> crear(@RequestBody UsuariosEntity entity){
        UsuariosEntity usuariosEntity= usuariosService.crearusuario(entity);
        return ResponseEntity.ok(usuariosEntity);
    }

    @GetMapping(value="/find/{id}")
    public ResponseEntity<UsuariosEntity> getById(@PathVariable Long id){
        try {
            UsuariosEntity data  = usuariosService.findById(id);
            return new ResponseEntity<UsuariosEntity>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>((UsuariosEntity) map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscarxid/{id}")
    public ResponseEntity<UsuariosEntity> BuscarxId(@PathVariable Integer id){
        UsuariosEntity usuario=usuariosService.findById2(id);
        return ResponseEntity.ok(usuario);
    }


    @GetMapping(value="/usuarios")
    public ResponseEntity<Object> get(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<UsuariosEntity> list  = usuariosService.findAll();
            return new ResponseEntity<Object>(list,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     
}
