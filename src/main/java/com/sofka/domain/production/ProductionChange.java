package com.sofka.domain.production;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.domain.production.events.ProductionCreated;


public class ProductionChange extends EventChange {
    public ProductionChange(Production production){
        apply((ProductionCreated event) ->{
            production.songId = event.getSongId();
        });



    }


}
