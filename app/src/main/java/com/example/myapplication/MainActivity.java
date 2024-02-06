package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;


import Interface.ConsultaAsignatura;
import Interface.ConsultaAula;
import Interface.ConsultaHorario;
import Interface.ConsultaNota;
import Model.Asignatura;
import Model.Aula;
import Model.Horario;
import Model.Nota;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView myJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myJson = findViewById(R.id.jsonText);

        //getAsignatura("asignaturas", "1");
        //getAula("aulas","1");
        //getHorario("horarios","1");
        getNota("notas","2");


    }


    private void getAsignatura(String tipo_solicitud, String id_usuario) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/conexion/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ConsultaAsignatura consulta = retrofit.create(ConsultaAsignatura.class);
        Call<List<Asignatura>> call = consulta.getAsignatura(tipo_solicitud, id_usuario);
        call.enqueue(new Callback<List<Asignatura>>() {
            @Override
            public void onResponse(Call<List<Asignatura>> call, Response<List<Asignatura>> response) {
                if (!response.isSuccessful()) {
                    myJson.setText("Codigo: " + response.code());
                    return;
                }
                List<Asignatura> lista = response.body();
                for (Asignatura asignatura : lista) {
                    String content = "";
                    content += asignatura.getAsignatura() + "\n";
                    content += asignatura.getNombre() + "\n";


                    myJson.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Asignatura>> call, Throwable t) {
                myJson.setText(t.getMessage());
            }
        });
    }

    private void getAula(String tipo_solicitud, String id_usuario) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/conexion/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ConsultaAula consulta = retrofit.create(ConsultaAula.class);
        Call<List<Aula>> call = consulta.getAula(tipo_solicitud, id_usuario);
        call.enqueue(new Callback<List<Aula>>() {
            @Override
            public void onResponse(Call<List<Aula>> call, Response<List<Aula>> response) {
                if (!response.isSuccessful()) {
                    myJson.setText("Codigo: " + response.code());
                    return;
                }
                List<Aula> lista = response.body();
                for (Aula aula : lista) {
                    String content = "";
                    content += aula.getAsignatura() + ":\n";
                    content += aula.getAula() + "\n";


                    myJson.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Aula>> call, Throwable t) {
                myJson.setText(t.getMessage());
            }
        });
    }

    private void getNota(String tipo_solicitud, String id_usuario) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/conexion/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ConsultaNota consulta = retrofit.create(ConsultaNota.class);
        Call<List<Nota>> call = consulta.getNota(tipo_solicitud, id_usuario);
        call.enqueue(new Callback<List<Nota>>() {
            @Override
            public void onResponse(Call<List<Nota>> call, Response<List<Nota>> response) {
                if (!response.isSuccessful()) {
                    myJson.setText("Codigo: " + response.code());
                    return;
                }
                List<Nota> lista = response.body();
                for (Nota nota : lista) {
                    String content = "";
                    content += nota.getAsignatura() + ":\n";
                    content += nota.getNota() + "\n";


                    myJson.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Nota>> call, Throwable t) {
                myJson.setText(t.getMessage());
            }
        });
    }

    private void getHorario(String tipo_solicitud, String id_usuario) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/conexion/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ConsultaHorario consulta = retrofit.create(ConsultaHorario.class);
        Call<List<Horario>> call = consulta.getHorario(tipo_solicitud, id_usuario);
        call.enqueue(new Callback<List<Horario>>() {
            @Override
            public void onResponse(Call<List<Horario>> call, Response<List<Horario>> response) {
                if (!response.isSuccessful()) {
                    myJson.setText("Codigo: " + response.code());
                    return;
                }
                List<Horario> lista = response.body();
                for (Horario horario : lista) {
                    String content = "";
                    content += horario.getAsignatura() + ":\n";
                    content += horario.getHorario() + "\n";


                    myJson.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Horario>> call, Throwable t) {
                myJson.setText(t.getMessage());
            }
        });
    }
}