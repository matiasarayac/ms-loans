package cl.matiasaraya.ms.loans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.matiasaraya.ms.loans.elements.Loan;
import cl.matiasaraya.ms.loans.service.LoanService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/loans")
public class LoansController {
	
	@Autowired
	private LoanService loanService;
	
	/** GET **/	
	@GetMapping(value = "/getLoan/", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Retrieve the loan by the given id", response = Loan.class, responseContainer = "", notes = "Returns true for success and false for error operation")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success return the Loan Object", response = Boolean.class),
			@ApiResponse(code = 204, message = "No content, without content for the query"),
			@ApiResponse(code = 500, message = "Internal Server Error, Exception message") })
	public ResponseEntity<Loan> getLoan(@RequestParam int id) {		
							
		Loan loan = loanService.getLoan();
				
		try {
			if (loan.getId() == id) {
				return new ResponseEntity<>(loan, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		
	}

}
