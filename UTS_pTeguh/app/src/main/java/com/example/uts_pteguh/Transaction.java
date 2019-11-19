package com.example.uts_pteguh;

public class Transaction {
    String date, description, option;
    int nominal;

    public Transaction(String date, String description, String option, int nominal) {
        this.date = date;
        this.description = description;
        this.option = option;
        this.nominal = nominal;
    }

    public Transaction() {

    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getOption() {

        return option;
    }

    public void setOption(String option) {

        this.option = option;
    }

    public int getNominal() {

        return nominal;
    }

    public void setNominal(int nominal) {

        this.nominal = nominal;
    }
}
