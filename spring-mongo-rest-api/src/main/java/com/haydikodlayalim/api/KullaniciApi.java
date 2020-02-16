package com.haydikodlayalim.api;

import com.haydikodlayalim.entity.Kullanici;
import com.haydikodlayalim.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/kullanici")
public class KullaniciApi {
    @Autowired
    private KullaniciRepository kullaniciRepository;

    @PostConstruct
    public void init(){
        Kullanici kulllanici = new Kullanici();
        kulllanici.setAdi("Haydi");
        kulllanici.setSoyadi("Kodlayalim");
        HashMap hashMap = new HashMap();
        hashMap.put("gozRengi","siyah");
        hashMap.put("boyu","1,62");
        hashMap.put("yaşı","23");
        kulllanici.setOzellikleri(hashMap);
        kullaniciRepository.save(kulllanici);
    }

    @PostMapping
    public ResponseEntity<Kullanici> ekle(@RequestBody Kullanici kullanici) {
        return ResponseEntity.ok(kullaniciRepository.save(kullanici));
    }

    @GetMapping
    public ResponseEntity<List<Kullanici>> tumunuListele(Kullanici kullanici) {
        return ResponseEntity.ok(kullaniciRepository.findAll());
    }
}
