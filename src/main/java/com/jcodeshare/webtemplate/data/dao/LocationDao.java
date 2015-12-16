package com.jcodeshare.webtemplate.data.dao;

import java.util.List;

import com.jcodeshare.webtemplate.data.model.Location;

public interface LocationDao {

    void saveLocation(Location location);

    List<Location> findAllLocation();

    void deleteLocationById(int id);

    Location findById(int id);
    
    void updateLocation(Location location);
    
    void deleteLocation(Location location);

}
