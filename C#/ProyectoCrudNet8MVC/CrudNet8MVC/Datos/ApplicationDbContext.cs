using CrudNet8MVC.Models;
using Microsoft.EntityFrameworkCore;

namespace CrudNet8MVC.Datos
{
    public class ApplicationDbContext: DbContext
    { 
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options ) : base(options)
        {
            
        }

        //Agregar los modelos aqui(Cada modelo corresponde a una tabla)SS

        public DbSet<Contacto> Contacto { get; set; }
    }
}
