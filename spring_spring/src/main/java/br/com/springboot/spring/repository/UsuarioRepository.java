package br.com.springboot.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.spring.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	/* jpql */
	/* pesquisar por partes like %?1% */
	@Query(value = "select u from Usuario u where u.nome like %?1%")

	List<Usuario> buscarPorNome(String name);

}
