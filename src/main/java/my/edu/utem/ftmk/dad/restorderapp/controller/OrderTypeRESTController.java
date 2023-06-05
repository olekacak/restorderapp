package my.edu.utem.ftmk.dad.restorderapp.controller;

import my.edu.utem.ftmk.dad.restorderapp.model.OrderType;
import my.edu.utem.ftmk.dad.restorderapp.repository.OrderTypeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//class

@RestController
@RequestMapping("/api/ordertypes")
public class OrderTypeRESTController {

	@Autowired
	private OrderTypeRepository orderTypeRepository;
	
	@GetMapping
	public List<OrderType> getOrderTypes(){
		return orderTypeRepository.findAll();
	}
	
	@GetMapping("{orderTypeId}")
	public OrderType getOrderType(@PathVariable long orderTypeId) {
		
		OrderType orderType = orderTypeRepository.findById(orderTypeId).get();
		return orderType;
	}
	
	@PostMapping( )
	public OrderType insertOrderType(@RequestBody OrderType orderType) {
		
		return orderTypeRepository.save(orderType);
	}
	
	@PutMapping()
	public OrderType updateOrderType(@RequestBody OrderType orderType) {
		
		return orderTypeRepository.save(orderType);
	}
	
	@DeleteMapping("{orderTypeId}")
	public ResponseEntity<HttpStatus> deleteOrderType(@PathVariable long orderTypeId) {
		
		orderTypeRepository.deleteById(orderTypeId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
