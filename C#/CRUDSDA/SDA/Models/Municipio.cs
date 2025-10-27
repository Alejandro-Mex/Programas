using System.ComponentModel.DataAnnotations;

namespace SDA.Models
{
    public class Municipio
    {
        [Key]
        public int IdMunicipio { get; set; }
        [Required(ErrorMessage = "El nombre del municipio es obligatorio")]
        public string NombreMunicipio { get; set; }
    }
}
