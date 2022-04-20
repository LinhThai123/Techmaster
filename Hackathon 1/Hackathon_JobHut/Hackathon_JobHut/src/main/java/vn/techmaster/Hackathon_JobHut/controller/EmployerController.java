package vn.techmaster.Hackathon_JobHut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.Hackathon_JobHut.model.Employer;
import vn.techmaster.Hackathon_JobHut.repositpry.EmployerRepository;
import vn.techmaster.Hackathon_JobHut.request.EmployerRequest;
import vn.techmaster.Hackathon_JobHut.service.StoragService;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/employer")
public class EmployerController {

    @Autowired private EmployerRepository employerRepository ;

    @Autowired private StoragService storagService ;

    @GetMapping()
    public String listAllEmployer (Model model) {
        model.addAttribute("employers" , employerRepository.getAll()) ;
        return "employer_list" ;
    }

    @GetMapping("/{id}")
    public String showEmployerFindById (Model model , @PathVariable String id) {
        model.addAttribute("employer" , employerRepository.findById(id));
        return "employer" ;
    }

    @GetMapping(value = "/add")
    public String addEmployer ( Model model) {
        model.addAttribute("employers" , new EmployerRequest("","","" ,"" , null)) ;
        return "employer_add" ;
    }
    @PostMapping(value = "/add", consumes = { "multipart/form-data" })
    public String addEmployer(@Valid @ModelAttribute("employer") EmployerRequest employerRequest, BindingResult result,
                              Model model) {
        if (employerRequest.logo().getOriginalFilename().isEmpty()) {
            result.addError(new FieldError("employer", "logo", "logo is required"));
        }
        // Nếu có lỗi trả về trình duyệt
        if (result.hasErrors()) {
            System.out.println("ERROR:" + result.toString());
            return "employer_add";
        }

        // Thêm vào cơ sở dữ liệu
        Employer emp = employerRepository.add(Employer.builder().name(employerRequest.name())
                .website(employerRequest.website()).email(employerRequest.email()).build());
        // Lưu logo vào ổ cứng
        try {
            String logoFileName = storagService.saveFile(employerRequest.logo(), emp.getId());
            employerRepository.updateLogoPath(emp.getId(), logoFileName);
        } catch (IOException e) {
            //Nếu lưu file bị lỗi thì hãy xóa bản ghi Employer
            e.printStackTrace();
        }

        return "redirect:/employer";
    }
}
