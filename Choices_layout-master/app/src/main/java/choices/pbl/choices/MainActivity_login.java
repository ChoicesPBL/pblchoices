package choices.pbl.choices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_login extends AppCompatActivity implements  View.OnClickListener{

    private EditText etUsuario, etSenha;
    public Button login;
    private  Banco db;
    private sessao sessao;
    public TextView tvNaoTenho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);


       db = new Banco(this);
        sessao = new sessao(this);
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etSenha = (EditText) findViewById(R.id.etSenha);
       login = (Button) findViewById(R.id.btLogin);
        tvNaoTenho = (TextView) findViewById(R.id.tvNaotenho);
      login.setOnClickListener(this);
        tvNaoTenho.setOnClickListener(this);

        if(sessao.loggedin()){
            startActivity(new Intent(MainActivity_login.this,MainActivity_menu.class));
            finish();
        }
    }



        public void onClick(View v) {
        switch(v.getId()){
            case R.id.btLogin:
                incluir();
                break;
            case R.id.tvNaotenho:
                startActivity(new Intent(MainActivity_login.this,MainActivity_cadastro.class));
                break;
            default:

        }
    }

    /**
     * n sei oque tá rolando aqui
     */
    private void incluir(){
        String email = etUsuario.getText().toString();
        String pass = etSenha.getText().toString();

        if(db.getUser(pass,email)){
            sessao.setLoggedin(true);
            startActivity(new Intent(MainActivity_login.this, MainActivity_menu.class));
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "usuario ou senha incorreta",Toast.LENGTH_SHORT).show();
        }
    }
}

