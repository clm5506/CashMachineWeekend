package rocks.zipcode.atm.bank;

/**
 * @author ZipCodeWilmington
 */
public class PremiumAccount extends Account {

    private static final Double OVERDRAFT_LIMIT = 100.00;

    public PremiumAccount(AccountData accountData) {
        super(accountData);
    }

    @Override
    protected boolean canWithdraw(Double amount) {
        return getBalance() + OVERDRAFT_LIMIT >= amount;
    }
}
