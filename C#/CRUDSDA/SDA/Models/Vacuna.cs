using System.ComponentModel.DataAnnotations;

namespace SDA.Models
{
    public class Vacuna
    {
        [Key]
        public int IdVacuna { get; set; }
        [Required(ErrorMessage = "El nombre de la vacuna es obligatoria")]
        public string NombreVacuna { get; set; }
        [Required(ErrorMessage = "La fecha de aplicacion de la vacuna es obligatoria")]
        public DateTime FechaAplicacion { get; set; }
        public string? Comentario { get; set; }
        [Required(ErrorMessage = "El id de animal es obligatorio")]
        public int IdAnimal { get; set; }
    }
}
