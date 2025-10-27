using System.ComponentModel.DataAnnotations;

namespace SDA.Models
{
    public class Enfermedad
    {
        [Key]
        public int IdEnfermedad { get; set; }
        [Required(ErrorMessage = "El nombre de la enfermedad es obligatoria")]
        public string NombreEnfermedad { get; set; }
        [Required(ErrorMessage = "La fecha de aplicacion de la enfermedad es obligatoria")]
        public DateTime FechaContagio { get; set; }
        public string? Comentario { get; set; }
        [Required(ErrorMessage = "El id de animal es obligatorio")]
        public int IdAnimal { get; set; }

    }
}
