package com.scs.coronaproximity.api;

import com.google.gson.annotations.SerializedName;

/*{
  "data": {
    "02000": {
      "ags": "02000",
      "name": "Hamburg",
      "county": "SK Hamburg",
      "population": 1847253,
      "cases": 37535,
      "deaths": 661,
      "casesPerWeek": 2027,
      "deathsPerWeek": 2,
      "recovered": 27864,
      "weekIncidence": 109.73050253538634,
      "casesPer100k": 2031.9360693960166,
      "delta": {
        "cases": 0,
        "deaths": 0,
        "recovered": 350
      }
    }
  },
  "meta": {
    "source": "Robert Koch-Institut",
    "contact": "Marlon Lueckert (m.lueckert@me.com)",
    "info": "https://github.com/marlon360/rki-covid-api",
    "lastUpdate": "2021-01-04T00:00:00.000Z",
    "lastCheckedForUpdate": "2021-01-04T13:59:49.832Z"
  }
}*/
public class CoronaData {
    @SerializedName("name")
    public String name;
    @SerializedName("ags")
    private String ags;
    @SerializedName("county")
    private String county;
    @SerializedName("population")
    private String population;
    @SerializedName("cases")
    private String cases;
    @SerializedName("deaths")
    private String deaths;
    @SerializedName("casesPerWeek")
    private String casesPerWeek;
    @SerializedName("deathsPerWeek")
    private String deathsPerWeek;
    @SerializedName("recovered")
    private String recovered;
    @SerializedName("weekIncidence")
    private String weekIncidence;
    @SerializedName("casesPer100k")
    private String casesPer100k;

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

    /*public class Delta {

        @SerializedName("cases")
        private String cases;
        @SerializedName("deaths")
        private String deaths;
        @SerializedName("recovered")
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
    }*/


}
