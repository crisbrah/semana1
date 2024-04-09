package com.codigo.miprimerapig.service;

import com.codigo.miprimerapig.entity.UsuariosEntity;

import java.util.List;

public interface IUsuariosService {
    UsuariosEntity crearusuario(UsuariosEntity usuariosEntity);

    UsuariosEntity findById(Long id);

    UsuariosEntity findById2(Integer id);
    List<UsuariosEntity> findAll();

}
