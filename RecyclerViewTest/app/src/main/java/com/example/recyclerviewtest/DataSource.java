package com.example.recyclerviewtest;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private static List<Country> countryList;

    private DataSource() {

    }

    public static List<Country> getCountryList(Context context) {
        /*if (countryList == null) {
            countryList = new ArrayList<>();
            countryList.add(new Country("Austria", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-austria.jpg"));
            countryList.add(new Country("Belgium", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-belgium.jpg"));
            countryList.add(new Country("Bulgaria", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-bulgaria.jpg"));
            countryList.add(new Country("Croatia", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-croatia.jpg"));
            countryList.add(new Country("Cyprus", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-cyprus.jpg"));
            countryList.add(new Country("Czechia", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-czech-republic.jpg"));
            countryList.add(new Country("Denmark", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-denmark.jpg"));
            countryList.add(new Country("Estonia", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-estonia.jpg"));
            countryList.add(new Country("Finland", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-finland.jpg"));
            countryList.add(new Country("France", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-france.jpg"));
            countryList.add(new Country("Germany", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-germany.jpg"));
            countryList.add(new Country("Greece", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-greece.jpg"));
            countryList.add(new Country("Hungary", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-hungary.jpg"));
            countryList.add(new Country("Ireland", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-ireland.jpg"));
            countryList.add(new Country("Italy", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-italy.jpg"));
            countryList.add(new Country("Latvia", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-latvian.jpg"));
            countryList.add(new Country("Lithuania", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-lithuania.jpg"));
            countryList.add(new Country("Luxembourg", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-luxembourg.jpg"));
            countryList.add(new Country("Malta", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-malta.jpg"));
            countryList.add(new Country("Netherlands", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-netherlands.jpg"));
            countryList.add(new Country("Poland", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-poland.jpg"));
            countryList.add(new Country("Portugal", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-portugal.jpg"));
            countryList.add(new Country("Romania", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-romania.jpg"));
            countryList.add(new Country("Slovakia", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-slovakia.jpg"));
            countryList.add(new Country("Slovenia", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-slovenia.jpg"));
            countryList.add(new Country("Spain", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-spain.jpg"));
            countryList.add(new Country("Sweden", "https://europa.eu/european-union/sites/europaeu/files/country_images/flags/flag-sweden.jpg"));

        return countryList;
         */
        return AppDataBase.getInstance(context).getCountryDao().getAll();
    }

    public static Country getCountry(Context context, long id) {
        //return getCountryList().get(position);
        return AppDataBase.getInstance(context).getCountryDao().getById(id);
    }
}
