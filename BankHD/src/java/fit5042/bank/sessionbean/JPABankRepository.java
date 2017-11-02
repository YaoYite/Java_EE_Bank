package fit5042.bank.sessionbean;

import fit5042.bank.entities.Transactions;
import fit5042.bank.entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author Yite Yao
 */
@Stateless
public class JPABankRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addTransaction(Transactions transaction) throws Exception { 
        entityManager.persist(transaction);
    }

    public void addUser(Users user) throws Exception { 
        entityManager.persist(user);
    }
    
    public Transactions searchTransactionById(int id) throws Exception {    
        Transactions transaction = entityManager.find(Transactions.class, id);
        return transaction;
    }
    
    public Users searchUserById(int id) throws Exception {    
        Users user = entityManager.find(Users.class, id);
        return user;
    }
    
    
    public List<Transactions> searchTransactionByType(String type) throws Exception
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Transactions.class);
        Root<Transactions> t = query.from(Transactions.class);
        query.select(t);
        Predicate predicate = builder.equal(t.get("type").as(String.class), type);
        query.where(predicate);
        TypedQuery tQuery = entityManager.createQuery(query);
        return tQuery.getResultList();
    }
    
    public List<Transactions> searchTransactionByName(String name) throws Exception
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Transactions.class);
        Root<Transactions> t = query.from(Transactions.class);
        query.select(t);
        Predicate predicate = builder.equal(t.get("transactionname").as(String.class), name);
        query.where(predicate);
        TypedQuery tQuery = entityManager.createQuery(query);
        return tQuery.getResultList();
    }
    
    public List<Users> searchUserByFName(String fname) throws Exception
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Users.class);
        Root<Users> u = query.from(Users.class);
        query.select(u);
        Predicate predicate = builder.equal(u.get("firstname").as(String.class), fname);
        query.where(predicate);
        TypedQuery tQuery = entityManager.createQuery(query);
        return tQuery.getResultList();
    }
    
    public List<Users> searchUserByLName(String lname) throws Exception
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Users.class);
        Root<Users> u = query.from(Users.class);
        query.select(u);
        Predicate predicate = builder.equal(u.get("lastname").as(String.class), lname);
        query.where(predicate);
        TypedQuery tQuery = entityManager.createQuery(query);
        return tQuery.getResultList();
    }
    
    public List<Users> searchUserByEmail(String email) throws Exception
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Users.class);
        Root<Users> u = query.from(Users.class);
        query.select(u);
        Predicate predicate = builder.equal(u.get("email").as(String.class), email);
        query.where(predicate);
        TypedQuery tQuery = entityManager.createQuery(query);
        return tQuery.getResultList();
    }
    
    public List<Users> searchUserByType(String type) throws Exception
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Users.class);
        Root<Users> u = query.from(Users.class);
        query.select(u);
        Predicate predicate = builder.equal(u.get("type").as(String.class), type);
        query.where(predicate);
        TypedQuery tQuery = entityManager.createQuery(query);
        return tQuery.getResultList();
    }
    
    public List<Users> searchUserByAddress(String address) throws Exception
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Users.class);
        Root<Users> u = query.from(Users.class);
        query.select(u);
        Predicate predicate = builder.equal(u.get("address").as(String.class), address);
        query.where(predicate);
        TypedQuery tQuery = entityManager.createQuery(query);
        return tQuery.getResultList();
    }

    public List<Users> searchUserByPhonenumber(int phonenumber) throws Exception
    {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Users.class);
        Root<Users> u = query.from(Users.class);
        query.select(u);
        Predicate predicate = builder.equal(u.get("phonenumber").as(String.class), phonenumber);
        query.where(predicate);
        TypedQuery tQuery = entityManager.createQuery(query);
        return tQuery.getResultList();
    }
    
    public List<Transactions> getAllTransactions() throws Exception {        
        return entityManager.createNamedQuery(Transactions.GET_ALL_QUERY_NAME).getResultList();
    }
    
    
    public List<Transactions> searchTransactionByUser(Users user) throws Exception {
        user = entityManager.find(Users.class, user.getUserid());
        user.getTransactionsList().size();
        entityManager.refresh(user);

        return user.getTransactionsList();
    }
    
    public List<Users> getUsers() throws Exception {    
        return entityManager.createNamedQuery(Users.GET_ALL_QUERY_NAME).getResultList();
    }

    public void removeTransaction(int transactionId) throws Exception {          
        Transactions transaction = this.searchTransactionById(transactionId);
      
        if (transaction != null) {
            entityManager.remove(transaction);
        }
    }
    
    public void removeUser(int userId) throws Exception {          
        Users user = this.searchUserById(userId);
      
        if (user != null) {
            entityManager.remove(user);
        }
    }

    public void editTransaction(Transactions transaction) throws Exception {      
        entityManager.merge(transaction);
    }  
    
    public void editUser(Users user) throws Exception {      
        entityManager.merge(user);
    }  
}
