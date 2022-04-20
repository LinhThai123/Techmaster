package vn.techmaster.Hackathon_JobHut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.Hackathon_JobHut.model.City;
import vn.techmaster.Hackathon_JobHut.model.Job;
import vn.techmaster.Hackathon_JobHut.repositpry.EmployerRepository;
import vn.techmaster.Hackathon_JobHut.repositpry.JobRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired private JobRepository jobRepository ;
    @Autowired private EmployerRepository employerRepository ;

    @GetMapping()
    public String getListAllJob (Model model) {
        model.addAttribute("job" , jobRepository.getAll() ) ;
        return"job_list" ;
    }
    @GetMapping("/add")
    public String showAddJobForm (Model model ) {
        Job job = new Job() ;
        model.addAttribute("job" , job);
        model.addAttribute("name", employerRepository.getAll());
        model.addAttribute("city" , City.values());
        return "job_add" ;
    }
    @PostMapping("/add")
    public String saveJob( @ModelAttribute("job")Job job) {
        List<String> listId = new ArrayList<>(jobRepository.getIdJobs());
        if (listId.contains(job.getId())) {

            jobRepository.update(job);
        }else{
            jobRepository.addJob(job);
        }
        return "redirect:/job";
    }
    @GetMapping("/deletejob/{id}")
    public String deleteJob(@PathVariable String id) {
        jobRepository.deleteById(id);
        return "redirect:/job";
    }
}
