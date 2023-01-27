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
public class EnchereMoveCoteUtilisateur {
//creer son propres en Encheres

    @PostMapping("encheres/{id}/enchereMoves")
    String Create(@RequestParam double prixMise,
            @PathVariable int id, @RequestParam int usersId) throws Exception {
        Gson gson = new Gson();
        String texte = "";// gson.toJson(new Message(new Success(idKilo, "Success")));

        try {
            EnchereMove move=new EnchereMove();
            move.setEnchereId(id);
            move.setPrixMise(prixMise);
            move.setUsersId(usersId);
            move.insert(null);
            texte = gson.toJson(new Message(new Success(((EnchereMove)move.getLastObject()).getId(), "Success")));
        } catch (Exception ex) {
            texte = gson.toJson(new Message(new Fail("500", ex.getMessage())));
//            throw ex;
        }
        return texte;
    }

        //  get tous les encheresz
    @GetMapping("encheres/{id}/enchereMoves/{idm}")
    String gethOne(@PathVariable int id,@PathVariable int idm) throws Exception {
        EnchereMove am = new EnchereMove();
        am.setId(idm);
        am.setEnchereId(id);
        Gson gson = new Gson();
         HashMap _val_ = new HashMap<String, Object>();
       ArrayList<EnchereMove> all = new ArrayList<>();
            ArrayList<EnchereMove> alls =am.select(null);
            for (int i = 0; i < alls.size(); i++) {
                EnchereMove get = alls.get(i);
                Users vo = new Users();
                Enchere enchere=new Enchere();
                enchere.setId(get.getEnchereId());
                vo.setId(get.getUsersId());
                get.setUser(vo.getUsers());
                get.setEnchere(enchere.getEnchere());
                all.add(get);
            }
       _val_.put("data",all);
        return gson.toJson(_val_);
//        String texte = gson.toJson();
//        return t;
    }

//    @GetMapping("/users/{id}/encheres/{idc}")
//    String getOneEnc(@PathVariable int id, @PathVariable int idc) throws Exception {
//        Enchere am = new Enchere();
//        am.setUsersId(id);
//        am.setId(idc);
//        Gson gson = new Gson();
//        String texte = gson.toJson(am.select(null));
//        return texte;
//    }
}
