package Interface;

import java.util.List;

import Model.Asignatura;
import Model.Aula;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConsultaAula {
    @GET("consulta.php")
    Call<List<Aula>> getAula(@Query("tipo_solicitud") String tipo_solicitud, @Query("id_usuario") String id_usuario);
}
