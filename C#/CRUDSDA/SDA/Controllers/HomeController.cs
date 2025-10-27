using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using SDA.Data;
using SDA.Models;
using System.Diagnostics;

namespace SDA.Controllers
{
    public class HomeController : Controller
    {
        //private readonly ILogger<HomeController> _logger;
        private readonly ApplicationDbContext _context;
        public HomeController(ApplicationDbContext context)
        {
            //_logger = logger;
            _context = context;
        }

        public IActionResult Index()
        {
            return View();
        }

        public IActionResult Sesion()
        {
            return View();
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }

        // Acción para la vista de sexo --------------------------------------------------------------------------------------------------------

        [HttpGet]
        public async Task<IActionResult> ConsultaSexo()
        {
            return View(await _context.Sexo.ToListAsync());
        }

        [HttpGet]
        public IActionResult SexoCrear()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> SexoCrear(Sexo sexo)
        {
            if (ModelState.IsValid)
            {
                _context.Sexo.Add(sexo);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(ConsultaSexo));
            }
            return View();
        }

        [HttpGet]
        public async Task<IActionResult> SexoEditar(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }
            var sexo = await _context.Sexo.FindAsync(id);
            if (sexo == null)
            {
                return NotFound();
            }
            return View(sexo);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> SexoEditar(Sexo sexo)
        {
            if (ModelState.IsValid)
            {
                _context.Sexo.Update(sexo);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(ConsultaSexo));
            }
            return View();
        }

        [HttpGet]
        public async Task<IActionResult> SexoBorrar(int? id)
        {
            if (id == null)
            {
                return NotFound();
            }
            var sexo = await _context.Sexo.FindAsync(id);
            if (sexo == null)
            {
                return NotFound();
            }
            return View(sexo);
        }

        [HttpPost, ActionName("SexoBorrar")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Borrar(int? id)
        {
            var sexo = await _context.Sexo.FindAsync(id);
            if (sexo == null)
            {
                return View();
            }
            _context.Sexo.Remove(sexo);
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(ConsultaSexo));
        }

        // Acción para la vista de propietario --------------------------------------------------------------------------------------------------------

    }
}
