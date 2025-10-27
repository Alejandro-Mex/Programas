using System.ComponentModel.DataAnnotations;

namespace SDA.Models
{
    public class EmpleadoGobierno
    {
        [Key]
        public int IdEmpleadoGobierno { get; set; }
        [Required (ErrorMessage = "El nombre es obligatorio")]
        public string Nombre { get; set; }
        [Required (ErrorMessage = "El apellido paterno es obligatorio")]
        public string ApellidoPaterno { get; set; }
        [Required (ErrorMessage = "El apellido materno es obligatorio")]
        public string ApellidoMaterno { get; set; }
        [Required (ErrorMessage = "La edad es obligatoria")]
        public int Edad { get; set; }
        [Required (ErrorMessage = "El sexo es obligatorio")]
        public int Sexo { get; set; }
        [Required (ErrorMessage = "El CURP es obligatorio")]
        public string CURP { get; set; }
        [Required (ErrorMessage = "El cargo es obligatorio")]
        public string Cargo { get; set; }
        [Required (ErrorMessage = "La telefono es obligatoria")]
        public string Telefono { get; set; }
        [Required (ErrorMessage = "El correo es obligatorio")]
        public string Correo { get; set; }
        [Required (ErrorMessage = "La fecha de registro es obligatoria")]
        public DateTime FechaRegistro { get; set; }
        public string? Foto { get; set; }
        public int IdUsuario { get; set; }


    }
}
