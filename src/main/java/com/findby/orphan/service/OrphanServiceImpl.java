package com.findby.orphan.service;

import com.findby.orphan.Orphan;
import com.findby.orphan.service.dtos.OrphanUpdate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrphanServiceImpl implements OrphanService {

    @Override
    @Transactional
    public Orphan update(Orphan orphan, OrphanUpdate update) {
        return orphan.update(
                update.getName(),
                update.getAge(),
                update.getLatitude(),
                update.getLongitude(),
                update.getGender(),
                update.getLook(),
                update.getCountryCode(),
                update.getCountryName()
        );
    }
}
