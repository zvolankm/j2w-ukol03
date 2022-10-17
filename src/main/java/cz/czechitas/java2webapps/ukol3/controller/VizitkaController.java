package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entita.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
@RequestMapping("/")
public class VizitkaController {
  private final List<Vizitka> seznamVizitek = List.of(
          new Vizitka("Martina Zvolankova", "Slunecnice", "Vrchlickeho 90", "15000 Praha 5", "martina@slunecnice.cz", "+420 775752238", "www.slunecnice.cz"),
          new Vizitka("Pavla Svobodova", "Slunecnice", "Moravanska 562", "619 00 Brno", null, "+420 775752238", "www.slunecnice.cz"),
          new Vizitka("Jana Navratilova", "Slunecnice", "Karlovo namesti 104", "38001 Trebic", "janaN@slunecnice.cs", "+420 775752238", "www.slunecnice.cz"),
          new Vizitka("Jana Zvolankova", "Slunecnice", "Karlovo namesti 104", "38001 Trebic", "janaZ@slunecnice.cs", "+420 775752238", "www.slunecnice.cz")

  );

  @GetMapping("/")
  public ModelAndView seznam() {
    ModelAndView modelAndView = new ModelAndView("/seznam");
    modelAndView.addObject("vizitky", seznamVizitek);
    return modelAndView;
  }

  @GetMapping("/detail/{id}")
  public ModelAndView detail(@PathVariable int id) {
    ModelAndView modelAndView = new ModelAndView("/detail");
    modelAndView.addObject("vizitka", seznamVizitek.get(id));
    return modelAndView;
  }
}
