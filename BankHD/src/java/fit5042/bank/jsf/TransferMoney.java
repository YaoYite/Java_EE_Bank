package fit5042.bank.jsf;

import fit5042.bank.entities.Transactions;
import fit5042.bank.entities.Users;
import fit5042.bank.sessionbean.JPABankRepository;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author Yite Yao
 */
@Named(value = "transferMoney")
@SessionScoped
public class TransferMoney implements Serializable {

    @EJB
    private JPABankRepository JPAEJB;
//    private DataModel items;
//    private List<Users> userList;
    private Users user1;
    private Users user2;
    private double money;
    @NotNull
    private int fromId;
    @NotNull
    private int toId;
    @NotNull
    private String description;
    private Transactions newTransaction = new Transactions(1,"","","");
    private List<Transactions> TransactionList;
    

    /**
     * Creates a new instance of TransferMoney
     * @throws java.lang.Exception
     */
    public TransferMoney(){
        
    }
    public String transfer()
    {
//        userList = JPAEJB.getUsers();
//        items.setWrappedData(userList);
        return "/transfer/Transfer.xhtml";
    }
    
    public void searchByid() throws Exception 
    {
        user1  = JPAEJB.searchUserById(fromId);
        user2  = JPAEJB.searchUserById(toId);
    }
    
    public void transferMoney() throws Exception {
        double balance1 = user1.getBalance();
        double balance2 = user2.getBalance();
       user1.setBalance(balance1-money); 
       user2.setBalance(balance2+money);
       JPAEJB.editUser(user1);
       JPAEJB.editUser(user2);
//       userList = JPAEJB.getUsers();
//       items.setWrappedData(userList);
    }
    
    public void getAllTransactions() throws Exception{
        TransactionList = JPAEJB.getAllTransactions();
    }
    
    public void saveTransactionInfo() throws Exception{
        int transactionId = TransactionList.size() + 1;
        String type = "Transfer";
        String name = user1.getUserid() + " transfer $" + money + " to " + user2.getUserid();
        newTransaction.setTransactionid(transactionId);
        newTransaction.setTransactionname(name);
        newTransaction.setUserid(user1);
        newTransaction.setType(type);
        newTransaction.setDescription(description);
        JPAEJB.addTransaction(newTransaction);
    }
    public String finishTransfer() throws Exception{
        searchByid();
        transferMoney();
        getAllTransactions();
        saveTransactionInfo();
        return "/transactions/index.xhtml";
    }

    public JPABankRepository getJPAEJB() {
        return JPAEJB;
    }

    public void setJPAEJB(JPABankRepository JPAEJB) {
        this.JPAEJB = JPAEJB;
    }

    public Users getUser1() {
        return user1;
    }

    public void setUser1(Users user1) {
        this.user1 = user1;
    }

    public Users getUser2() {
        return user2;
    }

    public void setUser2(Users user2) {
        this.user2 = user2;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public Transactions getNewTransaction() {
        return newTransaction;
    }

    public void setNewTransaction(Transactions newTransaction) {
        this.newTransaction = newTransaction;
    }

//    public List<Transactions> getTransactionList() {
//        return TransactionList;
//    }
//
//    public void setTransactionList(List<Transactions> TransactionList) {
//        this.TransactionList = TransactionList;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public DataModel getItems() {
//        return items;
//    }
//
//    public void setItems(DataModel items) {
//        this.items = items;
//    }
//
//    public List<Users> getUserList() {
//        return userList;
//    }
//
//    public void setUserList(List<Users> userList) {
//        this.userList = userList;
//    }
}