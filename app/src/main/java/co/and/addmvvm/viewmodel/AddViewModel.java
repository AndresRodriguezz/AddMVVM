package co.and.addmvvm.viewmodel;

import androidx.lifecycle.ViewModel;

/**
 * Created by Andres Rodriguez 25/06/2020
 */
public class AddViewModel extends ViewModel {
    private int result;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
