package catastro.coeficientes.funciones;

import accesoDatos.AccesoDatos;
import catastro.coeficientes.entidades.CoefAcabadosCubierta;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FCoefAcabCubierta {

    public static List<CoefAcabadosCubierta> obtenerCoefAcabadosCubierta() throws Exception {
        List<CoefAcabadosCubierta> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        CoefAcabadosCubierta coeficiente;
        ResultSet resultSet;
        String sql;
        try {
            accesoDatos = new AccesoDatos();
            sql = "SELECT * from catastro.f_coefiencientes_acab_cubierta();";
            resultSet = accesoDatos.ejecutaQuery(sql);
            while (resultSet.next()) {
                coeficiente = new CoefAcabadosCubierta();
                coeficiente.setIdCoeficiente(resultSet.getInt("sr_id_coef_cubierta"));
                coeficiente.setCoeficiente(resultSet.getString("chv_coeficiente"));
                coeficiente.setCodigo(resultSet.getInt("int_codigo"));
                coeficiente.setValorCoeficiente(resultSet.getDouble("db_valor_coef"));
                coeficiente.setEstadoLogico(resultSet.getString("ch_estado_logico"));
                coeficiente.setFechaRegistro(resultSet.getTimestamp("ts_fecha_registro"));
                coeficiente.setFechaActualizacion(resultSet.getTimestamp("ts_fecha_actualizacion"));
                coeficiente.setFechaBaja(resultSet.getTimestamp("ts_fecha_baja"));
                lst.add(coeficiente);
            }
        } catch (Exception e) {
            throw e;
        }
        return lst;
    }
}
