package Interface;

import java.util.List;


import Model.Nota;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConsultaNota {
    @GET("consulta.php")
    Call<List<Nota>> getNota(@Query("tipo_solicitud") String tipo_solicitud, @Query("id_usuario") String id_usuario);
}
