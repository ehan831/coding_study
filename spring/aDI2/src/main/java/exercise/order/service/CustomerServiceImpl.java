package exercise.order.service;

import exercise.order.domain.Customer;
import exercise.order.repository.CustomerRepository;
import exercise.order.repository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

@Resource(name="customerService")
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository repository;

	public CustomerServiceImpl(Customer customer) {
	}

	@Override
	public void saveCustomer(Customer customer) {
		repository.save(customer);
	}

	@Override
	public void deleteCustomer(long id) {
		repository.delete(id);
	}
}
