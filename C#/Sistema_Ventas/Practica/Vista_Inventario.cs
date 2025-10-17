using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Practica
{
    public partial class Vista_Inventario : Form
    {
        private static int idSelected = 0;
        private static int rowSelected = 0;
        private static int optionSelected = 0;
        public Vista_Inventario()
        {
            InitializeComponent();
        }

        private void Formato_Lista()
        {
            dgvProductos.Columns[0].Width = 50;
            dgvProductos.Columns[0].HeaderText = "ID";
            dgvProductos.Columns[1].Width = 345;
            dgvProductos.Columns[1].HeaderText = "Nombre";
            dgvProductos.Columns[2].Width = 70;
            dgvProductos.Columns[2].HeaderText = "Categoria";
            dgvProductos.Columns[3].Width = 50;
            dgvProductos.Columns[3].HeaderText = "Precio";
            dgvProductos.Columns[4].Width = 50;
            dgvProductos.Columns[4].HeaderText = "Stock";
        }

        private void Blanquear_Nuevo_Producto()
        {
            txtNombre.Text = string.Empty;
            txtCategoria.Text = string.Empty;
            txtPrecio.Text = string.Empty;
            txtStock.Text = string.Empty;  
        }

        private void Listado_productos(string cTexto)
        {
            Datos.Datos_Productos Datos = new Datos.Datos_Productos();
            dgvProductos.DataSource = Datos.Consuta_productos(cTexto);
            this.Formato_Lista();
        }

        private void Vista_Inventario_Load(object sender, EventArgs e)
        {
            panel2.Enabled = false;
            this.Listado_productos("%");
            txtFiltrar.Select();
        }

        private void btnQryProd_Click(object sender, EventArgs e)
        {
            this.Listado_productos(txtFiltrar.Text.Trim());
        }

        private void btnAddProd_Click(object sender, EventArgs e)
        {
            panel2.Enabled = true;
            txtNombre.Select();
            optionSelected = 1;
        }

        private void btnCanProd_Click(object sender, EventArgs e)
        {
            panel2.Enabled=false;
            Blanquear_Nuevo_Producto();
            txtFiltrar.Select();
        }

        private void btnLstProd_Click(object sender, EventArgs e)
        {
            panel2.Enabled = false;
            txtFiltrar.Text = string.Empty;
            this.Listado_productos("%");
            txtFiltrar.Select();
        }

        private void dgvProductos_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex >= 0 && e.ColumnIndex >= 0)
            {
                rowSelected = e.RowIndex;
                object cellValue = dgvProductos.Rows[rowSelected].Cells[0].Value;
                idSelected = Convert.ToInt32(cellValue);
                MessageBox.Show(idSelected.ToString());
            }
        }

        private void btnDelProd_Click(object sender, EventArgs e)
        {
            if(idSelected != 0)
            {
                string nombreProducto = dgvProductos.Rows[rowSelected].Cells[1].Value.ToString();
                string mensaje = "Desea eliminar el producto: " + nombreProducto;
                string titulo = "Eliminar producto";
                DialogResult dialogResult = MessageBox.Show(mensaje,titulo,MessageBoxButtons.YesNo);
                if (dialogResult == DialogResult.Yes)
                {
                    Datos.Datos_Productos Datos = new Datos.Datos_Productos();
                    if (Datos.Borrar_producto(idSelected))
                    {
                        dgvProductos.DataSource = Datos.Consuta_productos("%");
                        this.Formato_Lista();
                        MessageBox.Show("El producto " + nombreProducto + " se ha eliminado existosamente");
                    }
                    else
                    {
                        MessageBox.Show("Existe alguna restriccion que impide eliminar este producto.");
                    }
                }
                else if (dialogResult == DialogResult.No)
                {

                }
            }
            else
            {
                MessageBox.Show("Selecciona primero un producto");
            }
        }

        private void btnInsProd_Click(object sender, EventArgs e)
        {
            if(optionSelected == 1)
            {
                string cNombre = txtNombre.Text;
                string cCategoria = txtCategoria.Text;
                float fPrecio = Convert.ToSingle(txtPrecio.Text);
                float fStock = Convert.ToSingle(txtStock.Text);
                Datos.Datos_Productos Datos = new Datos.Datos_Productos();
                if (Datos.Agrega_producto(cNombre, cCategoria, fPrecio, fStock))
                {
                    dgvProductos.DataSource = Datos.Consuta_productos("%");
                    this.Formato_Lista();
                    Blanquear_Nuevo_Producto();
                    panel2.Enabled = false;
                    MessageBox.Show("Producto agregado");
                }
                else
                {
                    MessageBox.Show("Un error en los datos proporcionados impide agregar el producto.");
                }
            }
            else if(optionSelected == 2)
            {
                string cNombre = txtNombre.Text;
                string cCategoria = txtCategoria.Text;
                float fPrecio = Convert.ToSingle(txtPrecio.Text);
                float fStock = Convert.ToSingle(txtStock.Text);
                Datos.Datos_Productos Datos = new Datos.Datos_Productos();
                if (Datos.Actualizar_producto(idSelected,cNombre, cCategoria, fPrecio, fStock))
                {
                    dgvProductos.DataSource = Datos.Consuta_productos("%");
                    this.Formato_Lista();
                    Blanquear_Nuevo_Producto();
                    panel2.Enabled = false;
                    MessageBox.Show("Producto actualizado");
                }
                else
                {
                    MessageBox.Show("Un error en los datos introducidos impide actualizar el producto.");
                }
            }
        }

        private void btnUpdProd_Click(object sender, EventArgs e)
        {
            panel2.Enabled = true;
            txtNombre.Select();
            optionSelected = 2;
            if(idSelected != 0)
            {
                Datos.Datos_Productos Datos = new Datos.Datos_Productos();
                DataTable producto = new DataTable();
                producto = Datos.Datos_producto(idSelected);
                foreach (DataRow row in producto.Rows)
                {
                    string cNombre = row["Nombre"].ToString();
                    string cCategoria = row["Categoria"].ToString();
                    float fPrecio = Convert.ToSingle(row["Precio"]);
                    float fStock = Convert.ToSingle(row["Stock"]);

                    txtNombre.Text = cNombre;
                    txtCategoria.Text = cCategoria;
                    txtPrecio.Text = fPrecio.ToString();
                    txtStock.Text = fStock.ToString();
                } 
            }
            else
            {
                MessageBox.Show("Selecione primero un producto");
            }
        }
    }
}
