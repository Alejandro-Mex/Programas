using Microsoft.EntityFrameworkCore;
using SDA.Models;

namespace SDA.Data
{
    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) : base(options)
        {
        }

        public DbSet<Animal> Animal { get; set; }
        public DbSet<EmpleadoGobierno> EmpleadoGobierno { get; set; }
        public DbSet<Propietario> Propietario { get; set; }
        public DbSet<Rancho> Rancho { get; set; }
        public DbSet<Usuario> Usuario { get; set; }
        public DbSet<Especies> Especie { get; set; }
        public DbSet<Sexo> Sexo { get; set; }
        public DbSet<Municipio> Municipio { get; set; }
        public DbSet<Venta> Venta { get; set; }
        public DbSet<Vacuna> Vacuna { get; set; }
        public DbSet<Enfermedad> Enfermedad { get; set; }

    }
}
