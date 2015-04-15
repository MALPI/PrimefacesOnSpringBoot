package de.coderebell.pfosb.ui;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MALPI on 15.04.2015.
 */
@Component(value = "karte")
@Scope(value = "session")
public class KartenComponent {


    private String label = "bar";

    public void onPointSelect() {
      if(label.equals("bar")){
          label = "foo";
      } else {
          label = "bar";
      }

    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
