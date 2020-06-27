package co.and.addmvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import co.and.addmvvm.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Andres Rodriguez 25/06/2020
 */

public class MainActivity extends AppCompatActivity {
    private Button btViewModelActivityAdd;
    private Button btViewModelActivityUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btViewModelActivityAdd = findViewById(R.id.btnToActivityAdd);
        btViewModelActivityAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(MainActivity.this, ViewModelAddActivity.class);
                startActivity(mIntent);
            }
        });

        btViewModelActivityUser = findViewById(R.id.btnToActivityUser);
        btViewModelActivityUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(MainActivity.this, ViewModelUserActivity.class);
                startActivity(mIntent);
            }
        });


    }
}