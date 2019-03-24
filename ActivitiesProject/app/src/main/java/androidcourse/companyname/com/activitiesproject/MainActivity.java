package androidcourse.companyname.com.activitiesproject;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextInputEditText Nombre;
    TextInputEditText Email;
    TextInputEditText Tel;
    DatePicker Birthday;
    EditText Description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aux = findViewById(R.id.IngButton);

        Nombre = findViewById(R.id.IETName);
        Email = findViewById(R.id.IETEmail);
        Tel = findViewById(R.id.IETTel);
        Birthday = findViewById(R.id.PBirthday);
        Description = findViewById(R.id.Description);

        try {
            Bundle parametros = getIntent().getExtras();

            String nombre = parametros.getString(getResources().getString(R.string.HintNombre));
            String numero = parametros.getString(getResources().getString(R.string.HintTel));
            String email = parametros.getString(getResources().getString(R.string.HintEmail));
            String birthday = parametros.getString(getResources().getString(R.string.Birthday));
            String description = parametros.getString(getResources().getString(R.string.DecriptionTitle));

            Nombre.setText(nombre);
            Tel.setText(numero);
            Description.setText(description);
            Email.setText(email);

            String[] fecha = birthday.split("/");
            Birthday.updateDate(Integer.parseInt(fecha[2]),Integer.parseInt(fecha[1]),Integer.parseInt(fecha[0]));
            //month start with zero

        }catch (Exception e){}

        aux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,InfoData.class);

                i.putExtra(getResources().getString(R.string.HintNombre),Nombre.getText().toString());
                i.putExtra(getResources().getString(R.string.HintEmail),Email.getText().toString());
                i.putExtra(getResources().getString(R.string.HintTel),Tel.getText().toString());
                i.putExtra(getResources().getString(R.string.DecriptionTitle),Description.getText().toString());
                i.putExtra(getResources().getString(R.string.Birthday),Integer.toString(Birthday.getDayOfMonth())+"/"+Integer.toString(Birthday.getMonth())+"/"+Integer.toString(Birthday.getYear()));
                startActivity(i);
                finish();
            }
        });
    }
}
