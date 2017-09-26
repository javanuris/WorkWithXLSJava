package entities;

import java.util.List;

public class Form103XlsSheet {

    private Form103XlsCellHeaderDescription form103XlsCellHeaderDescription;
    private List<Form103XlsCellBodyDescription> form103XlsCellBodyDescription;

    public Form103XlsSheet(){

    }

    public Form103XlsCellHeaderDescription getForm103XlsCellHeaderDescription() {
        return form103XlsCellHeaderDescription;
    }

    public void setForm103XlsCellHeaderDescription(Form103XlsCellHeaderDescription form103XlsCellHeaderDescription) {
        this.form103XlsCellHeaderDescription = form103XlsCellHeaderDescription;
    }

    public List<Form103XlsCellBodyDescription> getForm103XlsCellBodyDescription() {
        return form103XlsCellBodyDescription;
    }

    public void setForm103XlsCellBodyDescription(List<Form103XlsCellBodyDescription> form103XlsCellBodyDescription) {
        this.form103XlsCellBodyDescription = form103XlsCellBodyDescription;
    }


}
