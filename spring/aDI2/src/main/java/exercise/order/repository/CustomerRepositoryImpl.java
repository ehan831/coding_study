package exercise.order.repository;

import exercise.order.domain.Customer;
import exercise.order.service.CustomerServiceImpl;

import javax.annotation.Resource;

@Resource(name="repository")
public class CustomerRepositoryImpl implements CustomerRepository {

    public CustomerRepositoryImpl(CustomerServiceImpl customerService) {
    }

    @Override
    public void save(Customer customer) {
        System.out.println( toString() + "가 저장되었습니다." );
    }

    @Override
    public void delete(long id) {
        System.out.println( id + "번 고객이 삭제되었습니다." );
    }

}