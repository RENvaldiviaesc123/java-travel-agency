package org.java.lessons.travel;

import java.time.LocalDate;
import java.time.Period;

public class Vacanza {
    //ATTRIBUTI
        //Gli attributi sono: Destinazione, Data Partenza e Data Fine.
        private String destination;
        private LocalDate departureDate;
        private LocalDate endDate;


    //COSTRUTTORI

    public Vacanza(String destination, LocalDate departureDate, LocalDate endDate) throws RuntimeException{
        //Controllo per destination
        if (destination == null || destination.isEmpty()) {
           throw new RuntimeException("The destination must not be null or empty!");
        }
        //Controllo per departureDate
        if (departureDate == null || departureDate.isBefore(LocalDate.now())) {
            throw new RuntimeException("The departure date must not be null or in the past!");
        }
        //Controllo per endDate
        if (endDate == null || endDate.isAfter(departureDate)) {
            throw new RuntimeException("The end date must not be null or before the departure date!");
        }

        this.destination = destination;
        this.departureDate = departureDate;
        this.endDate = endDate;
    }


    //GETTER and SETTER

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) throws RuntimeException {
        if (destination == null || destination.isEmpty()) {
            throw new RuntimeException("The destination must not be null or empty!");
        }
        this.destination = destination;
    }


    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        if (departureDate == null || departureDate.isBefore(LocalDate.now())) {
            throw new RuntimeException("The departure date must not be null or in the past!");
        }
        this.departureDate = departureDate;
    }
    public void setDepartureDate(String andataString)
            throws IllegalArgumentException, RuntimeException {
        LocalDate andataInput = null;
        try {andataInput = LocalDate.parse(andataString); }
        catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format!");
        }
        if (departureDate.isBefore(LocalDate.now())) {
            throw new RuntimeException("La data di partenza deve essere dopo la data odierna!");
        }
        this.departureDate = andataInput;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        if (endDate == null || endDate.isAfter(departureDate)) {
            throw new RuntimeException("The end date must not be null or before the departure date!");
        }
        this.endDate = endDate;
    }
    public void setEndDate(String ritornoString)
        throws IllegalArgumentException, RuntimeException {
        LocalDate ritornoInput = null;
        try {ritornoInput = LocalDate.parse(ritornoString); }
        catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format!");
        }
        if (endDate.isBefore(departureDate)) {
            throw new RuntimeException("La data di ritorno deve essere dopo la data di partenza!");
        }
        this.endDate = ritornoInput;
    }






    //METODI
        //metodo per calcolare la quantità di giorni della vacanza
        public int holidays (){
            Period vacations = Period.between(departureDate, endDate);
            return vacations.getYears();
        }

    @Override
    public String toString() {
        return "Vacanza{" +
                "destination='" + destination + '\'' +
                ", departureDate=" + departureDate +
                ", endDate=" + endDate +
                '}';
    }
}
