package wservice;

import java.util.List;
import java.util.ArrayList;
import model.*;
import com.google.gson.*;
import java.util.HashMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import utils.Fail;
import utils.Message;
import utils.Success;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
@CrossOrigin
public class UsersEnchereService {
//creer son propres en Encheres

    @PostMapping("/users/{id}/encheres")
    String Create(@RequestParam double prixMin,
            @PathVariable int id, @RequestParam int categorieId,
            @RequestParam String descriProduit, @RequestParam double durer) throws Exception {
        Gson gson = new Gson();
        String texte = "";// gson.toJson(new Message(new Success(idKilo, "Success")));

        try {
            Enchere enchere = new Enchere();
            enchere.setCategorieId(categorieId);
//            enchere.setDateDebut(dateDebut);
            enchere.setPrixMin(prixMin);
            enchere.setUsersId(id);
            enchere.setDescriProduit(descriProduit);
            enchere.setDurer(durer);
            enchere.insert(null);
            texte = gson.toJson(new Message(new Success(enchere.getLastID(), "Success")));
        } catch (Exception ex) {
            texte = gson.toJson(new Message(new Fail("500", ex.getMessage())));
            throw ex;
        }
        return texte;
    }

    //update un encheres adjuger
    @PutMapping("/users/{id}/encheres/{idc}/ajd")
    String updateAdj(@RequestParam double prixMin,
            @PathVariable int idc,
            @PathVariable int id) throws Exception {
        Gson gson = new Gson();
        String texte = "";// gson.toJson(new Message(new Success(idKilo, "Success")));

        try {
            Enchere enchere = new Enchere();
//            enchere.setCategorieId(categorieId);
//            enchere.setDateDebut(dateDebut);
//            enchere.setPrixMin(prixMin);
            enchere.setUsersId(id);
//            enchere.setDescriProduit(descriProduit);
//            enchere.setDurer(durer);
            enchere.setId(idc);
            enchere.setUsersId(id);
            enchere.setState(1);

            enchere.update("id", null);
            texte = gson.toJson(new Message(new Success(id, "Update Ok!!")));
        } catch (Exception ex) {
            texte = gson.toJson(new Message(new Fail("500", ex.getMessage())));
            throw ex;
        }
        return texte;
    }
// update d'un enchere

    @PutMapping("/users/{id}/encheres/{idc}")
    String update(@RequestParam double prixMin,
            @PathVariable int idc,
            @PathVariable int id, @RequestParam int categorieId,
            @RequestParam String descriProduit, @RequestParam double durer) throws Exception {
        Gson gson = new Gson();
        String texte = "";// gson.toJson(new Message(new Success(idKilo, "Success")));

        try {
            Enchere enchere = new Enchere();
            enchere.setCategorieId(categorieId);
//            enchere.setDateDebut(dateDebut);
            enchere.setPrixMin(prixMin);
            enchere.setUsersId(id);
            enchere.setDescriProduit(descriProduit);
            enchere.setDurer(durer);
            enchere.setId(id);
            enchere.update("id", null);
            texte = gson.toJson(new Message(new Success(id, "Update Ok!!")));
        } catch (Exception ex) {
            texte = gson.toJson(new Message(new Fail("500", ex.getMessage())));
            throw ex;
        }
        return texte;
    }

    //  get tous les encheresz
    @GetMapping("/users/{id}/encheres")
    String getOne(@PathVariable int id) throws Exception {
        Enchere am = new Enchere();
        am.setUsersId(id);
        Gson gson = new Gson();
//        String texte = gson.toJson(am.select(null));
//        return texte;
         HashMap _val_ = new HashMap<String, Object>();
        _val_.put("data", am.select(null));
        return gson.toJson(_val_);
    }

    @GetMapping("/users/{id}/encheres/{idc}")
    String getOneEnc(@PathVariable int id, @PathVariable int idc) throws Exception {
        Enchere am = new Enchere();
        am.setUsersId(id);
        am.setId(idc);
        Gson gson = new Gson();
          HashMap _val_ = new HashMap<String, Object>();
        _val_.put("data", am.select(null));
        return gson.toJson(_val_);
    }
}
