package com.hospitals.infections.controller;

import com.hospitals.infections.model.Infections;
import com.hospitals.infections.service.InfectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value="hospitals/{hospitalName}/infections")
public class InfectionsController {

    @Autowired
    private InfectionsService infectionsService;

    @Autowired
    MessageSource messages;

    @GetMapping(value="/{patientsNumber}")
    public ResponseEntity<Infections> getInfections(
            @PathVariable("hospitalName") String hospitalName,
            @PathVariable("patientsNumber") String patientsNumber,
            @RequestHeader(value = "Accept-Language", required = false) Locale locale) {

        Infections infection = infectionsService.getInfections(hospitalName, patientsNumber, locale);

        infection.add(linkTo(methodOn(InfectionsController.class)
                            .getInfections(hospitalName, patientsNumber, locale))
                            .withSelfRel(),
                      linkTo(methodOn(InfectionsController.class)
                            .createInfections(hospitalName, infection, locale))
                            .withRel(messages.getMessage("infections.create.link", null, locale)),
                      linkTo(methodOn(InfectionsController.class)
                            .putInfections(hospitalName, infection.getId(), infection, locale))
                            .withRel(messages.getMessage("infections.update.link", null, locale)),
                      linkTo(methodOn(InfectionsController.class)
                            .deleteInfections(hospitalName, infection.getId(), locale))
                            .withRel(messages.getMessage("infections.delete.link", null, locale)));

        return ResponseEntity.ok(infection);
    }

    @PostMapping
    public ResponseEntity<Infections> createInfections(
            @PathVariable("hospitalName") String hospitalName,
            @RequestBody Infections request,
            @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(infectionsService.createInfections(request));
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> deleteInfections(
            @PathVariable("hospitalName") String hospitalName,
            @PathVariable("id") int patientId,
            @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(infectionsService.deleteInfections(hospitalName, patientId, locale));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<String> putInfections(
            @PathVariable("hospitalName") String hospitalName,
            @PathVariable("id") int id,
            @RequestBody Infections request,
            @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
        return ResponseEntity.ok(infectionsService.updateInfections(hospitalName, id, request, locale));
    }
}
