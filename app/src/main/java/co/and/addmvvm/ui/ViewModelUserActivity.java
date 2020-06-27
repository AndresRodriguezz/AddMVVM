package co.and.addmvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import co.and.addmvvm.R;
import co.and.addmvvm.User;
import co.and.addmvvm.viewmodel.UserViewModel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andres Rodriguez 25/06/2020
 */

public class ViewModelUserActivity extends AppCompatActivity {
  private   EditText etName, etAge;
  private   TextView tvUserNameViewModelActivity,tvUserAgeViewModelActivity,tvUserNameViewModel,tvUserAgeViewModel;
  private   Button btSave,btSee;

  private UserViewModel userViewModel;
  private List<User> userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_view_user);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);

        tvUserNameViewModelActivity = findViewById(R.id.tvUserNameViewModelActivity);
        tvUserAgeViewModelActivity = findViewById(R.id.tvUserAgeViewModelActivity);
        tvUserNameViewModel = findViewById(R.id.tvUserNameViewModel);
        tvUserAgeViewModel = findViewById(R.id.tvUserAgeViewModel);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userList = new ArrayList<>();

        btSave = findViewById(R.id.btSave);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setName(etName.getText().toString());
                user.setAge(etAge.getText().toString());
                userViewModel.addUser(user);
                userList.add(user);
            }
        });

        btSee = findViewById(R.id.btSee);
        btSee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textNameActivity = "";
                String textAgeActivity = "";
                String textName = "";
                String textAge = "";

                for(User user: userViewModel.getUsersList()){
                    textNameActivity += user.getName() + "\n";
                    textAgeActivity += user.getAge() + "\n";

                }
                tvUserNameViewModel.setText(textNameActivity);
                tvUserAgeViewModel.setText(textAgeActivity);

                for (int position=0;position<userList.size();position++){
                    textName += userList.get(position).getName() + "\n";
                    textAge += userList.get(position).getAge() + "\n";

                }

                tvUserNameViewModelActivity.setText(textName);
                tvUserAgeViewModelActivity.setText(textAge);

            }

        });

    }
}