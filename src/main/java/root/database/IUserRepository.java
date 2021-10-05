package root.database;


public interface IUserRepository {
    boolean register(String login, String pass);

    boolean authenticate(String login, String password);

}
