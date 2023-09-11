package com.stock.stock.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.stock.stock.entities.Setting;
import com.stock.stock.repositories.SettingRepository;
import com.stock.stock.services.Contracts.SettingService;


@Service
@Repository("mysqlsetting")
public class SettingManager implements SettingService{

    private final SettingRepository settingRepository;

    public SettingManager(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }

    @Override
    public List<Setting> getAllSettings() {
        return settingRepository.findAll();
        
    }

    @Override
    public Setting createOneSetting (Setting setting) {
        return settingRepository.save(setting);
    }

    @Override
    public Setting updateSetting(int id, Setting newSettingData) {
        // Önce veritabanında güncellenecek Setting nesnesini bulun
        Setting existingSetting = settingRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Setting not found with id: " + id));

        // Yeni verileri kullanarak varolan Setting nesnesini güncelleyin
        existingSetting.setSettingDanger(newSettingData.getSettingDanger());

        // Güncellenmiş Setting nesnesini veritabanına kaydedin
        return settingRepository.save(existingSetting);
    }


    @Override
    public void deleteOneSetting(int id) {
        settingRepository.deleteById(id);
        
    }
    
}
