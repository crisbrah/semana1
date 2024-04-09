package com.codigo.miprimerapig.repository;

import com.codigo.miprimerapig.entity.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuariosRepository extends JpaRepository<UsuariosEntity, Long> {

}
