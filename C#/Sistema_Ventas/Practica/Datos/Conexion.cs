using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Practica.Datos
{
    internal class Conexion
    {
        private string Servidor;
        private string Usuario;
        private string Clave;
        private string Database;
        private static Conexion con = null;

        public Conexion()
        {
            this.Servidor = "(LocalDb)\\MSSQLLocalDB";
            this.Database = "abarrotes";
            this.Clave = "ISC";
            this.Usuario = "user_ventas";
        }

        public SqlConnection CrearConexion()
        {
            SqlConnection Cadena = new SqlConnection();
            try
            {
                Cadena.ConnectionString =
                    "Server=" + this.Servidor +
                    ";Database=" + this.Database +
                    ";user id=" + this.Usuario +
                    ";Password=" + this.Clave;
            }
            catch (Exception ex)
            {
                Cadena = null;
                throw ex;
            }
            return Cadena;
        }

        public static Conexion getInstacia()
        {
            if(con == null)
            {
                con = new Conexion();
            }
            return con;
        }


    }
}
