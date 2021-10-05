package root.database;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import root.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryImpl implements IUserRepository {

    private List<User> userList = new ArrayList<>();

    public UserRepositoryImpl() {
        userList.add(new User("admin", DigestUtils.md5Hex("admin")));
    }

    public boolean authenticate(String login, String pass) {
        for (User user : this.userList) {
            if (user.getLogin().equals(login)) {
                if (user.getPassword().equals(DigestUtils.md5Hex(pass))) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean register(String login, String pass) {
        for (User currentUser : this.userList) {
            if (currentUser.getLogin().equals(login)) {
                return false;
            }
        }
        this.userList.add(new User(login, DigestUtils.md5Hex(pass)));
        return true;
    }
}

