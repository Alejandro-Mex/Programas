using System.ComponentModel.DataAnnotations;

namespace SDA.Models
{
    public class Sexo
    {
        [Key]
        public int IdSexo { get; set; }
        [Required(ErrorMessage = "El nombre del sexo es obligatorio")]
        [StringLength(15, ErrorMessage = "El nombre del sexo no puede exceder los 50 caracteres")]
        public string NombreSexo { get; set; }
    }
}
