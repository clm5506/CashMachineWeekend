package rocks.zipcode.atm.bank;

/**
 * @author ZipCodeWilmington
 */
public final class AccountData {

    private final int id;
    private final String name;
    private final String email;

    private final Double balance;

    AccountData(int id, String name, String email, Double balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "You can the ZipCloudBank online portal to make withdrawals and deposits. " + '\n' +'\n'
                + "Please note BASIC Accounts do not allow funds to be overdrawn." + '\n'+'\n'
                + "All PREMIUM accounts can be overdrawn by $100.00 and are covered by overdraft protection!"+'\n';

                /*"Account id: " + id + '\n' +
                "Name: " + name + '\n' +
                "Email: " + email + '\n' +
                "Balance: " + balance;*/

    }

    public String getAccountID() {
        return ""+id;
    }

    public String getAccountName()  {
        return name;
    }

    public String displayBalanceMessage() {
       String message = "";
        if(getBalance() < 0) {
           message = "***** WARNING Insufficient Funds!! You have overdrawn your bank account! *****";
        }else {
            message = "You have " + balance + " available to be withdrawn.";
        }
        return message;
    }
}
