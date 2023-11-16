package tpe.userMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tpe.userMS.DTO.DTORoleRequest;
import tpe.userMS.DTO.DTORoleResponse;
import tpe.userMS.exception.NotFoundException;
import tpe.userMS.exception.RoleWithNameAlreadyExistsException;
import tpe.userMS.service.RoleService;

@RestController
@RequestMapping("role")
public class RoleController {

	@Autowired
	private RoleService service;
	
	@GetMapping("")
	public ResponseEntity<List<DTORoleResponse>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DTORoleResponse> findById(@PathVariable long id) throws NotFoundException {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping("")
	public ResponseEntity<DTORoleResponse> saveRole(@RequestBody @Valid DTORoleRequest request) throws RoleWithNameAlreadyExistsException {
		return ResponseEntity.ok(service.saveRole(request));
	}
}