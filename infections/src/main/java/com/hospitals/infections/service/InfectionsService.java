package com.hospitals.infections.service;

import com.hospitals.infections.config.ServiceConfig;
import com.hospitals.infections.model.Infections;
import com.hospitals.infections.repository.InfectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class InfectionsService {

    @Autowired
    MessageSource messages;
    @Autowired
    private InfectionsRepository infectionsRepository;
    @Autowired
    ServiceConfig config;

    public Infections getInfections(String hospitalName, String patientsNumber, Locale locale) {
        Infections infection = infectionsRepository.findByHospitalNameAndPatientsNumber(hospitalName, patientsNumber);

        if (infection == null) {
            throw new IllegalArgumentException(
                    String.format(
                            messages.getMessage(
                                    "infections.search.error.message",null,locale),
                            hospitalName, patientsNumber));
        }

        return infection.withComment(config.getProperty());
    }

    public Infections createInfections(Infections infection) {
        infectionsRepository.save(infection);

        return infection.withComment(config.getProperty());
    }

    public String deleteInfections(String hospitalName, int id, Locale locale) {
        String responseMessage;
        Infections infection = new Infections();
        infection.setHospitalName(hospitalName);
        infection.setId(id);
        infectionsRepository.delete(infection);

        responseMessage = String.format(messages.getMessage("infections.delete.message", null, locale),
                id, hospitalName);

        return responseMessage;
    }

    public String updateInfections(String hospitalName, int id, Infections request, Locale locale) {
        Infections infection = infectionsRepository.findByHospitalNameAndId(hospitalName, id);

        if (infection == null) {
            throw new IllegalArgumentException(
                    String.format(
                            messages.getMessage(
                                    "infections.search.error.message",null,locale),
                            hospitalName, id));
        } else {
            if (request.getHospitalName() != null) infection.setHospitalName(request.getHospitalName());
            if (request.getPatientsNumber() != null) infection.setPatientsNumber(request.getPatientsNumber());
            if (request.getStoolType() != null) infection.setStoolType(request.getStoolType());
            infection.setAbdominalPain(request.isAbdominalPain());
            infection.setPuke(request.isPuke());

            infectionsRepository.save(infection);
        }

        return String.format(messages.getMessage("infections.update.message", null, locale),
                infection.toString());
    }
}
