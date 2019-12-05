package ua.lviv.iot.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

public interface IController {
    void findByTerminalId(Integer id) throws SQLException;
    void createTerminal(Integer id,  String logo, String function)
            throws SQLException;
    void updateTerminal(Integer id,  String logo, String function)
            throws SQLException;
    void deleteTerminal(Integer id) throws SQLException;
    void findAllTerminals() throws SQLException;

    void deleteStandart(Integer id) throws SQLException;
    void findStandartById(Integer id) throws SQLException;
    void createStandart(Integer id, Double pay, Date date) throws SQLException;
    void updateStandart(Integer id, Double pay, Date date)
            throws SQLException;
    void findAllStandart() throws SQLException;

    void findAllServiceWork() throws SQLException;
    void findByIdServiceWork(Integer id) throws SQLException;
    void createServiceWork(Integer id, String master, Double priceOfMaster, Double servicePrice, Time time)
            throws SQLException;
    void updateServiceWork(Integer id, String master, Double priceOfMaster, Double servicePrice, Time time)
            throws SQLException;
    void deleteServiceWork(Integer id) throws SQLException;

    void findAllServiceWizard() throws SQLException;
    void findByIdServiceWizard(Integer id) throws SQLException;
    void createServiceWizard(Integer id, String firstName, String secondName)
            throws SQLException;
    void updateServiceWizard(Integer id, String firstName, String secondName)
            throws SQLException;
    void deleteServiceWizard(Integer id) throws SQLException;

    void findAllServicedCompany() throws SQLException;
    void findServicedCompanyById(Integer id) throws SQLException;
    void createServicedCompany(Integer id, String name, String email, Integer staff)
            throws SQLException;
    void updateServicedCompany(Integer id, String name, String email, Integer staff)
            throws SQLException;
    void deleteServicedCompany(Integer id) throws SQLException;

    void findAllProvidedServices() throws SQLException;
    void findProvidedServicesById(Integer id) throws SQLException;
    void createProvidedServices(Integer id, String type)
            throws SQLException;
    void updateProvidedServices(Integer id, String type)
            throws SQLException;
    void deleteProvidedServices(Integer id) throws SQLException;

    void findAllOverhaul() throws SQLException;
    void findOverhaul(Integer id) throws SQLException;
    void createOverhaul(Integer id, String changeDiscription, String changeFunctions, String changingParts, Date date) throws SQLException;
    void updateOverhaul(Integer id, String changeDiscription, String changeFunctions, String changingParts, Date date) throws SQLException;
    void deleteOverhaul(Integer id) throws SQLException;

    void findAllAddress() throws SQLException;
    void findAddressById(Integer id) throws SQLException;
    void createAddress(Integer id, String street, Integer number, String city, String country) throws SQLException;
    void updateAddress(Integer id, String street, Integer number, String city, String country) throws SQLException;
    void deleteAddress(Integer id) throws SQLException;

    void findAllInformation() throws SQLException;
    void findInformationById(Integer id) throws SQLException;
    void createInformation(Integer id, Integer number, String details, Date date, Double gpsCoordinates) throws SQLException;
    void updateInformation(Integer id, Integer number, String details, Date date, Double gpsCoordinates) throws SQLException;
    void deleteInformation(Integer id) throws SQLException;

    void findAllCollectinCah() throws SQLException;
    void findCollectinCahById(Integer id) throws SQLException;
    void createCollectinCah(Integer id, Double number, Date date, Time time) throws SQLException;
    void updateCollectinCah(Integer id, Double number, Date date, Time time) throws SQLException;
    void deleteCollectinCah(Integer id) throws SQLException;
}