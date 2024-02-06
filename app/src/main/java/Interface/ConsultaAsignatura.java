package Interface;

import java.util.List;

import Model.Asignatura;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConsultaAsignatura {
    @GET("consulta.php")
    Call<List<Asignatura>> getAsignatura(@Query("tipo_solicitud") String tipo_solicitud, @Query("id_usuario") String id_usuario);
}

