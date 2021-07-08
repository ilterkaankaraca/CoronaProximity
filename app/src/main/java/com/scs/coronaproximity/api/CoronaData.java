package com.scs.coronaproximity.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
// response json deserialized to instances of this class
public class CoronaData {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("ags")
    @Expose
    private String ags;
    @SerializedName("county")
    @Expose
    private String county;
    @SerializedName("population")
    @Expose
    private String population;
    @SerializedName("cases")
    @Expose
    private String cases;
    @SerializedName("deaths")
    @Expose
    private String deaths;
    @SerializedName("casesPerWeek")
    @Expose
    private String casesPerWeek;
    @SerializedName("deathsPerWeek")
    @Expose
    private String deathsPerWeek;
    @SerializedName("recovered")
    @Expose
    private String recovered;
    @SerializedName("weekIncidence")
    @Expose
    private String weekIncidence;
    @SerializedName("casesPer100k")
    @Expose
    private String casesPer100k;
    @SerializedName("stateAbbreviation")
    @Expose
    private String stateAbbreviation;

    private Delta delta;

    public Delta getDelta() {
        return delta;
    }

    public void setDelta(Delta delta) {
        this.delta = delta;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgs() {
        return ags;
    }

    public void setAgs(String ags) {
        this.ags = ags;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
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

    public String getCasesPerWeek() {
        return casesPerWeek;
    }

    public void setCasesPerWeek(String casesPerWeek) {
        this.casesPerWeek = casesPerWeek;
    }

    public String getDeathsPerWeek() {
        return deathsPerWeek;
    }

    public void setDeathsPerWeek(String deathsPerWeek) {
        this.deathsPerWeek = deathsPerWeek;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getWeekIncidence() {
        return weekIncidence;
    }

    public void setWeekIncidence(String weekIncidence) {
        this.weekIncidence = weekIncidence;
    }

    public String getCasesPer100k() {
        return casesPer100k;
    }

    public void setCasesPer100k(String casesPer100k) {
        this.casesPer100k = casesPer100k;
    }

    public class Delta {

        @SerializedName("cases")
        @Expose
        private String cases;
        @SerializedName("deaths")
        @Expose
        private String deaths;
        @SerializedName("recovered")
        @Expose
        private String recovered;

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

        public String getRecovered() {
            return recovered;
        }

        public void setRecovered(String recovered) {
            this.recovered = recovered;
        }
    }

}
