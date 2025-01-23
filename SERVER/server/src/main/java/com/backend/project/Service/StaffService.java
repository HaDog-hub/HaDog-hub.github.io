package com.backend.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.project.Dao.StaffRepository;
import com.backend.project.model.Staff;

import java.util.Optional;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;

    /*-----for login-----*/

    public Staff authenticate(String username, String password) {
        Optional<Staff> optionalStaff = staffRepository.findByUsername(username);

        return optionalStaff.filter(staff -> staff.getPassword().equals(password))
                            .orElse(null);
    }

    public Staff forgotPasswordAuthenticate(String username, String email) {
        Optional<Staff> optionalStaff = staffRepository.findByUsername(username);

        return optionalStaff.filter(staff -> staff.getEmail().equals(email))
                            .orElse(null);
    }

    public String changePassword(String username, String newPassword) {
        Optional<Staff> optionalStaff = staffRepository.findByUsername(username);

        if (optionalStaff.isPresent()) {
            Staff staff = optionalStaff.get();
            staff.setPassword(newPassword);
            staffRepository.save(staff);
            return "Change Password successfully";
        } else {
            return "User not found";
        }
    }

    /*-----for system-----*/

    public Staff getUser(String username){
        return staffRepository.findByUsername(username).orElseThrow();
    }
}
