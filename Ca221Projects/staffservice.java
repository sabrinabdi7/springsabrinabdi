package com.example.Ca221Projects;

public class staffservice {
    package Group4.demo;

 org.springframework.stereotype.Service;
 java.util.

    @Service
    public class StaffService {
        private final Map<Long, Staff> staffMap = new HashMap<>();
        private long idCounter = 1;

        public Staff createStaff(Staff staff) {
            staff.setId(idCounter++);
            staffMap.put(staff.getId(), staff);
            return staff;
        }

        public List<Staff> getAllStaffs() {
            return new ArrayList<>(staffMap.values());
        }

        public Optional<Staff> getStaffById(Long id) {
            return Optional.ofNullable(staffMap.get(id));
        }

        public Optional<Staff> updateStaff(Long id, Staff updatedStaff) {
            if (staffMap.containsKey(id)) {
                updatedStaff.setId(id);
                staffMap.put(id, updatedStaff);
                return Optional.of(updatedStaff);
            }
            return Optional.empty();
        }

        public boolean deleteStaff(Long id) {
            return staffMap.remove(id) != null;
        }
    }
}
