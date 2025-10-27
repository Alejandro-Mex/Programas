using System.ComponentModel.DataAnnotations;

namespace SDA.Models
{
    public class Animal
    {
        [Key]
        public int IdAnimal { get; set; }
        [Required(ErrorMessage = "El Folio es obligatorio")]
        public string Folio { get; set; }
        [Required(ErrorMessage = "La especie es obligatoria")]
        public int Especie { get; set; }
        [Required (ErrorMessage = "La raza es obligatoria")]
        public string Raza { get; set; }
        [Required (ErrorMessage = "EL numero de arete es obligatorio")]
        public string NumeroArete { get; set; }
        [Required (ErrorMessage = "El sexo es obligatorio")]
        public string TipoSexo { get; set; }
        [Required (ErrorMessage = "La fecha de nacimiento es obligatoria")]
        public DateTime FechaNacimiento { get; set; }
        [Required (ErrorMessage = "La procedencia es obligatoria")]
        public String Procedencia { get; set; }
        [Required (ErrorMessage = "El peso es obligatorio")]
        public float Peso { get; set; }
        [Required (ErrorMessage = "El color es obligatorio")]
        public string Color { get; set; }
        [Required (ErrorMessage = "El caracter es obligatorio")]
        public string Caracter { get; set; }
        public string? Foto { get; set; }
        [Required (ErrorMessage = "El fecha de registro es obligatorio")]
        public DateTime FechaRegistro { get; set; }
        [Required (ErrorMessage = "El propietario es obligatorio")]
        public int IdPropietario { get; set; }
        [Required (ErrorMessage = "El rancho es obligatorio")]
        public int IdRancho { get; set; }

    }
}
