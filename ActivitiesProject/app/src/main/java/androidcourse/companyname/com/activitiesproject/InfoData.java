package androidcourse.companyname.com.activitiesproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoData extends AppCompatActivity {

    TextView NombreID;
    TextView EmailID;
    TextView TelID;
    TextView BirthdayID;
    TextView DescriptionID;
    String fechaStringID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_data);

        Button aux = findViewById(R.id.EditButton);

        NombreID = findViewById(R.id.TVName);
        EmailID = findViewById(R.id.toEditEmail);
        TelID = findViewById(R.id.toEditTel);
        BirthdayID = findViewById(R.id.toEditBirthday);
        DescriptionID = findViewById(R.id.toEditDescription);

        try {
            Bundle parametros = getIntent().getExtras();

            String nombre = parametros.getString(getResources().getString(R.string.HintNombre));
            String numero = parametros.getString(getResources().getString(R.string.HintTel));
            String email = parametros.getString(getResources().getString(R.string.HintEmail));
            fechaStringID = parametros.getString(getResources().getString(R.string.Birthday));
            String description = parametros.getString(getResources().getString(R.string.DecriptionTitle));

            NombreID.setText(nombre);
            TelID.setText(numero);
            DescriptionID.setText(description);
            EmailID.setText(email);

            String[] fecha = fechaStringID.split("/");
            String month_aux = Integer.toString(Integer.parseInt(fecha[1])+1);
            month_aux = fecha[0]+"/"+month_aux+"/"+fecha[2];
            BirthdayID.setText(month_aux);
            //month start with zero

        }catch (Exception e){}

        aux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InfoData.this,MainActivity.class);

                i.putExtra(getResources().getString(R.string.HintNombre),NombreID.getText().toString());
                i.putExtra(getResources().getString(R.string.HintEmail),EmailID.getText().toString());
                i.putExtra(getResources().getString(R.string.HintTel),TelID.getText().toString());
                i.putExtra(getResources().getString(R.string.DecriptionTitle),DescriptionID.getText().toString());
                i.putExtra(getResources().getString(R.string.Birthday),fechaStringID);
                startActivity(i);
                finish();
            }
        });
    }
}
