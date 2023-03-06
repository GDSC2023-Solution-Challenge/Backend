package com.findby.orphan.service;

import com.findby.orphan.Orphan;
import com.findby.orphan.service.dtos.OrphanUpdate;

public interface OrphanService {
    Orphan update(Orphan orphan, OrphanUpdate update);
}
