package br.com.springboot.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.springboot.spring.model.Usuario;
import br.com.springboot.spring.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired /* IC/CD ou CDI - Injeção de dependencia */
	private UsuarioRepository usuarioRepository;

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
	
	/*metodo deletar dados no banco*/
	@DeleteMapping(value = "delete")
	@ResponseBody
	public ResponseEntity<String> delete(@RequestParam Long iduser){
		
		usuarioRepository.deleteById(iduser);
		
		return new ResponseEntity<String>("User deletado com sucesso", HttpStatus.OK);
	}
	
	/*metodo buscar pelo id dados no banco*/
	@GetMapping(value = "buscaruserid")
	@ResponseBody
	public ResponseEntity<Usuario> buscaruserid(@RequestParam(name = "iduser") Long iduser){
		
		Usuario	usuario = usuarioRepository.findById(iduser).get();
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	
	/*metodo atualizar dados no banco*/
	@PutMapping(value = "atualizar")
	@ResponseBody
	public ResponseEntity<?> atualzar(@RequestBody Usuario usuario){
		
		
		if (usuario.getId()== null) {
			return new ResponseEntity<String>("Usuario não encontrado", HttpStatus.OK);
		}
		Usuario	user = usuarioRepository.saveAndFlush(usuario);
		
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	
		

		
	}
	

	/*metodo buscar por parte do nome*/
	@GetMapping(value = "buscarPorNome")
	@ResponseBody
	public ResponseEntity<List<Usuario>> buscarPorNome(@RequestParam(name = "name") String name){
		
		List<Usuario> usuario = usuarioRepository.buscarPorNome(name);
		
		return new ResponseEntity<List<Usuario>>(usuario, HttpStatus.OK);
	}
}
