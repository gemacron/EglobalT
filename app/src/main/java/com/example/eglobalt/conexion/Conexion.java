package com.example.eglobalt.conexion;

import com.example.eglobalt.entidades.Transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Conexion {
    private static final String CLASE = "org.postgresql.Driver";

    private final String host;
    private final String usuario;
    private final String clave;
    private final String nombre;
    private final String puerto;
    private final String url;

    private Connection link;
    private Statement statement;

    private String mensajeError;

    public Conexion() {

        /* Asignamos los atributos */
        this.host = "192.168.2.94";
        this.usuario = "ecaceres";
        this.clave = "ecaceres1234156";
        this.nombre = "eglobalpy";
        this.puerto = "5432";

        /* Asignamos el mensaje de error */
        this.mensajeError = "";

        /* Creamos la URL */
        this.url = "jdbc:postgresql://" + this.host + ":" +this.puerto+ "/" + this.nombre;

    }
    /**
     * Este metodo inicia la Conexion a la base de datos
     *
     * @return boolean Resultado de la operacion TRUE si se conecto
     * exitosamente, FALSE en caso contrario.
     */
    public boolean conectar() {

        try {

            Class.forName(CLASE).newInstance();
            this.link = DriverManager.getConnection(this.url, this.usuario, this.clave);

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            this.mensajeError = e.getMessage();
            return false;
        }

        return true;
    }
    /**
     * Se encarga de ejecutar una consulta, que no arrojara ningun resultado
     * (INSERT, UPDATE, DELETE).
     *
     * @param consulta Consulta a ejecutar
     * @return boolean Resultado de la operacion TRUE si se desconecto
     * exitosamente, FALSE en caso contrario.
     */
    public boolean consulta(String consulta) {

        int resultado;

        try {

            this.statement = this.link.createStatement();
            resultado = this.statement.executeUpdate(consulta);

        } catch (SQLException e) {
            this.mensajeError = e.getMessage();
            return false;
        }

        return (resultado > 0);
    }

    /**
     * Se encarga de ejecutar una consulta, que arrojara un resultado (SELECT)
     *
     * @param consulta Consulta a ejecutar
     * @return ArrayList Lista con los resultados obtenidos de la consulta
     */
    public List<Transactions> obtener(String consulta) {

        /* Resultados */
        List<Transactions> listado = new ArrayList<>();
        ResultSet resultado;

        /* Realizamos la consulta */
        try {

            this.statement = this.link.createStatement();
            resultado = this.statement.executeQuery(consulta);

        } catch (SQLException e) {
            this.mensajeError = e.getMessage();
            return null;
        }

        /* Guardamos el resultado */
        try {

            while (resultado.next()) {
                Transactions transaction = new Transactions();
                transaction.setId(resultado.getInt(1));
                transaction.setStatus(resultado.getString(3));
                listado.add(transaction);
            }

        } catch (SQLException e) {
            this.mensajeError = e.getMessage();
            return null;
        }

        return listado;
    }

    /**
     * Realiza la desconexion del DBMS
     *
     * @return boolean Resultado de la operacion TRUE si se desconecto
     * exitosamente, FALSE en caso contrario.
     */
    public boolean desconectar() {

        try {

            this.link.close();

        } catch (SQLException e) {
            this.mensajeError = e.getMessage();
            return false;
        }

        return true;
    }

    public String getMensajeError() {
        return mensajeError;
    }
}
