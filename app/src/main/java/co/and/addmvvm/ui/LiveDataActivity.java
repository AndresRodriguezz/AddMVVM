package co.and.addmvvm.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import co.and.addmvvm.R;
import co.and.addmvvm.User;
import co.and.addmvvm.viewmodel.LiveDataUserViewModel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Andres Rodriguez 27/06/2020
 */
public class LiveDataActivity extends AppCompatActivity {
    private Button btSaveLiveData;
    private TextView tvUserLiveData;

    private LiveDataUserViewModel liveDataUserViewModel;
    private int data = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        liveDataUserViewModel = new ViewModelProvider(this).get(LiveDataUserViewModel.class);

        tvUserLiveData = findViewById(R.id.tvUserLiveData);
        btSaveLiveData = findViewById(R.id.btSaveLiveData);
        btSaveLiveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data == 0) {
                    User user = new User();
                    user.setName("Andres");
                    user.setAge("24");
                    liveDataUserViewModel.addUser(user);
                }
                if (data == 1) {
                    User user = new User();
                    user.setName("Mari");
                    user.setAge("25");
                    liveDataUserViewModel.addUser(user);
                }
                if (data == 2) {
                    User user = new User();
                    user.setName("ELNene");
                    user.setAge("22");
                    liveDataUserViewModel.addUser(user);
                }
                data++;
            }
        });

        final Observer<List<User>> listObserver = new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                String text = "";
                for(int position = 0;position<users.size();position++){
                    text += users.get(position).getName() + "" + users.get(position).getAge() + "\n";
                }
                tvUserLiveData.setText(text);
            }
        };
        liveDataUserViewModel.getUserList().observe(this, listObserver);
    }
}