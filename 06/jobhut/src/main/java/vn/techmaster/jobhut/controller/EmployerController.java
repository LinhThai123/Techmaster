package vn.techmaster.jobhut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.jobhut.model.Employer;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/employer")
class EmployeeController {
    private ConcurrentHashMap<String , Employer> employers ;

    public EmployeeController() {
        employers = new ConcurrentHashMap<>() ;
        employers.put("LTW-01" , new Employer("01", "Lập trình web" , "https://www.vietnamworks.com/" , "Vietnamwork@gmail.com" , "Nghệ An")) ;
        employers.put("LMB-02" , new Employer("02", "Lập trình mobile" , "https://topdev.vn/" , "Topdev@gmail.com" , "Hà Nội ")) ;
        employers.put("LUD-03" , new Employer("03", "Lập ứng dụng" , "https://www.topcv.vn/viec-lam" , "Topcv@gmail.com" , "Hồ Chí Minh")) ;
        employers.put("LBE-04" , new Employer("04", "Back End" , "https://itviec.com/viec-lam-it" , "Itviec@gmail.com" , "Hải Phòng")) ;

    }

    @GetMapping(value = "/testlist", produces = "application/json")
    @ResponseBody
    public List<Employer> getEmployee(Model model) {
        return employers.values().stream().toList();
    }

    @GetMapping("/list")
    public String getEmployers(Model model) {
        var listEmployers = employers.values().stream().collect(Collectors.toList());
        model.addAttribute("listEmployers", listEmployers);
        return "list";
    }

    @GetMapping("/add")
    public String getEmployers1(Model model) {
        model.addAttribute("employer", new Employer(null, null, null, null, null));
        return "add";
    }

    @PostMapping ("/add")
    public String insertNewEmployers(Model model, @ModelAttribute("employer") Employer employer) {
        String uuid = UUID.randomUUID().toString();
        Employer newEmployer = new Employer(employer.id(), employer.name(), employer.website(), employer.email(),
                employer.address());
        employers.put(uuid, newEmployer);
        return "success";
    }
    @PutMapping( value = "/update/{id}")
    public Employer updateEmployer( @PathVariable ("id") String id , @RequestBody Employer employer) {
        Employer updateEmployer = new Employer(id , employer.name() , employer.website() , employer.email() , employer.address());
        employers.replace(id , updateEmployer) ;
        return updateEmployer ;
    }
    @DeleteMapping(value = "/{id}")
    public Employer deleteBookById(@PathVariable("id") String id) {
        Employer removedEmployer = employers.remove(id);
        return removedEmployer;
    }
}
