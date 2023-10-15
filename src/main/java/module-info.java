module javafx11.multipantalla {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires org.apache.logging.log4j;
    requires jakarta.inject;
    requires jakarta.cdi;
    requires io.vavr;
    requires retrofit2;
    requires retrofit2.converter.gson;
    requires okhttp3;
    requires com.squareup.moshi;
    requires retrofit2.converter.moshi;
    exports servicios.impl;
    exports dao.retrofit;
    exports ui.main to javafx.graphics;
    exports ui.pantallas.principal;
    exports dao;
    opens dao.impl;
    opens ui.pantallas.principal;
    opens ui.main;
    opens css;
    opens fxml;
    exports modelo;
    exports common;
    opens modelo;


}
