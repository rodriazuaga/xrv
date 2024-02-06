package Interface;

import java.util.List;


import Model.Horario;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConsultaHorario {
    @GET("consulta.php")
    Call<List<Horario>> getHorario(@Query("tipo_solicitud") String tipo_solicitud, @Query("id_usuario") String id_usuario);
}
