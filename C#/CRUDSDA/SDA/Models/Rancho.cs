using System.ComponentModel.DataAnnotations;

namespace SDA.Models
{
    public class Rancho
    {
        [Key]
        public int IdRancho { get; set; }
        [Required(ErrorMessage = "El nombre del rancho es obligatorio")]
        public string NombreRancho { get; set; }
        [Required(ErrorMessage = "La GPS latitud del rancho es obligatoria")]
        public string GpsLatitud { get; set; }
        [Required(ErrorMessage = "La GPS longitud del rancho es obligatoria")]
        public string GpsLongitud { get; set; }
        public string Foto { get; set; }
        [Required(ErrorMessage = "El municipio es obligatorio")]
        public int IdMunicipio { get; set; }
        [Required(ErrorMessage = "El propietario es obligatorio")]
        public int IdPropietario { get; set; }
    }
}
