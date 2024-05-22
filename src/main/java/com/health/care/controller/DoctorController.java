package com.health.care.controller;


import com.health.care.dto.DoctorDto;
import com.health.care.models.ApiError;
import com.health.care.models.ApiResponse;
import com.health.care.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @PostMapping
    public ApiResponse<Object> save(@RequestBody DoctorDto body) {
        try {
            var d = doctorService.save(body);
            if (d == null) {
                return new ApiResponse<Object>(202, new ApiError("error", "Unable to save the doctor at the moment. Try again later"));
            }
            return new ApiResponse<Object>(200, d);
        } catch (Exception e) {
            return new ApiResponse<Object>(202, new ApiError("error", "Unable to save the doctor at the moment. Try again later", e.toString()));
        }
    }

    @PutMapping
    public ApiResponse<Object> update(@RequestBody DoctorDto body) {
        try {
            var d = doctorService.update(body);
            if (d == null) {
                return new ApiResponse<Object>(202, new ApiError("error", "Unable to update the doctor details"));
            }
            return new ApiResponse<Object>(200, d);
        } catch (Exception e) {
            return new ApiResponse<Object>(202, new ApiError("error", "Unable to update the doctor details", e.toString()));
        }
    }

    @GetMapping("{id}")
    public ApiResponse<Object> get(@PathVariable long id) {
        try {
            var d = doctorService.get(id);
            if (d == null) {
                return new ApiResponse<Object>(202, new ApiError("no-results", "No Doctors found."));
            }
            return new ApiResponse<Object>(200, d);
        } catch (Exception e) {
            return new ApiResponse<Object>(202, new ApiError("no-results", "No Doctors found.", e.toString()));
        }
    }

    @GetMapping()
    public ApiResponse<Object> getAll() {
        try {
            var d = doctorService.getAll();

            if (d.isEmpty()) {
                return new ApiResponse<Object>(202, new ApiError("no-results", "No Doctors found."));
            }
            return new ApiResponse<Object>(200, d);
        } catch (Exception e) {
            return new ApiResponse<Object>(202, new ApiError("no-results", "No Doctors found.", e.toString()));
        }
    }

    @DeleteMapping("{id}")
    public ApiResponse<Object> delete(@PathVariable long id) {
        try {
            doctorService.delete(id);
            return new ApiResponse<Object>(200, "Success");
        } catch (Exception e) {
            return new ApiResponse<Object>(202, new ApiError("error", "Unable to delete the doctor", e.toString()));
        }
    }
}
