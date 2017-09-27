
import model.Form103Model;
import services.Form103XlsService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
      Form103Model form103Model = new Form103Model();
        Form103XlsService form103XlsService = new Form103XlsService();
      form103XlsService.generateForm103XlsFile(form103Model.getSheet());

        form103XlsService.uploadFile();
    }
}

