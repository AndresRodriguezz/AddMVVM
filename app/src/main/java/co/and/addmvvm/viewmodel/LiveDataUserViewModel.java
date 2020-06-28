package co.and.addmvvm.viewmodel;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import co.and.addmvvm.User;
/**
 * Created by Andres Rodriguez 27/06/2020
 */
public class LiveDataUserViewModel extends ViewModel {
    private MutableLiveData<List<User>> userListLiveData;
    private List<User> userList;

    public LiveData<List<User>> getUserList(){
        if(userListLiveData==null){
            userListLiveData = new MutableLiveData<List<User>>();
            userList = new ArrayList<>();
        }
        return userListLiveData;
    }

    public void addUser(User user){
        userList.add(user);
        userListLiveData.setValue(userList);
    }
}
