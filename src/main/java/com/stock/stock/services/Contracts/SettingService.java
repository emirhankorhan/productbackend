package com.stock.stock.services.Contracts;

import java.util.List;

import com.stock.stock.entities.Setting;

public interface SettingService {
    List<Setting> getAllSettings();
    Setting createOneSetting(Setting setting);
    Setting updateSetting(int id, Setting newSetting);
    void deleteOneSetting(int id);
}