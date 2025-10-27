using System.ComponentModel.DataAnnotations;

namespace SDA.Models
{
    public class Venta
    {
        [Key]
        public int IdVenta { get; set; }
        [Required(ErrorMessage = "El peso del animal es obligatorio")]
        public double Peso { get; set; }
        [Required(ErrorMessage = "El precio por kilo es obligatorio")]
        public double PrecioKilo { get; set; }
        [Required(ErrorMessage = "La fecha de la venta es obligatorio")]
        public DateTime FechaVenta { get; set; }
        [Required(ErrorMessage = "El Id del animal es obligatorio")]
        public int IdAnimal { get; set; }
    }
}
