using System.ComponentModel.DataAnnotations;

namespace CrudNet8MVC.Models
{
    public class Contacto
    {
        [Key]
        public int Id { get; set; }

        [Required(ErrorMessage = "El nombre es obligatorio")]
        public String Nombre { get; set; }

        [Required(ErrorMessage = "El apellido es obligatorio")]
        public String Apellidos { get; set; }

        [Required(ErrorMessage = "El telefono es obligatorio")]
        public String Telefono { get; set; }

        [Required(ErrorMessage = "El celular es obligatorio")]
        public String Celular { get; set; }

        [Required(ErrorMessage = "El email es obligatorio")]
        public String Email { get; set; }

        [Required(ErrorMessage = " El usuario es obligatorio")]
        public String Usuario { get; set; }
        
        [Required(ErrorMessage = "La contraseña es obligatoria")]
        public String Codigo { get; set; }
        


        public DateTime FechaCreacion { get; set; }
        
    }
}
