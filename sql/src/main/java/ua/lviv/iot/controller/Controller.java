package ua.lviv.iot.controller;

import ua.lviv.iot.model.*;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

public class Controller implements IController {
    private static CollectinCah collectinCah;
    private static Address address;
    private static Information information;
    private static Overhaul overhaul;
    private static ProvidedServices providedServices;
    private static ServicedCompany servicedCompany;
    private static ServiceWizard serviceWizard;
    private static ServiceWork serviceWork;
    private static Standart standart;
    private static Terminal terminal;

    public Controller(){
        collectinCah = new CollectinCah();
        address = new Address();
        information = new Information();
        overhaul = new Overhaul();
        providedServices = new ProvidedServices();
        servicedCompany = new ServicedCompany();
        serviceWizard = new ServiceWizard();
        serviceWork = new ServiceWork();
        standart = new Standart();
        terminal = new Terminal();
    }



    @Override
    public void findByTerminalId(Integer id) throws SQLException {
        terminal.findById(id);
    }

    @Override
    public void createTerminal(Integer id,  String logo, String function) throws SQLException {
        terminal.create(id, logo, function);
    }

    @Override
    public void updateTerminal(Integer id,  String logo, String function) throws SQLException {
        terminal.update(id, logo, function);
    }

    @Override
    public void deleteTerminal(Integer id) throws SQLException {
        terminal.delete(id);
    }

    @Override
    public void findAllTerminals() throws SQLException {
        terminal.findAll();
    }

    @Override
    public void deleteStandart(Integer id) throws SQLException {
        standart.delete(id);
    }

    @Override
    public void findStandartById(Integer id) throws SQLException {
    	standart.findById(id);
    }

    @Override
    public void createStandart(Integer id, Double pay, Date date) throws SQLException {
    	standart.create(id, pay, date);
    }

    @Override
    public void updateStandart(Integer id, Double pay, Date date) throws SQLException {
    	standart.update(id, pay, date);
    }

    @Override
    public void findAllStandart() throws SQLException {
        standart.findAll();
    }

    @Override
    public void findAllServiceWork() throws SQLException {
    	serviceWork.findAll();
    }

    @Override
    public void findByIdServiceWork(Integer id) throws SQLException {
    	serviceWork.findById(id);
    }

    @Override
    public void createServiceWork(Integer id, String master, Double priceOfMaster, Double servicePrice, Time time) throws SQLException {
    	serviceWork.create(id, master, priceOfMaster, servicePrice, time);
    }

    @Override
    public void updateServiceWork(Integer id, String master, Double priceOfMaster, Double servicePrice, Time time) throws SQLException {
    	serviceWork.update(id, master, priceOfMaster, servicePrice, time);
    }

    @Override
    public void deleteServiceWork(Integer id) throws SQLException {
    	serviceWork.delete(id);
    }

    @Override
    public void findAllServiceWizard() throws SQLException {
    	serviceWizard.findAll();
    }

    @Override
    public void findByIdServiceWizard(Integer id) throws SQLException {
    	serviceWizard.findById(id);
    }

    @Override
    public void createServiceWizard(Integer id, String firstName, String secondName) throws SQLException {
    	serviceWizard.create(id, firstName, secondName);
    }

    @Override
    public void updateServiceWizard(Integer id, String firstName, String secondName) throws SQLException {
    	serviceWizard.update(id, firstName, secondName);
    }

    @Override
    public void deleteServiceWizard(Integer id) throws SQLException {
    	serviceWizard.delete(id);
    }

    @Override
    public void findAllServicedCompany() throws SQLException {
    	servicedCompany.findAll();
    }

    @Override
    public void findServicedCompanyById(Integer id) throws SQLException {
    	servicedCompany.findById(id);
    }

    @Override
    public void createServicedCompany(Integer id, String name, String email, Integer staff) throws SQLException {
    	servicedCompany.create(id, name, email, staff);
    }

    @Override
    public void updateServicedCompany(Integer id, String name, String email, Integer staff) throws SQLException {
    	servicedCompany.update(id, name, email, staff);
    }

    @Override
    public void deleteServicedCompany(Integer id) throws SQLException {
    	servicedCompany.delete(id);
    }

    @Override
    public void findAllProvidedServices() throws SQLException {
    	providedServices.findAll();
    }

    @Override
    public void findProvidedServicesById(Integer id) throws SQLException {
    	providedServices.findById(id);
    }

    @Override
    public void createProvidedServices(Integer id, String type) throws SQLException {
    	providedServices.create(id, type);
    }

    @Override
    public void updateProvidedServices(Integer id, String type) throws SQLException {
    	providedServices.update(id, type);
    }

    @Override
    public void deleteProvidedServices(Integer id) throws SQLException {
    	providedServices.delete(id);
    }

    @Override
    public void findAllOverhaul() throws SQLException {
    	overhaul.findAll();
    }

    @Override
    public void findOverhaul(Integer id) throws SQLException {
    	overhaul.findById(id);
    }

    @Override
    public void createOverhaul(Integer id, String changeDiscription, String changeFunctions, String changingParts, Date date) throws SQLException {
    	overhaul.create(id, changeDiscription, changeFunctions, changingParts, date);
    }

    @Override
    public void updateOverhaul(Integer id, String changeDiscription, String changeFunctions, String changingParts, Date date) throws SQLException {
    	overhaul.update(id, changeDiscription, changeFunctions, changingParts, date);
    }

    @Override
    public void deleteOverhaul(Integer id) throws SQLException {
    	overhaul.delete(id);
    }

    @Override
    public void findAllAddress() throws SQLException {
        address.findAll();
    }

    @Override
    public void findAddressById(Integer id) throws SQLException {
        address.findById(id);
    }

    @Override
    public void createAddress(Integer id, String street, Integer number, String city, String country) throws SQLException {
        address.create(id, street, number, city, country);
    }

    @Override
    public void updateAddress(Integer id, String street, Integer number, String city, String country) throws SQLException {
        address.update(id, street, number, city, country);
    }

    @Override
    public void deleteAddress(Integer name) throws SQLException {
        address.delete(name);
    }

    @Override
    public void findAllInformation() throws SQLException {
    	information.findAll();
    }

    @Override
    public void findInformationById(Integer id) throws SQLException {
    	information.findById(id);
    }

    @Override
    public void createInformation(Integer id, Integer number, String details, Date date, Double gpsCoordinates) throws SQLException {
    	information.create(id, number, details, date, gpsCoordinates);
    }

    @Override
    public void updateInformation(Integer id, Integer number, String details, Date date, Double gpsCoordinates) throws SQLException {
    	information.update(id, number, details, date, gpsCoordinates);
    }

    @Override
    public void deleteInformation(Integer id) throws SQLException {
    	information.delete(id);
    }

    @Override
    public void findAllCollectinCah() throws SQLException {
    	collectinCah.findAll();
    }

    @Override
    public void findCollectinCahById(Integer name) throws SQLException {
    	collectinCah.findById(name);
    }

    @Override
    public void createCollectinCah(Integer id, Double number, Date date, Time time) throws SQLException {
    	collectinCah.create(id, number, date, time);
    }

    @Override
    public void updateCollectinCah(Integer id, Double number, Date date, Time time) throws SQLException {
    	collectinCah.update(id, number, date, time);
    }

    @Override
    public void deleteCollectinCah(Integer name) throws SQLException {
    	collectinCah.delete(name);
    }
}