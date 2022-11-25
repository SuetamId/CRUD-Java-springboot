package br.com.springboot.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.spring.model.Usuario;
import br.com.springboot.spring.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired /* IC/CD ou CDI - Injeção de dependencia */
	private UsuarioRepository usuarioRepository;
	
	
	/**
	 *
	 * @param name the name to greet
	 * @return greeting text
	 */

	@RequestMapping(value = "teste/{nome}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	
	public String retornaOlaMundo(@PathVariable String nome) {
		
		Usuario usuario2= new Usuario();
		usuario2.setNome(nome);
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		
		usuarioRepository.save(usuario);/* grava no banco de dados */

		return "Ola mundo " + nome;
}
	
	
	/*metodo mostrar usuarios cadastrados no banco*/
	@GetMapping(value = "listatodos")
	
	@ResponseBody /*retorna JSON*/
	public ResponseEntity<List<Usuario>>listar(){
		List<Usuario> usuarios = usuarioRepository.findAll();/**faz a consulta no banco*/
		
		return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
	}
	
	/*metodo salvar dados no banco*/
	@PostMapping(value = "salvar")
	@ResponseBody
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
		
		Usuario	user = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}
	
	
}
