package com.funkymonk.stradew_valley_crop_api;

public class CropNotFoundException extends RuntimeException {
    CropNotFoundException(Long id) {
        super("Could not find crop " + id);
    }
}
