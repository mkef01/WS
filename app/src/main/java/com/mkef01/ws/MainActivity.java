package com.mkef01.ws;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {
    private EditText usuario,contrasena;
    public String user,pasw,url,resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.usuario);
        contrasena = findViewById(R.id.contraseña);
    }

    public void entrar(View v) throws JSONException {
        RequestParams parametros = new RequestParams();
        parametros.put("username",usuario.getText().toString());
        parametros.put("password",contrasena.getText().toString());
        getpost(parametros);
    }

    public void getpost(RequestParams parametros) {
        RestClient.post("algo",parametros,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    JSONObject id = (JSONObject) response.get(0);
                    String resultado = id.getString("password");
                    Toast.makeText(MainActivity.this,resultado,Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
