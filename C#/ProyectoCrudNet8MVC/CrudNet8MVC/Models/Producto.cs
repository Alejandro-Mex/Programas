using System.ComponentModel.DataAnnotations;

namespace CrudNet8MVC.Models
{
    public class Producto
    {
        public int Id { get; set; }
        [Required(ErrorMessage = "El nombre es obligatorio")]
        public string Nombre { get; set; }
        [Required(ErrorMessage = "El categoria es obligatorio")]
        public string Categoria { get; set; }
        [Required(ErrorMessage = "El precio es obligatorio")]
        public double? Precio { get; set; }
        [Required(ErrorMessage = "El stock es obligatorio")]
        public int? Stock { get; set; }
    }
}
