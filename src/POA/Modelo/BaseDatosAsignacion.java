
package POA.Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebastian
 */
public class BaseDatosAsignacion {
    Conect conn = new Conect();
    
    public ArrayList<ModeloAsignacion> mostrarDatos(){
        
        ArrayList<ModeloAsignacion> lista = new ArrayList<>();
        
        String sql = "select * from asignacion";
        ResultSet rs= conn.query(sql);
        try {
            while(rs.next()){
                ModeloAsignacion m = new ModeloAsignacion();
                m.setId(rs.getInt("id"));
                m.setCodigoPersona(rs.getString("cedula_persona"));
                m.setPerfil(rs.getInt("perfil"));
                
                lista.add(m);
            }
            
//            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloAsignacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public void guardar(String cedulaPersona, int perfil){
        
        String sql = "insert into asignacion (cedula_persona, perfil) VALUES ('"  
                + cedulaPersona + "', " + perfil + ");";
        
        conn.noQuery(sql);
        
    }
    
    public void modificar(int codigo, String cedulaPersona, int perfil){
        
        String sql = "update asignacion set cedula_persona = '" + cedulaPersona + "', perfil = " + perfil + " "
                + "where id = " + codigo + ";";
        
        conn.noQuery(sql);
        
    }
    
    public void eliminar(int codigo){
        String sql = "delete from asignacion where codigo = '" + codigo + "';";
        
        conn.noQuery(sql);
    }
}
