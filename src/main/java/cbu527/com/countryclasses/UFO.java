package cbu527.com.countryclasses;

import java.util.List;

public class UFO {

    private String dateTime;
    private String city;
    private String state;
    private String country;

    public UFO(List<String> s){
        dateTime = s.get(0);
        city = s.get(1);
        state = s.get(2);
        country = s.get(3);
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        if(state.equals(""))
            this.state = "State is not Defined";
        else
            this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getState() {
        return state;
    }
}