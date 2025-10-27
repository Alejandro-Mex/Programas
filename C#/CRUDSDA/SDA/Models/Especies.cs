using System.ComponentModel.DataAnnotations;

namespace SDA.Models
{
    public class Especies
    {
        [Key]
        public int IdEspecie { get; set; }
        [Required(ErrorMessage = "El nombre de la especie es obligatorio")]
        public string NombreEspecie { get; set; }
    }
}
