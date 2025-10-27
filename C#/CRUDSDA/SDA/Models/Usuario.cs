using System.ComponentModel.DataAnnotations;

namespace SDA.Models
{
    public class Usuario
    {
        [Key]
        public int IdUsuario { get; set; }
        [Required (ErrorMessage= "El nombre de usuario es obligatorio")]
        public string NombreUsuario { get; set; }
        [Required (ErrorMessage= "La contraseña es obligatoria")]
        public string clave { get; set; }
    }
}
