using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.ComponentModel.DataAnnotations;
using System.Threading.Tasks;

namespace BlogCore.Models
{
    public class Categoria
    {
        [Key]
        public int Id { get; set; }

        [Required (ErrorMessage = "Ingrese el nombre de la categoria")]
        [Display(Name="Nombre de categoria")]
        public string Nombre { get; set; }

        [Display(Name = "Orden de visualizacion")]
        [Range(1, 100, ErrorMessage = "El valor debe de estar entre 1 - 100")]
        public int? Orden {  get; set; }

    }
}
