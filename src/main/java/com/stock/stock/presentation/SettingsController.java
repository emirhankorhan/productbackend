package com.stock.stock.presentation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.stock.stock.entities.Setting;
import com.stock.stock.services.Contracts.SettingService;

@RestController
@RequestMapping("/api/settings")
@CrossOrigin
public class SettingsController {
    private final SettingService settingService;

    public SettingsController(@Qualifier("mysqlsetting") SettingService settingService) {
        this.settingService = settingService;
    }

    @GetMapping
    public ResponseEntity<?> getAllSettings() {
        var settings = settingService.getAllSettings();
        return new ResponseEntity<>(settings, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createOneSetting(@RequestBody Setting setting) {
        settingService.createOneSetting(setting);
        return new ResponseEntity<>(setting, HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> updateOneSetting(@PathVariable(name = "id", required = true) int id,
            @RequestBody Setting setting) {
        settingService.updateSetting(id, setting);
        return ResponseEntity.ok()
                .header("location", "http://localhost:8082/api/settings/" + setting.getId())
                .body(setting);
    }

    // @PutMapping(path = "{id}") // Yeni güncelleme metodu
    // public ResponseEntity<Setting> updateOneSetting(
    //         @PathVariable(name = "id") int id,
    //         @RequestBody Setting newSetting) {
    //     Setting updatedSetting = settingService.updateSetting(id, newSetting);
    //     return new ResponseEntity<>(updatedSetting, HttpStatus.OK);
    // }

    @DeleteMapping(path = "{id}")
    @ResponseBody
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteOneSetting(@PathVariable(name = "id", required = true) int id) {
        settingService.deleteOneSetting(id);
        return ResponseEntity.noContent().build();
    }

}