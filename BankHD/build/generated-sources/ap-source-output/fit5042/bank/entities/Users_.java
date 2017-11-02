package fit5042.bank.entities;

import fit5042.bank.entities.Transactions;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-22T12:52:26")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> firstname;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> address;
    public static volatile SingularAttribute<Users, Double> balance;
    public static volatile SingularAttribute<Users, Integer> phonenumber;
    public static volatile SingularAttribute<Users, String> type;
    public static volatile SingularAttribute<Users, Integer> userid;
    public static volatile ListAttribute<Users, Transactions> transactionsList;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> lastname;

}