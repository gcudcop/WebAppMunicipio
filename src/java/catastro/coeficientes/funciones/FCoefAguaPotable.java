/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catastro.coeficientes.funciones;

import accesoDatos.AccesoDatos;
import catastro.coeficientes.entidades.CoefAguaPotable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FCoefAguaPotable {

    public static List<CoefAguaPotable> obtenerCoeficientes() throws Exception {
        List<CoefAguaPotable> lst = new ArrayList<>();
        AccesoDatos accesoDatos;
        CoefAguaPotable coeficiente;
        ResultSet resultSet;
        String sql;
        try {
            accesoDatos = new AccesoDatos();
            sql = "SELECT * from catastro.f_coefiencientes_agua_potable();";
            resultSet = accesoDatos.ejecutaQuery(sql);
            while (resultSet.next()) {
                coeficiente = new CoefAguaPotable();
                coeficiente.setIdCoeficiente(resultSet.getInt("sr_id_coeficiente"));
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
