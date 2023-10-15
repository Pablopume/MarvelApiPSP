package ui.main;

import common.Constantes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;


public class Producers {


    @Produces
    @Named(Constantes.URLNAMED)
    public String getUrl() {
        return Constantes.JJJ;
    }

    @Produces
    @Named(Constantes.CONFIG_DB)
    public String getDB() {
        return Constantes.JJJ;
    }


}
