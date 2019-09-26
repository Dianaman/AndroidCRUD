package com.example.myapplication.Alta;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Alta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Alta");
        actionBar.setDisplayHomeAsUpEnabled(true);

        AltaModel model = new AltaModel();
        AltaController controller = new AltaController(model);
        AgregarListener listener = new AgregarListener(controller);
        AltaView view = new AltaView(model, listener, this);
        controller.setView(view);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(android.R.id.home == item.getItemId()){
            this.setResult(RESULT_CANCELED);
            super.finish();
        }

        return true;
    }
}
