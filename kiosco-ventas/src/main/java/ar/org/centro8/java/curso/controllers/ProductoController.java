package ar.org.centro8.java.curso.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.org.centro8.java.curso.model.entity.Producto;
import ar.org.centro8.java.curso.services.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("productos", service.listar());
        return "productos-list";
    }

    @GetMapping("/alta")
    public String alta(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto-alta";
    }

    @PostMapping("/guardar")
    public String guardar(Producto p) {
        service.guardar(p);
        return "redirect:/productos";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam int id, Model model) {
        model.addAttribute("producto", service.buscar(id));
        return "producto-editar";
    }

    @PostMapping("/actualizar")
    public String actualizar(Producto p) {
        service.actualizar(p);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam int id, RedirectAttributes ra) {
        try {
            service.eliminar(id);
            ra.addFlashAttribute("mensaje", "Producto eliminado correctamente.");
        } catch (DataIntegrityViolationException e) {
            ra.addFlashAttribute("error",
                    "No se puede eliminar el producto porque tiene ventas asociadas. " +
                            "Para eliminarlo, primero debe eliminar o anular esas ventas.");
        }
        return "redirect:/productos";
    }
}