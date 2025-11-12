package javainter.telldontask.good;



public class AccountService {

    private IAccountRepository repo;

    public AccountService(IAccountRepository repo) {
        this.repo = repo;
    }

    public void withDraw(int id, double amount) throws IllegalAccessException {
        Account account = repo.getBydId(id);

//        if(account.getBalance() < amount){
//            throw new IllegalAccessException("Error: not enough money!");
//        }
//        account.setBalance(account.getBalance() - amount);
        account.withDraw(amount);
        repo.save(account);
    }
}
