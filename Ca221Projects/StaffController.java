package com.example.Ca221Projects;
@RestController
public class StaffController {
    package Group4.demo;

 org.springframework.http.*;
 org.springframework.web.bind.annotation.*;

java.util.List;

    @RestController
    @RequestMapping("/staffs")
    public class StaffController {

        private final StaffService staffService;

        public StaffController(StaffService staffService) {
            this.staffService = staffService;
        }

        @GetMapping
        public List<Staff> getAllStaffs() {
            return staffService.getAllStaffs();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Staff> getStaff(@PathVariable Long id) {
            return staffService.getStaffById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
            Staff created = staffService.createStaff(staff);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
            return staffService.updateStaff(id, staff)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteStaff(@PathVariable Long id) {
            if (staffService.deleteStaff(id)) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        }
    }
}
