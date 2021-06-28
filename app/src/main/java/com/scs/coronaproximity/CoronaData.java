package com.scs.coronaproximity;

import com.google.gson.Gson;

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
public class CoronaData{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
