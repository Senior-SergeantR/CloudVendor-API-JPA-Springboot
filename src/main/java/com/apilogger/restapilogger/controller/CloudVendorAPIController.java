package com.apilogger.restapilogger.controller;

import com.apilogger.restapilogger.model.CloudVendor;
import com.apilogger.restapilogger.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIController {
    CloudVendorService cloudVendorService;

    public CloudVendorAPIController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    //Reading Specific CloudVendor
    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {

        return cloudVendorService.getCloudVendor(vendorId);

    }
    //Reading all cloudVendors available in the database
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails() {

        return cloudVendorService.getAllCloudVendors();

    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
       cloudVendorService.createCloudVendor(cloudVendor);
        return "cloud vendor created successfully";
    }
    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "cloud vendor updated successfully";
    }
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "cloud vendorId "+vendorId+" deleted successfully";
    }
}