namespace Practica
{
    partial class Vista_Inventario
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.panel1 = new System.Windows.Forms.Panel();
            this.btnDelProd = new System.Windows.Forms.Button();
            this.btnUpdProd = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.btnAddProd = new System.Windows.Forms.Button();
            this.btnLstProd = new System.Windows.Forms.Button();
            this.panel2 = new System.Windows.Forms.Panel();
            this.txtStock = new System.Windows.Forms.TextBox();
            this.txtPrecio = new System.Windows.Forms.TextBox();
            this.txtCategoria = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.txtNombre = new System.Windows.Forms.TextBox();
            this.btnInsProd = new System.Windows.Forms.Button();
            this.btnCanProd = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.panel3 = new System.Windows.Forms.Panel();
            this.dgvProductos = new System.Windows.Forms.DataGridView();
            this.txtFiltrar = new System.Windows.Forms.TextBox();
            this.btnQryProd = new System.Windows.Forms.Button();
            this.label7 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.panel1.SuspendLayout();
            this.panel2.SuspendLayout();
            this.panel3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvProductos)).BeginInit();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.panel1.Controls.Add(this.btnDelProd);
            this.panel1.Controls.Add(this.btnUpdProd);
            this.panel1.Controls.Add(this.label1);
            this.panel1.Controls.Add(this.btnAddProd);
            this.panel1.Controls.Add(this.btnLstProd);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(872, 106);
            this.panel1.TabIndex = 0;
            // 
            // btnDelProd
            // 
            this.btnDelProd.Location = new System.Drawing.Point(727, 25);
            this.btnDelProd.Name = "btnDelProd";
            this.btnDelProd.Size = new System.Drawing.Size(110, 45);
            this.btnDelProd.TabIndex = 6;
            this.btnDelProd.Text = "Eliminar";
            this.btnDelProd.UseVisualStyleBackColor = true;
            this.btnDelProd.Click += new System.EventHandler(this.btnDelProd_Click);
            // 
            // btnUpdProd
            // 
            this.btnUpdProd.Location = new System.Drawing.Point(559, 25);
            this.btnUpdProd.Name = "btnUpdProd";
            this.btnUpdProd.Size = new System.Drawing.Size(110, 45);
            this.btnUpdProd.TabIndex = 4;
            this.btnUpdProd.Text = "Actualizar";
            this.btnUpdProd.UseVisualStyleBackColor = true;
            this.btnUpdProd.Click += new System.EventHandler(this.btnUpdProd_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.label1.Font = new System.Drawing.Font("Arial Narrow", 19.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.label1.Location = new System.Drawing.Point(23, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(153, 40);
            this.label1.TabIndex = 0;
            this.label1.Text = "Productos";
            // 
            // btnAddProd
            // 
            this.btnAddProd.Location = new System.Drawing.Point(395, 25);
            this.btnAddProd.Name = "btnAddProd";
            this.btnAddProd.Size = new System.Drawing.Size(110, 45);
            this.btnAddProd.TabIndex = 3;
            this.btnAddProd.Text = "Agregar";
            this.btnAddProd.UseVisualStyleBackColor = true;
            this.btnAddProd.Click += new System.EventHandler(this.btnAddProd_Click);
            // 
            // btnLstProd
            // 
            this.btnLstProd.Location = new System.Drawing.Point(229, 25);
            this.btnLstProd.Name = "btnLstProd";
            this.btnLstProd.Size = new System.Drawing.Size(110, 45);
            this.btnLstProd.TabIndex = 5;
            this.btnLstProd.Text = "Listado";
            this.btnLstProd.UseVisualStyleBackColor = true;
            this.btnLstProd.Click += new System.EventHandler(this.btnLstProd_Click);
            // 
            // panel2
            // 
            this.panel2.BackColor = System.Drawing.SystemColors.ActiveBorder;
            this.panel2.Controls.Add(this.txtStock);
            this.panel2.Controls.Add(this.txtPrecio);
            this.panel2.Controls.Add(this.txtCategoria);
            this.panel2.Controls.Add(this.label5);
            this.panel2.Controls.Add(this.txtNombre);
            this.panel2.Controls.Add(this.btnInsProd);
            this.panel2.Controls.Add(this.btnCanProd);
            this.panel2.Controls.Add(this.label4);
            this.panel2.Controls.Add(this.label2);
            this.panel2.Controls.Add(this.label3);
            this.panel2.Location = new System.Drawing.Point(12, 112);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(848, 98);
            this.panel2.TabIndex = 1;
            // 
            // txtStock
            // 
            this.txtStock.Location = new System.Drawing.Point(594, 58);
            this.txtStock.Name = "txtStock";
            this.txtStock.Size = new System.Drawing.Size(110, 22);
            this.txtStock.TabIndex = 8;
            // 
            // txtPrecio
            // 
            this.txtPrecio.Location = new System.Drawing.Point(409, 59);
            this.txtPrecio.Name = "txtPrecio";
            this.txtPrecio.Size = new System.Drawing.Size(98, 22);
            this.txtPrecio.TabIndex = 7;
            // 
            // txtCategoria
            // 
            this.txtCategoria.Location = new System.Drawing.Point(115, 58);
            this.txtCategoria.Name = "txtCategoria";
            this.txtCategoria.Size = new System.Drawing.Size(212, 22);
            this.txtCategoria.TabIndex = 6;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Arial", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(524, 58);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(64, 24);
            this.label5.TabIndex = 2;
            this.label5.Text = "Stock";
            // 
            // txtNombre
            // 
            this.txtNombre.Location = new System.Drawing.Point(115, 16);
            this.txtNombre.Name = "txtNombre";
            this.txtNombre.Size = new System.Drawing.Size(589, 22);
            this.txtNombre.TabIndex = 5;
            // 
            // btnInsProd
            // 
            this.btnInsProd.Location = new System.Drawing.Point(727, 16);
            this.btnInsProd.Name = "btnInsProd";
            this.btnInsProd.Size = new System.Drawing.Size(98, 35);
            this.btnInsProd.TabIndex = 4;
            this.btnInsProd.Text = "Registrar";
            this.btnInsProd.UseVisualStyleBackColor = true;
            this.btnInsProd.Click += new System.EventHandler(this.btnInsProd_Click);
            // 
            // btnCanProd
            // 
            this.btnCanProd.Location = new System.Drawing.Point(727, 57);
            this.btnCanProd.Name = "btnCanProd";
            this.btnCanProd.Size = new System.Drawing.Size(98, 35);
            this.btnCanProd.TabIndex = 3;
            this.btnCanProd.Text = "Cancelar";
            this.btnCanProd.UseVisualStyleBackColor = true;
            this.btnCanProd.Click += new System.EventHandler(this.btnCanProd_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Arial", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(333, 58);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(70, 24);
            this.label4.TabIndex = 1;
            this.label4.Text = "Precio";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Arial", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(14, 16);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(84, 24);
            this.label2.TabIndex = 0;
            this.label2.Text = "Nombre";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Arial", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(3, 57);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(101, 24);
            this.label3.TabIndex = 1;
            this.label3.Text = "Categoria";
            // 
            // panel3
            // 
            this.panel3.Controls.Add(this.dgvProductos);
            this.panel3.Controls.Add(this.txtFiltrar);
            this.panel3.Controls.Add(this.btnQryProd);
            this.panel3.Controls.Add(this.label7);
            this.panel3.Controls.Add(this.label6);
            this.panel3.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.panel3.Location = new System.Drawing.Point(0, 216);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(872, 414);
            this.panel3.TabIndex = 1;
            // 
            // dgvProductos
            // 
            this.dgvProductos.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvProductos.Location = new System.Drawing.Point(12, 100);
            this.dgvProductos.Name = "dgvProductos";
            this.dgvProductos.RowHeadersWidth = 51;
            this.dgvProductos.RowTemplate.Height = 24;
            this.dgvProductos.Size = new System.Drawing.Size(848, 302);
            this.dgvProductos.TabIndex = 7;
            this.dgvProductos.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvProductos_CellClick);
            // 
            // txtFiltrar
            // 
            this.txtFiltrar.Location = new System.Drawing.Point(108, 30);
            this.txtFiltrar.Name = "txtFiltrar";
            this.txtFiltrar.Size = new System.Drawing.Size(261, 22);
            this.txtFiltrar.TabIndex = 6;
            // 
            // btnQryProd
            // 
            this.btnQryProd.Location = new System.Drawing.Point(375, 28);
            this.btnQryProd.Name = "btnQryProd";
            this.btnQryProd.Size = new System.Drawing.Size(103, 27);
            this.btnQryProd.TabIndex = 5;
            this.btnQryProd.Text = "Buscar";
            this.btnQryProd.UseVisualStyleBackColor = true;
            this.btnQryProd.Click += new System.EventHandler(this.btnQryProd_Click);
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Arial", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label7.Location = new System.Drawing.Point(23, 73);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(188, 24);
            this.label7.TabIndex = 4;
            this.label7.Text = "Lista de productos";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Arial", 13.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label6.Location = new System.Drawing.Point(22, 26);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(79, 27);
            this.label6.TabIndex = 3;
            this.label6.Text = "Filtrar";
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(61, 4);
            // 
            // Vista_Inventario
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(872, 630);
            this.Controls.Add(this.panel3);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.Name = "Vista_Inventario";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Vista_Inventario_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.panel2.ResumeLayout(false);
            this.panel2.PerformLayout();
            this.panel3.ResumeLayout(false);
            this.panel3.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvProductos)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Button btnDelProd;
        private System.Windows.Forms.Button btnUpdProd;
        private System.Windows.Forms.Button btnAddProd;
        private System.Windows.Forms.Button btnLstProd;
        private System.Windows.Forms.Button btnInsProd;
        private System.Windows.Forms.Button btnCanProd;
        private System.Windows.Forms.Button btnQryProd;
        private System.Windows.Forms.TextBox txtStock;
        private System.Windows.Forms.TextBox txtPrecio;
        private System.Windows.Forms.TextBox txtCategoria;
        private System.Windows.Forms.TextBox txtNombre;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.DataGridView dgvProductos;
        private System.Windows.Forms.TextBox txtFiltrar;
    }
}

