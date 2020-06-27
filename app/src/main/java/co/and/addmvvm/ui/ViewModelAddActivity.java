package co.and.addmvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import co.and.addmvvm.Add;
import co.and.addmvvm.R;
import co.and.addmvvm.viewmodel.AddViewModel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.security.Provider;

/**
 * Created by Andres Rodriguez 25/06/2020
 */

public class ViewModelAddActivity extends AppCompatActivity {
    private TextView tvNotViewModel;
    private TextView tvAddViewModel;
    private Button btAddNumbers;

    private int number;
    private AddViewModel addViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_add);

        tvNotViewModel = findViewById(R.id.tvNotViewModel);
        tvAddViewModel = findViewById(R.id.tvAddViewModel);

        addViewModel = new ViewModelProvider(this).get(AddViewModel.class);

        tvNotViewModel.setText(String.valueOf(number));
        tvAddViewModel.setText(String.valueOf(addViewModel.getResult()));

        btAddNumbers = findViewById(R.id.AddNumbers);
        btAddNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = Add.add(number);
                tvNotViewModel.setText(String.valueOf(number));

                addViewModel.setResult(Add.add(addViewModel.getResult()));
                tvAddViewModel.setText(String.valueOf(addViewModel.getResult()));
            }
        });
    }
}