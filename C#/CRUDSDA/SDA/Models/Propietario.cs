using System.ComponentModel.DataAnnotations;

namespace SDA.Models
{
    public class Propietario
    {
        [Key]
        public int IdPropietario { get; set; }
        [Required(ErrorMessage = "El nombre es obligatorio")]
        public string Nombre { get; set; }
        [Required(ErrorMessage = "El apellido paterno es obligatorio")]
        public string ApellidoPaterno { get; set; }
        [Required(ErrorMessage = "El apellido materno es obligatorio")]
        public string? ApellidoMaterno { get; set; }
        [Required(ErrorMessage = "La fecha de nacimiento es obligatorio")]
        public DateTime FechaNacimiento  { get; set; }
        [Required(ErrorMessage = "El sexo es obligatorio")]
        public int Sexo { get; set; }
        [Required(ErrorMessage = "El CURP es obligatorio")]
        public string Curp { get; set; }
        [Required(ErrorMessage = "El teléfono es obligatorio")]
        public string Telefono { get; set; }
        [Required(ErrorMessage = "El correo electrónico es obligatorio")]
        public string Correo { get; set; }
        [Required(ErrorMessage = "La Fecha de registro es obligatoria")]
        public DateTime FechaRegistro { get; set; }
        public string? Foto { get; set; }
        [Required(ErrorMessage = "El municipio es obligatorio")]
        public int IdMunicipio { get; set; }
        public int? IdUsuario { get; set; }
    }
}
