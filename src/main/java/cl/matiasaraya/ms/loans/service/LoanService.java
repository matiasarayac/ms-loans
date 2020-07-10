package cl.matiasaraya.ms.loans.service;

import org.springframework.stereotype.Service;

import cl.matiasaraya.ms.loans.elements.Loan;

@Service
public class LoanService {
	
	public Loan getLoan() {
		Loan loan = new Loan();
		loan.setDebtAmount(1000);
		loan.setId(1);
		loan.setType("hipotecario");
		return loan;
	}

}
