package DB;
import java.sql.*;
import javax.swing.JOptionPane;

public class cConexion {
    private String db="sql3235424";
    private String usr="sql3235424";
    private String pwd= "E1nTtsmm8W"; 
    private String url="jdbc:mysql://sql3.freemysqlhosting.net/" + db;
    private Connection conexion;//conexion con el paquete
    
    public cConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Llama un driver para controlar la conexion remota
            conexion= DriverManager.getConnection(url, usr, pwd); // Que la variable acceda a la conexion con esos parametros ya establecidos
        }
        catch (ClassNotFoundException | SQLException e) { // Alt 124: Si no se hace la conexión, aparece y menciona el error
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage()); 
        }
    }
    
    public ResultSet getRegistros(String sql) { // Método que se conecta para obtener los registros de la base de datos
        // Se inicializan las variables
        Statement sentencia; //El statement es equivalente a prepara la tabla para hacer un consulta de base de datos en SQL
        ResultSet res; // La variable res significa la respuesta (osea la tabla) generada al conectarse con la base de datos
    try {
        sentencia=conexion.createStatement(); // La variable sentencia utiliza el objeto de tipo conexión y genera la conección con la base de datos
        res = sentencia.executeQuery(sql); // Nos devuelve un objeto generado donde se ejecuta un query con parámetro de sql para obtener la información
    }
    catch(Exception e) { // En caso que exista un error
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage()); // Aparecerá una ventana con el mensaje de el problema sucedido
        res= null; // En este caso, no se devuelve
    }
    return res; // Te regresa el valor de los campos (registros) obtenidos con sql
    }
    
    public int Guardar (String sql, String [] Valores) // metodo publico que se llama guardar que devielve un entero
    {
        try {
            int nValores = (Valores.length)-1; // Nos da la longitud de cada valor
            PreparedStatement ps = conexion.prepareCall(sql); // Se crea una sentencia con nombre ps para preparar al servidos una consulta
            for (int x= 0; x<= nValores; x++) 
                ps.setString (x+1, Valores [x]); // Se hace la incercersion y se suma 1 ya que truena con o;
            // Valores[0]= "mario"; entonces 1 vale "mario" ya que se sumo x+1
            int nRegistros = ps. executeUpdate(); // Se ejecuta la sentencia y se obtiene un minimo registro
            return nRegistros;
        }
        catch(Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage()); 
        return 0;
    }
    }
    
    //Método útil para ejecutar cualquier consulta a la BD, si regresa 0 la ejecución falló, caso contrario devuelve 1
    public int ejecutarConsulta(String sql)
    {
        Statement sentencia;
        try
        {
            sentencia=conexion.createStatement();
            int nRegistros = sentencia.executeUpdate(sql);
            return nRegistros;
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return 0;
        }
    }

    //Al finalizar la aplicación, es necesario cerrar la conexión a la Base de Datos
    public void cerrarConexion()
    {
        try
        {
            conexion.close();
        }
        catch(SQLException e)
        {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}
