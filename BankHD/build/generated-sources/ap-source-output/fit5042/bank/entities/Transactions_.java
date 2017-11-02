package fit5042.bank.entities;

import fit5042.bank.entities.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-22T12:52:26")
@StaticMetamodel(Transactions.class)
public class Transactions_ { 

    public static volatile SingularAttribute<Transactions, String> description;
    public static volatile SingularAttribute<Transactions, String> transactionname;
    public static volatile SingularAttribute<Transactions, String> type;
    public static volatile SingularAttribute<Transactions, Users> userid;
    public static volatile SingularAttribute<Transactions, Integer> transactionid;

}