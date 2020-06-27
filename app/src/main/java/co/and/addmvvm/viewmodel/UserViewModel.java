package co.and.addmvvm.viewmodel;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.ViewModel;
import co.and.addmvvm.User;

/**
 * Created by Andres Rodriguez 25/06/2020
 */

public class UserViewModel extends ViewModel {

    private List<User> usersList;

    //Builders
    public UserViewModel() {
        usersList = new ArrayList<>();
    }

    public UserViewModel(List<User> usersList) {
        this.usersList = usersList;
    }

    //Getters and Setters
    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    //Methods
    public void addUser(User user){
        usersList.add(user);
    }
}
