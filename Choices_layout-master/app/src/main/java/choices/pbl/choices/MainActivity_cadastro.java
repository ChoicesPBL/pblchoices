package choices.pbl.choices;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity_cadastro extends AppCompatActivity {

    

    private String confirmar, nome, estado, cidade, datanasc;
    private EditText etNome,etSenha,etConfirmar,etUsuario, etDataNasc;
    private Spinner spEstado, spCidade;
    private Button btCadastrar;
    private Banco db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cadastro);

        db = new Banco(this);
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etSenha = (EditText) findViewById(R.id.etSenha);
        etConfirmar = (EditText) findViewById(R.id.etConfirmar);
        etNome = (EditText) findViewById(R.id.etNome);
        etDataNasc = (EditText) findViewById(R.id.etDataNasc);
        spEstado = (Spinner) findViewById(R.id.spEstado);
        spCidade = (Spinner) findViewById(R.id.spCidade);
        btCadastrar = (Button) findViewById(R.id.btCadastrar);

    }


    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btCadastrar:
                register();
                break;
            default:

        }
    }

    private void register(){
        String user = etUsuario.getText().toString();
        String pass = etSenha.getText().toString();
        if(user.isEmpty() && pass.isEmpty()){
            displayToast("campos obrigatórios");
        }else{
            db.addUser(user,pass);
            displayToast("USUARIO REGISTRADO!");
            finish();
        }
    }


    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}



