package com.funkymonk.stradew_valley_crop_api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
 class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CropsRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Crops("Garlic", "Spring", 4, 60)));
            log.info("Preloading " + repository.save(new Crops("Kale", "Spring", 6, 110)));
            /*log.info("Preloading " + repository.save(new Crops("Parsnip", "Spring", 4, 35)));
            log.info("Preloading " + repository.save(new Crops("Potato", "Spring", 6, 80)));
            log.info("Preloading " + repository.save(new Crops("Rhubarb", "Spring", 13, 220)));
            log.info("Preloading " + repository.save(new Crops("Tulip", "Spring", 6, 30)));
            log.info("Preloading " + repository.save(new Crops("Unmilled Rice (Irrigated)", "Spring", 6, 30)));
            log.info("Preloading " + repository.save(new Crops("Unmilled Rice (Unirrigated)", "Spring", 8, 30)));
            log.info("Preloading " + repository.save(new Crops("Carrot", "Spring", 3, 35)));

             */

        };
    }

}
