using CrudNet8MVC.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.Identity.Client;

namespace CrudNet8MVC.Datos
{
    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options):base(options)
        {    
        }
        public DbSet<Producto> Producto { get; set; }
    }
}
