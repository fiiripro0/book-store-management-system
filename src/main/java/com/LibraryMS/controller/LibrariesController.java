package com.LibraryMS.controller;

import com.LibraryMS.entity.Libraries;
import com.LibraryMS.service.LibrariesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LibrariesController {
    private final LibrariesService service;

    public LibrariesController(LibrariesService service) {
        this.service = service;
    }

    @PostMapping("/savelibrary")
    public String addLib(@ModelAttribute Libraries lib) {
        service.insertLib(lib);
        return "redirect:/libraryview";
    }

    @GetMapping("/libraryview")
    public String getAll(Model model) {
        List<Libraries> lip = service.getAllLib();
        model.addAttribute("libraryList", lip);
        return "libraryList";
    }

    @GetMapping("/editLibrary/{id}")
    public String editLibrary(@PathVariable("id") int id, Model model) {
        Libraries lib = service.getLibById(id);
        model.addAttribute("library", lib);
        return "editLibrary";
    }

    @GetMapping("/deleteLibrary/{id}")
    public String deleteLibrary(@PathVariable("id") int id) {
        service.delLibById(id);
        return "redirect:/libraryview";
    }

    @GetMapping("/library_register")
    public String showLibraryRegisterForm() {
        return "libraryRegister";
    }
}
