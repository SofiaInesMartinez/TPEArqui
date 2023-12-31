package tpe.userMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;
import tpe.userMS.DTO.DTOAccountRequest;
import tpe.userMS.DTO.DTOAccountResponse;
import tpe.userMS.DTO.DTOAccountUserStatusResponse;
import tpe.userMS.DTO.DTOReduceBalanceRequest;
import tpe.userMS.exception.AccountWithoutMoneyException;
import tpe.userMS.exception.DisabledUserException;
import tpe.userMS.exception.NotFoundException;
import tpe.userMS.model.Account;
import tpe.userMS.model.User;
import tpe.userMS.repository.AccountRepository;
import tpe.userMS.repository.UserRepository;

@Service("accountService")
public class AccountService {
	
	@Autowired
	private AccountRepository repository;
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public DTOAccountUserStatusResponse getAccountByUserIdWithBalance(long userId) throws AccountWithoutMoneyException {
//		return repository.getAccountByUserIdWithBalance(userId)
//				.map( DTOAccountResponse::new )
//				.orElseThrow(() -> new AccountWithoutMoneyException(userId));
		Optional<DTOAccountUserStatusResponse> optional = repository.getAccountByUserIdWithBalance(userId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new AccountWithoutMoneyException(userId);
		}
	}

	@Transactional(readOnly = true)
	public List<DTOAccountResponse> findAll() {
		return repository.findAll().stream().map(DTOAccountResponse::new).toList();
	}

	@Transactional
	public DTOAccountResponse save(@Valid DTOAccountRequest request) {
		Account account = new Account(request.getId(), request.getMoneyBalance());
		account = repository.save(account);
		return new DTOAccountResponse(account);
	}

	
		@Transactional(readOnly = true)
		public DTOAccountResponse getAccountById(long id) throws NotFoundException {
	        return repository.getAccountById(id)
	                .map(DTOAccountResponse::new)
	                .orElseThrow(() -> new NotFoundException("Account", id));
		}

		
	@Transactional(readOnly = true)
	public List<DTOAccountResponse> getAccountsBySimpleOrdering() {
		return repository.getAccountsBySimpleOrdering().stream().map(DTOAccountResponse::new).toList();
	}

	@Transactional
	public void delete(long id) throws NotFoundException  {
		try {
			if (repository.existsById(id)) {
				repository.deleteAccountById(id);
			} else {
				throw new NotFoundException("Account", id);
			}
		} catch (NumberFormatException e) {
	        throw new NumberFormatException("Invalid ID format");
		}
	}
	
	@Transactional
    public void reduceMoneyBalance(long id, DTOReduceBalanceRequest request) throws NotFoundException {
		if (repository.existsById(id)) {
			repository.reduceAccountMoneyBalance(request.getMoney(), id);
		} else {
			throw new NotFoundException("Account", id);
		}
    }


    @Transactional
    public void updateMoneyBalance(long id, int money) throws NotFoundException  {
    	if (repository.existsById(id)) {
    		repository.updateAccount(money, id);
    	} else {
    		throw new NotFoundException("Account", id);
    	}
    }

	@Transactional
	public void addUserToAccount(Long id, Long userId) throws NotFoundException, DisabledUserException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new NotFoundException("User", userId));
		
		if (user.getStatus() == 0) {
			throw new DisabledUserException(userId);
		}
		
		Account account = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Account", id));
//			account.getUsers().add(user);
//			repository.save(account); No funciona porque user es el duenio de la relacion
		
		user.getAccounts().add(account);
		userRepository.save(user);
	}

}
