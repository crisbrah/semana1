package com.codigo.miprimerapig.service.impl;

import com.codigo.miprimerapig.entity.UsuariosEntity;
import com.codigo.miprimerapig.repository.IUsuariosRepository;
import com.codigo.miprimerapig.service.IUsuariosService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImpl implements IUsuariosService {

    //@Autowired
    private final IUsuariosRepository usuariosRepository;

    public UsuariosServiceImpl(IUsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public UsuariosEntity crearusuario(UsuariosEntity usuariosEntity) {
        return usuariosRepository.save(usuariosEntity);
    }

    @Override
    public UsuariosEntity findById(Long id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    @Override
    public UsuariosEntity findById2(Integer id) {
        return usuariosRepository.findById(Long.valueOf(id)).get();
    }

    @Override
    @Transactional
    public List<UsuariosEntity> findAll() {
        return (List<UsuariosEntity>) usuariosRepository.findAll();
    }

}
