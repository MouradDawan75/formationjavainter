package javainter.telldontask.bad;

/*
Tell don't ask: dites, ne posez pas de questions.
Dites à vos objets ce qu'ils doivent faire, ne leur posez pas de questions sur leur état.
 */

public class AccountService {

    private AccountRepository repo;

    public void withDraw(int id, double amount) throws IllegalAccessException {
        Account account = repo.getBydId(id);

        if(account.getBalance() < amount){
            throw new IllegalAccessException("Error: not enough money!");
        }
        account.setBalance(account.getBalance() - amount);
        repo.save(account);
    }
}
