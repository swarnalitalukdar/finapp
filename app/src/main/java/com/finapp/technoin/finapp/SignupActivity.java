package com.finapp.technoin.finapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.android.volley.Request.Method.POST;

public class SignupActivity extends AppCompatActivity {
    private String SIGNUP_URL = "http://finapp-bengalhack.herokuapp.com/signup";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Button signupButton = findViewById(R.id.signUpButton);
        final EditText usernameText = findViewById(R.id.givenName);
        final EditText emailText = findViewById(R.id.givenEmail);
        final EditText passwordText = findViewById(R.id.givenPassword);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp(usernameText.getText().toString(),emailText.getText().toString(),passwordText.getText().toString());
            }
        });
    }

    void signUp(final String username,final String email,final String password){
        final JSONObject body = new JSONObject();
        try {
            body.put("username", username);
            body.put("password", password);
            body.put("email", email);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest singUpRequest = new JsonObjectRequest(POST, SIGNUP_URL, body, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(SignupActivity.this, "SignUp successful", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SignupActivity.this, "Not able to connect server", Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            public Map<String, String> getHeaders() {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(singUpRequest);
    }
}
