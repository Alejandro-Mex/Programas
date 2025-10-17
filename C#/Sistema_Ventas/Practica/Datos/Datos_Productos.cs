using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Practica.Datos
{
    public class Datos_Productos
    {
        public DataTable Consuta_productos(string cTexto)
        {
            SqlDataReader Resultado;
            DataTable Tabla = new DataTable();
            SqlConnection sqlcon = new SqlConnection();
            try
            {
                sqlcon = Conexion.getInstacia().CrearConexion();
                SqlCommand Comando = new SqlCommand("sp_consulta_productos", sqlcon);
                Comando.CommandType = CommandType.StoredProcedure;
                Comando.Parameters.Add("@cTexto", SqlDbType.VarChar).Value = cTexto;
                sqlcon.Open();
                Resultado = Comando.ExecuteReader();
                Tabla.Load(Resultado);
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                if(sqlcon.State == ConnectionState.Open)
                {
                    sqlcon.Close(); 
                }
            }
            return Tabla;
        }

        public bool Borrar_producto(int nId)
        {
            SqlConnection sqlCon  = Conexion.getInstacia().CrearConexion();
            try
            {
                sqlCon = Conexion.getInstacia().CrearConexion();
                SqlCommand Comando = new SqlCommand("sp_borrarProducto", sqlCon);
                Comando.CommandType = CommandType.StoredProcedure;
                Comando.Parameters.Add("@idProducto", SqlDbType.Int).Value = nId;
                sqlCon.Open();
                Comando.ExecuteReader();
                return true;
            }
            catch (Exception ex)
            {

            }
            finally
            {
                if(sqlCon.State == ConnectionState.Open)
                {
                    sqlCon.Close();
                }

            }
            return false;
        }

        public bool Agrega_producto(string cNombre,string cCategoria,float fPrecio,float fStock)
        {
            SqlConnection SqlCon = new SqlConnection();
            try
            {
                SqlCon = Conexion.getInstacia().CrearConexion();
                SqlCommand Comando = new SqlCommand("sp_agregarProducto", SqlCon);
                Comando.CommandType = CommandType.StoredProcedure;
                Comando.Parameters.Add("@cNombre", SqlDbType.VarChar).Value = cNombre;
                Comando.Parameters.Add("@cCategoria", SqlDbType.VarChar).Value = cCategoria;
                Comando.Parameters.Add("@fPrecio", SqlDbType.Float).Value = fPrecio;
                Comando.Parameters.Add("@fStock", SqlDbType.Float).Value = fStock;
                SqlCon.Open();
                Comando.ExecuteReader();
                return true;
            }
            catch (Exception ex)
            {
                return false;
                throw ex;
            }
            finally
            {
                if (SqlCon.State == ConnectionState.Open)
                {
                    SqlCon.Close();
                }
            }
        }

        public DataTable Datos_producto(int idProducto)
        {
            SqlDataReader Resultado;
            DataTable Tabla = new DataTable();
            SqlConnection SqlCon = new SqlConnection();
            try
            {
                SqlCon = Conexion.getInstacia().CrearConexion();
                SqlCommand Comando = new SqlCommand("sp_datos_producto", SqlCon);
                Comando.CommandType = CommandType.StoredProcedure;
                Comando.Parameters.Add("@idProducto", SqlDbType.Int).Value = idProducto;
                SqlCon.Open();
                Resultado = Comando.ExecuteReader();
                Tabla.Load(Resultado);
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                if(SqlCon.State == ConnectionState.Open)
                {
                    SqlCon.Close();
                }
            }
            return Tabla;
        }

        public bool Actualizar_producto(int idProducto, string cNombre, string cCategoria, float fPrecio, float fStock)
        {
            SqlConnection SqlCon = new SqlConnection();
            try
            {
                SqlCon = Conexion.getInstacia().CrearConexion();
                SqlCommand Comando = new SqlCommand("sp_actualizarProducto",SqlCon);
                Comando.CommandType = CommandType.StoredProcedure;
                Comando.Parameters.Add("@idProducto", SqlDbType.Int).Value = idProducto;
                Comando.Parameters.Add("@cNombre", SqlDbType.VarChar).Value = cNombre;
                Comando.Parameters.Add("@cCategoria", SqlDbType.VarChar).Value = cCategoria;
                Comando.Parameters.Add("@fPrecio", SqlDbType.Float).Value = fPrecio;
                Comando.Parameters.Add("@fStock", SqlDbType.Float).Value = fStock;
                SqlCon.Open();
                Comando.ExecuteReader();
                return true;
            }
            catch (Exception ex)
            {
                return false;
                throw ex;
            }
            finally
            {
                if( SqlCon.State == ConnectionState.Open )
                {
                    SqlCon.Close();
                }
            }
        }
    }
}
