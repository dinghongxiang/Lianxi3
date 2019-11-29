package com.bawei.lianxi3;

import java.util.ArrayList;

public class Bean {

    public int error;
    public String status;
    public ArrayList<Mu> results;

    public class Mu{
        public String country;
        ArrayList<Mu1> index;

        public class Mu1{
            public String city;
            public String zs;
            public String tipt;
            public String des;
        }
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Mu> getResults() {
        return results;
    }

    public void setResults(ArrayList<Mu> results) {
        this.results = results;
    }

}
