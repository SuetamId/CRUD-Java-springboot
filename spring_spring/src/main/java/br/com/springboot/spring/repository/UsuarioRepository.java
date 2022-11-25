package br.com.springboot.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.springboot.spring.model.Usuario;




@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{


}
