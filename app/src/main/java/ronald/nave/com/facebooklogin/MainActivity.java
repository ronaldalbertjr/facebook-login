package ronald.nave.com.facebooklogin;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.*;
import android.widget.*;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText emailField;
    private Button btnLogin;
    private EditText passwordField;
    private EditText checkPasswordField;
    private TextView hiddenLabel;
    private TextView registroLabel;
    private boolean registerOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailField = (EditText) findViewById(R.id.emailEditText);
        passwordField = (EditText) findViewById(R.id.passwordEditText);
        hiddenLabel = (TextView) findViewById(R.id.hiddenLabel);
        checkPasswordField = (EditText) findViewById(R.id.checkPasswordEditText);

        registroLabel = (TextView) findViewById(R.id.registroButton);
        registroLabel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(!registerOn)
                {
                    registerOn = true;
                    btnLogin.setText("Register");
                    registroLabel.setText("Logar");
                    checkPasswordField.setVisibility(View.VISIBLE);
                }
                else
                {
                    registerOn = false;
                    btnLogin.setText("LOG IN");
                    registroLabel.setText("Registro");
                    checkPasswordField.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnLogin = (Button) findViewById(R.id.loginButton);
        btnLogin.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if(!registerOn)
        {
            if (emailField.getText().toString().equals("milho") && passwordField.getText().toString().equals("cozido")) {
                if (hiddenLabel.getVisibility() != View.VISIBLE)
                    hiddenLabel.setVisibility(View.VISIBLE);
                hiddenLabel.setText("Login Sucesso");
            } else {
                if (hiddenLabel.getVisibility() != View.VISIBLE)
                    hiddenLabel.setVisibility(View.VISIBLE);
                hiddenLabel.setText("Tente de novo");
            }
        }
        else if(registerOn)
        {
            if(passwordField.getText().toString().equals(checkPasswordField.getText().toString()))
            {
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage("Registro feito com sucesso");
                dlg.setNeutralButton("OK", null);
                dlg.show();
            }
            else
            {
                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage("As senhas não batem");
                dlg.setNeutralButton("OK", null);
                dlg.show();
            }
        }
    }
}
