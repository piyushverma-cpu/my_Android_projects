package com.example.covidtracker;

public class CountryModel {
    private String flag,countryName,cases,deaths,active,recovered,todayCases,todayDeaths,critical;
    public CountryModel()
    {

    }

    public CountryModel(String flag, String countryName, String cases, String deaths, String active, String recovered, String todayCases, String todayDeaths, String critical) {
        this.flag = flag;
        this.countryName = countryName;
        this.cases = cases;
        this.deaths = deaths;
        this.active = active;
        this.recovered = recovered;
        this.todayCases = todayCases;
        this.todayDeaths = todayDeaths;
        this.critical = critical;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }
}
