package javainter.telldontask.good;



public interface IAccountRepository {
    Account getBydId(int id);

    void save(Account c);
}
