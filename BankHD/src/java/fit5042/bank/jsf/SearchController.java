package fit5042.bank.jsf;

import fit5042.bank.entities.Transactions;
import fit5042.bank.entities.Users;
import fit5042.bank.sessionbean.JPABankRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.validation.constraints.Size;


/**
 * @author Yite Yao
 */
@Named(value = "searchController")
@SessionScoped
public class SearchController implements Serializable {

    @EJB
    private JPABankRepository JPAEJB;
    private List<Transactions> transactionList;
    private List<Users> userList;
    @Size(max=50)
    private String name;
    private String type;
    private int id;
    private Transactions transaction;
    @Size(max=50)
    private String fname;
    @Size(max=50)
    private String lname;
    private String userType;
    private String email;

    /**
     * Creates a new instance of SearchController
     */
    public SearchController() {
    }

    public String detail()
    {
        return "Detail.xhtml";
    }
    
    public String comboSearch() throws Exception
    {
        List<Users> list1 = JPAEJB.searchUserByFName(fname);
        List<Users> list2 = JPAEJB.searchUserByLName(lname);
        List<Users> list3 = JPAEJB.searchUserByEmail(email);
        List<Users> list4 = JPAEJB.searchUserByType(type);
        List<Users> listAll = new ArrayList<Users>();
        list1.removeAll(list2);
        list1.addAll(list2);
        list1.removeAll(list3);
        list1.addAll(list3);
        list1.removeAll(list4);
        list1.addAll(list4);
        userList = list1;
        return "ComboSearchResult";
    }
    
    public String searchByName() throws Exception
    {
        transactionList  = JPAEJB.searchTransactionByName(name);
//        if (items == null){
//        items.setWrappedData(transactionList);}
        return "result.xhtml";
    }
           
    public String searchByType() throws Exception
    {
        transactionList = JPAEJB.searchTransactionByType(type);
//        if (items == null){
//        items.setWrappedData(transactionList);}
        return "result.xhtml";
    }

    public String searchByid() throws Exception
    {
        transaction  = JPAEJB.searchTransactionById(id);
        return "idresult.xhtml";
    }
    
    
    public JPABankRepository getJPAEJB() {
        return JPAEJB;
    }

    public void setJPAEJB(JPABankRepository JPAEJB) {
        this.JPAEJB = JPAEJB;
    }

    public List<Transactions> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transactions> transactionList) {
        this.transactionList = transactionList;
    }

    public String detail(int id) throws Exception
    {
       transaction = JPAEJB.searchTransactionById(id);
       return "Detail.xhtml";
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Transactions getTransaction() {
        return transaction;
    }

    public void setTransaction(Transactions transaction) {
        this.transaction = transaction;
    }
    
    public List<Users> getUserList() {
        return userList;
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
